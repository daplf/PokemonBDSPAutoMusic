package daplf.pokemon.bdsp.automusic;

import java.io.IOException;

import daplf.pokemon.bdsp.automusic.game.GameManager;
import daplf.pokemon.bdsp.automusic.gui.GUI;
import daplf.pokemon.bdsp.automusic.utils.ConfigurationProperties;
import daplf.pokemon.bdsp.automusic.video.VideoCaptureManager;

public class App {

    /**
     * Setup OpenCV.
     */
    static {
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(final String[] args) throws IOException {
        AppArguments arguments = new AppArgumentsParser().parseArguments(args);

        setupConfigurationProperties(arguments);

        VideoCaptureManager videoCaptureManager = new VideoCaptureManager(arguments.getDevice(), arguments.getWidth(), arguments.getHeight());
        GameManager gameManager = new GameManager(videoCaptureManager);

        new Thread(() -> {
            GUI.start(gameManager, arguments.getSongManifestPath(), arguments.getSongManifestType());
            System.exit(0);
        }).start();

        gameManager.play();
    }

    private static void setupConfigurationProperties(final AppArguments appArguments) {
        // The image width/height factor is useful in situations where the game width/height is smaller than the camera output.
        // For example, when using the Streamlabs virtual camera, the camera outputs the entire scene,
        // which may contain other things (like splits, chat, etc). The width/height factor allows us to resize all templates accordingly.
        ConfigurationProperties.IMAGE_OFFSET_X = appArguments.getGameOffsetX();
        ConfigurationProperties.IMAGE_OFFSET_Y = appArguments.getGameOffsetY();
        ConfigurationProperties.IMAGE_WIDTH = appArguments.getGameWidth();
        ConfigurationProperties.IMAGE_HEIGHT = appArguments.getGameHeight();
        ConfigurationProperties.IMAGE_WIDTH_FACTOR = (double) appArguments.getGameWidth() / ConfigurationProperties.DEFAULT_WIDTH;
        ConfigurationProperties.IMAGE_HEIGHT_FACTOR = (double) appArguments.getGameHeight() / ConfigurationProperties.DEFAULT_HEIGHT;
    }
}

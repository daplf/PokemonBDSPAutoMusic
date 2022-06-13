package daplf.pokemon.bdsp.automusic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import daplf.pokemon.bdsp.automusic.game.GameManager;
import daplf.pokemon.bdsp.automusic.game.MusicManager;
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
        MusicManager musicManager = new MusicManager(getSongManifest(arguments.getSongManifestPath()));
        GameManager gameManager = new GameManager(videoCaptureManager, musicManager);

        gameManager.play();
    }

    private static Map<MusicManager.Song, String> getSongManifest(final String songManifestPath) throws IOException {
        HashMap<MusicManager.Song, String> songManifest = new HashMap<>();

        InputStream inputStream = new FileInputStream(songManifestPath);
        Properties properties = new Properties();
        properties.load(inputStream);

        songManifest.put(MusicManager.Song.TWINLEAF_TOWN_DAY, properties.getProperty("twinleaf-town-day"));
        songManifest.put(MusicManager.Song.TWINLEAF_TOWN_NIGHT, properties.getProperty("twinleaf-town-night"));
        songManifest.put(MusicManager.Song.ROUTE_201_DAY, properties.getProperty("route-201-day"));
        songManifest.put(MusicManager.Song.ROUTE_201_NIGHT, properties.getProperty("route-201-night"));
        songManifest.put(MusicManager.Song.BATTLE_WILD, properties.getProperty("battle-wild"));
        songManifest.put(MusicManager.Song.LAKE, properties.getProperty("lake"));
        songManifest.put(MusicManager.Song.CHOOSE_STARTER, properties.getProperty("choose-starter"));

        return songManifest;
    }

    private static void setupConfigurationProperties(final AppArguments appArguments) {
        // The image width/height factor is useful in situations where the game width/height is smaller than the camera output.
        // For example, when using the Streamlabs virtual camera, the camera outputs the entire scene,
        // which may contain other things (like splits, chat, etc). The width/height factor allows us to resize all templates accordingly.
        ConfigurationProperties.IMAGE_WIDTH_FACTOR = (double) appArguments.getGameWidth() / ConfigurationProperties.DEFAULT_WIDTH;
        ConfigurationProperties.IMAGE_HEIGHT_FACTOR = (double) appArguments.getGameHeight() / ConfigurationProperties.DEFAULT_HEIGHT;
    }
}

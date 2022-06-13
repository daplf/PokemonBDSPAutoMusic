package daplf.pokemon.bdsp.automusic.game;

import java.io.IOException;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.towns.TwinleafTownState;
import daplf.pokemon.bdsp.automusic.video.VideoCaptureManager;

public class GameManager {

    private VideoCaptureManager videoCaptureManager;

    private MusicManager musicManager;

    private State currentState = new TwinleafTownState();

    public GameManager(final VideoCaptureManager videoCaptureManager, final MusicManager musicManager) throws IOException {
        this.videoCaptureManager = videoCaptureManager;
        this.musicManager = musicManager;
    }

    public void play() {
        musicManager.play(currentState.getSong());

        while (true) {
            Mat currentFrame = videoCaptureManager.getCurrentFrame();

            if (currentFrame != null) {
                currentState.processFrame(currentFrame);
                currentState = currentState.getNextState();

                musicManager.play(currentState.getSong());
            }
        }
    }
}

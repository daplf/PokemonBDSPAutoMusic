package daplf.pokemon.bdsp.automusic.game;

import java.io.IOException;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.towns.TwinleafTownState;
import daplf.pokemon.bdsp.automusic.video.VideoCaptureManager;
import lombok.Getter;

public class GameManager {

    private VideoCaptureManager videoCaptureManager;

    @Getter
    private State currentState = new TwinleafTownState();

    public GameManager(final VideoCaptureManager videoCaptureManager) throws IOException {
        this.videoCaptureManager = videoCaptureManager;
    }

    public void play() {
        while (true) {
            Mat currentFrame = videoCaptureManager.getCurrentFrame();

            if (currentFrame != null) {
                synchronized(currentState) {
                    currentState.processFrame(currentFrame);
                    currentState = currentState.getNextState();
                }

                currentFrame.release();
            }
        }
    }

    public void setCurrentState(final State newState) {
        synchronized(currentState) {
            currentState = newState;
        }
    }
}

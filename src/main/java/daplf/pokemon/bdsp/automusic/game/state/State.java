package daplf.pokemon.bdsp.automusic.game.state;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import lombok.AccessLevel;
import lombok.Setter;

public abstract class State {

    private long startTime = System.currentTimeMillis();

    @Setter(AccessLevel.PROTECTED)
    private State nextState = this;

    public abstract void processFrame(Mat frame);
    
    public final State getNextState() {
        return nextState;
    }

    public abstract Song getSong();

    protected boolean fadedIn() {
        return System.currentTimeMillis() - startTime >= 2000;
    }
}

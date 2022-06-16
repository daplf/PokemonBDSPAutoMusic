package daplf.pokemon.bdsp.automusic.game.state;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;
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

    protected boolean isBattleGrass(final Mat frame) {
        return ImageUtils.matchTemplate(
            ImageUtils.getProportionalSubmat(frame, 0, 496, 0, 1920), StateIndicators.BATTLE_GRASS
        ) >= 0.8;
    }
}

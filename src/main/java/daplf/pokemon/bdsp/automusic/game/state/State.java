package daplf.pokemon.bdsp.automusic.game.state;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;
import lombok.AccessLevel;
import lombok.Setter;

public abstract class State {

    protected long startTime = System.currentTimeMillis();

    @Setter(AccessLevel.PROTECTED)
    private State nextState = this;

    public abstract void processFrame(Mat frame);
    
    public final State getNextState() {
        return nextState;
    }

    public abstract Songs getSong();

    protected boolean fadedIn() {
        return System.currentTimeMillis() - startTime >= 3000;
    }

    protected boolean isBattleGrass(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 496, 0, 1920);
        boolean dayResult = ImageUtils.matchTemplate(submat, StateIndicators.BATTLE_GRASS_DAY) >= 0.8;
        boolean sunsetResult = ImageUtils.matchTemplate(submat, StateIndicators.BATTLE_GRASS_SUNSET) >= 0.8;
        submat.release();
        return dayResult || sunsetResult;
    }

    protected boolean isBattleCave(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 350, 750, 0, 1920);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.BATTLE_CAVE) >= 0.9;
        submat.release();
        return result;
    }

    protected boolean isBattleTrainer(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 200, 430, 0, 1000);
        boolean result = ImageUtils.matchTemplateSqDiff(submat, StateIndicators.BATTLE_TRAINER_POKEBALL_RED) <= 0.1;
        submat.release();
        return result;
    }

    protected boolean isBattleGalacticGrunt(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 254, 1050, 1920);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.BATTLE_GALACTIC) >= 0.7;
        submat.release();
        return result;
    }

    protected boolean isBattleGalacticCommander(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 320, 750, 750, 1150);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.BATTLE_GALACTIC_COMMANDER) >= 0.9;
        submat.release();
        return result;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.buildings;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticCommanderBattleState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class GalacticHq4F2State extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (isBattleGalacticCommander(frame)) {
            setNextState(new GalacticCommanderBattleState(() -> new GalacticHqState()));
        } else if (isGalacticHqWall(frame)) {
            setNextState(new GalacticHqState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.DEEP_WITHIN_GALACTIC_HQ;
    }

    private boolean isGalacticHqWall(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 275, 525, 655, 800);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.GALACTIC_HQ_WALL) >= 0.8;
        submat.release();
        return result;
    }
}

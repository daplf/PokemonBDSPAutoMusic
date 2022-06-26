package daplf.pokemon.bdsp.automusic.game.state.buildings;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticBossBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticGruntBattleState;
import daplf.pokemon.bdsp.automusic.game.state.towns.VeilstoneCityState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class GalacticHqState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.VEILSTONE_CITY) >= 0.9 || isOutside(frame)) {
            setNextState(new VeilstoneCityState());
        } else if (isBattleGalacticGrunt(frame)) {
            setNextState(new GalacticGruntBattleState(() -> new GalacticHqState()));
        } else if (isBattleGalacticCommander(frame)) {
            setNextState(new GalacticBossBattleState(() -> new GalacticHqState()));
        } else if (isBasementWall(frame)) {
            setNextState(new GalacticHq4F2State());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.GALACTIC_HQ;
    }

    private boolean isOutside(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 870, 1080, 1020, 1340);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.GALACTIC_HQ_OUTSIDE_CONTAINER) >= 0.9;
        submat.release();
        return result;
    }

    private boolean isBasementWall(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 165, 425, 1105, 1650);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.GALACTIC_HQ_4F2_WALL) >= 0.9;
        submat.release();
        return result;
    }
}

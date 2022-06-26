package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticGruntPreBattleState;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route204State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route205State;
import daplf.pokemon.bdsp.automusic.game.state.special.WaitState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class FloaromaTownState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_204) >= 0.95) {
            setNextState(new Route204State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_205) >= 0.95) {
            setNextState(new Route205State());
        } else if (isExclamationMarks(frame)) {
            setNextState(new GalacticGruntPreBattleState(this, () -> new WaitState(2000, this, () -> new GalacticGruntPreBattleState(this, () -> new FloaromaTownState()))));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.FLOAROMA_TOWN_DAY;
    }

    private boolean isExclamationMarks(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 50, 225, 850, 1280);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.FLOAROMA_EXCLAMATION_MARKS) >= 0.9;
        submat.release();
        return result;
    }
}

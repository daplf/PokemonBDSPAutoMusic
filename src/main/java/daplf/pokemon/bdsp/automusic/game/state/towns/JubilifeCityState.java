package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticGruntPreBattleState;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route202State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route203State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route204State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route218State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class JubilifeCityState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_202) >= 0.97) {
            setNextState(new Route202State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_203) >= 0.95) {
            setNextState(new Route203State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_204) >= 0.95) {
            setNextState(new Route204State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_218) >= 0.95) {
            setNextState(new Route218State());
        } else if (isProfessorRowan(frame)) {
            setNextState(new GalacticGruntPreBattleState(this, () -> new JubilifeCityState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.JUBILIFE_CITY_DAY;
    }

    private boolean isProfessorRowan(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 110, 780, 985, 1440);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.PROFESSOR_ROWAN_JUBILIFE) >= 0.9;
        submat.release();
        return result;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.SurvivalAreaState;

public class Route226State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.SURVIVAL_AREA) >= 0.95) {
            setNextState(new SurvivalAreaState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_227) >= 0.95) {
            setNextState(new Route227State());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_225_DAY;
    }
}

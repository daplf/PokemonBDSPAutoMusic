package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.EternaCityState;

public class Route206State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ETERNA_CITY) >= 0.95) {
            setNextState(new EternaCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_207) >= 0.95) {
            setNextState(new Route207State());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_206_DAY;
    }
}

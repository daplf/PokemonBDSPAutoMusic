package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;

public class Route227State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_226) >= 0.95) {
            setNextState(new Route226State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.STARK_MOUNTAIN) >= 0.95) {
            setNextState(new StarkMountainState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_225_DAY;
    }
}

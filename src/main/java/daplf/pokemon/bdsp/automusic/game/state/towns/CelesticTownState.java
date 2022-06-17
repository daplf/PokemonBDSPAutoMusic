package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route210State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route211State;

public class CelesticTownState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_210) >= 0.99) {
            setNextState(new Route210State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_211) >= 0.95) {
            setNextState(new Route211State());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ETERNA_CITY_DAY;
    }
}

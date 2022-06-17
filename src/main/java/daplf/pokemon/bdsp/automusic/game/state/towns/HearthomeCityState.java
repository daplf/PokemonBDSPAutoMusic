package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route208State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route209State;

public class HearthomeCityState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_208) >= 0.99) {
            setNextState(new Route208State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_209) >= 0.95) {
            setNextState(new Route209State());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.HEARTHOME_CITY_DAY;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route214State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route215State;

public class VeilstoneCityState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_215) >= 0.99) {
            setNextState(new Route215State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_214) >= 0.95) {
            setNextState(new Route214State());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.VEILSTONE_CITY_DAY;
    }
}

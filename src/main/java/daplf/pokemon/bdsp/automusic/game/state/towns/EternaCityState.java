package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route205State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route206State;

public class EternaCityState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_205) >= 0.99) {
            setNextState(new Route205State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_206) >= 0.95) {
            setNextState(new Route206State());
        }
    }

    @Override
    public Song getSong() {
        return Song.ETERNA_CITY_DAY;
    }
}

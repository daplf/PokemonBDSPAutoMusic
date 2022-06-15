package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route222State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route223State;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;

public class SunyshoreCityState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_222) >= 0.99) {
            setNextState(new Route222State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_223) >= 0.95) {
            setNextState(new Route223State());
        }
    }

    @Override
    public Song getSong() {
        return Song.SUNYSHORE_CITY_DAY;
    }
}

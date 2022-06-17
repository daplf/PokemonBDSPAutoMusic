package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.SunyshoreCityState;

public class Route222State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);
        
        if (StateUtils.matchAreaTitle(frame, StateIndicators.VALOR_LAKEFRONT) >= 0.95) {
            setNextState(new ValorLakefrontState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.SUNYSHORE_CITY) >= 0.95) {
            setNextState(new SunyshoreCityState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_209_DAY;
    }
}

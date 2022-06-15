package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;

public class ValorLakefrontState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_214) >= 0.99) {
            setNextState(new Route214State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.LAKE_VALOR) >= 0.95) {
            setNextState(new LakeValorState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_213) >= 0.99) {
            setNextState(new Route213State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_222) >= 0.95) {
            setNextState(new Route222State());
        }
    }

    @Override
    public Song getSong() {
        return Song.VALOR_LAKEFRONT_DAY;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;

public class LakeValorState extends FlyableState {

    private static int noVisits = 0;

    public LakeValorState() {
        noVisits++;
    }

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);
        
        if (StateUtils.matchAreaTitle(frame, StateIndicators.VALOR_LAKEFRONT) >= 0.95) {
            setNextState(new ValorLakefrontState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.VALOR_CAVERN) >= 0.95) {
            setNextState(new ValorCavernState());
        }
    }

    @Override
    public Songs getSong() {
        if (noVisits < 2) {
            return Songs.GALACTIC_ETERNA_BUILDING;
        } else {
            return Songs.LAKE;
        }
    }
}

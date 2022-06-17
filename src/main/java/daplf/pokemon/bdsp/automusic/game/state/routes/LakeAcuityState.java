package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;

public class LakeAcuityState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);
        
        if (StateUtils.matchAreaTitle(frame, StateIndicators.ACUITY_LAKEFRONT) >= 0.95) {
            setNextState(new AcuityLakefrontState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.GALACTIC_ETERNA_BUILDING;
    }
}

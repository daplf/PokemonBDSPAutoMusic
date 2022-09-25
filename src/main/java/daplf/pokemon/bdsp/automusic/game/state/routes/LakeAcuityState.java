package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;

public class LakeAcuityState extends FlyableState {

    private static int noVisits = 0;

    public LakeAcuityState() {
        noVisits++;
    }

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);
        
        if (StateUtils.matchAreaTitle(frame, StateIndicators.ACUITY_LAKEFRONT) >= 0.95) {
            setNextState(new AcuityLakefrontState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ACUITY_CAVERN) >= 0.95) {
            setNextState(new AcuityCavernState());
        }
    }

    @Override
    public Songs getSong() {
        if (noVisits < 1) {
            return Songs.GALACTIC_ETERNA_BUILDING;
        } else {
            return Songs.LAKE;
        }
    }
}

package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.routes.AcuityLakefrontState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;

public class SnowpointCityState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ACUITY_LAKEFRONT) >= 0.95) {
            setNextState(new AcuityLakefrontState());
        }
    }

    @Override
    public Song getSong() {
        return Song.SNOWPOINT_CITY_DAY;
    }
}

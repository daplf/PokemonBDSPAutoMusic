package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.routes.AcuityLakefrontState;

public class SnowpointCityState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ACUITY_LAKEFRONT) >= 0.95) {
            setNextState(new AcuityLakefrontState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.SNOWPOINT_CITY_DAY;
    }
}

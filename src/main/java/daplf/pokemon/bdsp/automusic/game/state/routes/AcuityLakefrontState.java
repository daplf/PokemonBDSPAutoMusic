package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.SnowpointCityState;

public class AcuityLakefrontState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_217) >= 0.95) {
            setNextState(new Route217State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.LAKE_ACUITY) >= 0.95) {
            setNextState(new LakeAcuityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.SNOWPOINT_CITY) >= 0.95) {
            setNextState(new SnowpointCityState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_216_DAY;
    }
}

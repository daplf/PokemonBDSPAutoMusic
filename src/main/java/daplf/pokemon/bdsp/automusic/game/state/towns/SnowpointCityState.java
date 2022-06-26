package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.buildings.CandiceGymState;
import daplf.pokemon.bdsp.automusic.game.state.routes.AcuityLakefrontState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class SnowpointCityState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ACUITY_LAKEFRONT) >= 0.95) {
            setNextState(new AcuityLakefrontState());
        } else if (isGym(frame)) {
            setNextState(new CandiceGymState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.SNOWPOINT_CITY_DAY;
    }

    private boolean isGym(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 160, 50, 960);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.CANDICE_GYM_ICE) >= 0.8;
        submat.release();

        Mat submat2 = ImageUtils.getProportionalSubmat(frame, 255, 560, 615, 810);
        boolean result2 = ImageUtils.matchTemplate(submat2, StateIndicators.CANDICE_GYM_STATUE) >= 0.9;
        submat2.release();

        return result || result2;
    }
}

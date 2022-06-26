package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.buildings.VolknerGymState;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route222State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route223State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class SunyshoreCityState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_222) >= 0.95) {
            setNextState(new Route222State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_223) >= 0.95) {
            setNextState(new Route223State());
        } else if (isGym(frame)) {
            setNextState(new VolknerGymState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.SUNYSHORE_CITY_DAY;
    }

    private boolean isGym(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 30, 250, 425, 1085);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.VOLKNER_GYM_WALL) >= 0.8;
        submat.release();

        Mat submat2 = ImageUtils.getProportionalSubmat(frame, 615, 965, 1515, 1920);
        boolean result2 = ImageUtils.matchTemplate(submat2, StateIndicators.VOLKNER_GYM_FLOOR) >= 0.9;
        submat2.release();

        return result || result2;
    }
}

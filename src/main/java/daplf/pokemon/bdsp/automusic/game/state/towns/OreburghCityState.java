package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.buildings.RoarkGymState;
import daplf.pokemon.bdsp.automusic.game.state.routes.OreburghGateState;
import daplf.pokemon.bdsp.automusic.game.state.routes.OreburghMineState;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route207State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class OreburghCityState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.OREBURGH_GATE) >= 0.95) {
            setNextState(new OreburghGateState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_207) >= 0.95) {
            setNextState(new Route207State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.OREBURGH_MINE) >= 0.95) {
            setNextState(new OreburghMineState());
        } else if (isGymGuide(frame)) {
            setNextState(new RoarkGymState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.OREBURGH_CITY_DAY;
    }

    private boolean isGymGuide(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 675, 1080, 990, 1250);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.ROARK_GYM_GUIDE_CUTSCENE) >= 0.9;
        submat.release();

        Mat submat2 = ImageUtils.getProportionalSubmat(frame, 620, 950, 990, 1150);
        boolean result2 = ImageUtils.matchTemplate(submat2, StateIndicators.ROARK_GYM_GUIDE) >= 0.9;
        submat2.release();

        return result || result2;
    }
}

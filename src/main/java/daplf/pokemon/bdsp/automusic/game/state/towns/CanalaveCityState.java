package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.RivalBattleState;
import daplf.pokemon.bdsp.automusic.game.state.buildings.ByronGymState;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route218State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class CanalaveCityState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_218) >= 0.95) {
            setNextState(new Route218State());
        } else if (isBridgeCloseUp(frame)) {
            setNextState(new RivalBattleState(() -> new CanalaveCityState()));
        } else if (isGym(frame)) {
            setNextState(new ByronGymState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.CANALAVE_CITY_DAY;
    }

    private boolean isBridgeCloseUp(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 240, 1200, 1920);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.BATTLE_RIVAL_CANALAVE) >= 0.7;
        submat.release();
        return result;
    }

    private boolean isGym(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 90, 250, 690, 1550);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.BYRON_GYM_WALL) >= 0.8;
        submat.release();

        Mat submat2 = ImageUtils.getProportionalSubmat(frame, 90, 280, 1440, 1780);
        boolean result2 = ImageUtils.matchTemplate(submat2, StateIndicators.BYRON_GYM_ELEVATOR) >= 0.9;
        submat2.release();

        return result || result2;
    }
}

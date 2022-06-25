package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.RivalBattleState;
import daplf.pokemon.bdsp.automusic.game.state.buildings.FantinaGymState;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route208State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route209State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class HearthomeCityState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_208) >= 0.99) {
            setNextState(new Route208State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_209) >= 0.95) {
            setNextState(new Route209State());
        } else if (isBattleTrainer(frame)) {
            setNextState(new RivalBattleState(() -> new HearthomeCityState()));
        } else if (isGym(frame)) {
            setNextState(new FantinaGymState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.HEARTHOME_CITY_DAY;
    }

    private boolean isGym(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 405, 1000, 1550);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.FANTINA_GYM_ELEVATOR_STRINGS) >= 0.8;
        submat.release();

        Mat submat2 = ImageUtils.getProportionalSubmat(frame, 0, 135, 800, 1120);
        boolean result2 = ImageUtils.matchTemplate(submat2, StateIndicators.FANTINA_GYM_ELEVATOR) >= 0.9;
        submat2.release();

        return result || result2;
    }
}

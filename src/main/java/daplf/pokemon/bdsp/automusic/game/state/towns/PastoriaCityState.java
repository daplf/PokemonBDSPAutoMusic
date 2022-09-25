package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.RivalBattleState;
import daplf.pokemon.bdsp.automusic.game.state.buildings.WakeGymState;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route212State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route213State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class PastoriaCityState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_212) >= 0.95) {
            setNextState(new Route212State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_213) >= 0.95) {
            setNextState(new Route213State());
        } else if (isGym(frame)) {
            setNextState(new WakeGymState());
        } else if (isBattleTrainer(frame)) {
            setNextState(new RivalBattleState(() -> new PastoriaCityState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.SOLACEON_TOWN_DAY;
    }

    private boolean isGym(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 125, 300, 165, 500);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.WAKE_GYM_PLATE) >= 0.8;
        submat.release();

        Mat submat2 = ImageUtils.getProportionalSubmat(frame, 215, 414, 1110, 1275);
        boolean result2 = ImageUtils.matchTemplate(submat2, StateIndicators.WAKE_GYM_GUIDE) >= 0.9;
        submat2.release();

        return result || result2;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.buildings;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.TrainerBattleState;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route209State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class LostTowerState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_209) >= 0.9) {
            setNextState(new Route209State());
        } else if (isLostTowerOutside(frame)) {
            setNextState(new Route209State());
        } else if (isBattleLostTower(frame)) {
            setNextState(new TrainerBattleState(() -> new LostTowerState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ETERNA_FOREST;
    }

    private boolean isLostTowerOutside(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 10, 250, 880, 1050);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.LOST_TOWER) >= 0.9;
        submat.release();
        return result;
    }

    private boolean isBattleLostTower(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 650, 1000, 1920);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.BATTLE_LOST_TOWER) >= 0.8;
        submat.release();
        return result;
    }
}

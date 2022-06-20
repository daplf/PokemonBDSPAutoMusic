package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.WildBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.RivalPreBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.TrainerBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.JubilifeCityState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class Route203State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.JUBILIFE_CITY) >= 0.95) {
            setNextState(new JubilifeCityState());
        } else if (isBattleGrass(frame)) {
            setNextState(new WildBattleState(() -> new Route203State()));
        } else if (fadedIn() && ImageUtils.isBlackScreen(frame)) {
            setNextState(new OreburghGateState());
        } else if (isRival(frame)) {
            setNextState(new RivalPreBattleState(this, () -> new Route203State()));
        } else if (isBattleTrainer(frame)) {
            setNextState(new TrainerBattleState(() -> new Route203State()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_203_DAY;
    }

    private boolean isRival(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 110, 730, 840, 1280);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.RIVAL_ROUTE_203) >= 0.9;
        submat.release();
        return result;
    }
}

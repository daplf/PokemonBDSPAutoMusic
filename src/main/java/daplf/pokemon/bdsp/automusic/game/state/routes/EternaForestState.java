package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.TrainerBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.WildBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class EternaForestState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_205) >= 0.9) {
            setNextState(new Route205State());
        } else if (isBattleGrass(frame)) {
            setNextState(new WildBattleState(() -> new EternaForestState()));
        } else if (isBattleTrainerForest(frame)) {
            setNextState(new TrainerBattleState(() -> new EternaForestState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ETERNA_FOREST;
    }

    private boolean isBattleTrainerForest(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 330, 1200, 1920);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.BATTLE_TRAINER_FOREST) >= 0.7;
        submat.release();
        return result;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.LegendaryBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.TrainerBattleState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class StarkMountainCaveState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.STARK_MOUNTAIN) >= 0.95 || isOutside(frame)) {
            setNextState(new StarkMountainState());
        } else if (isBattleTrainer(frame)) {
            setNextState(new TrainerBattleState(() -> new StarkMountainCaveState()));
        } else if (heatranCry(frame)) {
            setNextState(new LegendaryBattleState(() -> new StarkMountainCaveState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.STARK_MOUNTAIN;
    }

    @Override
    protected boolean isBattleTrainer(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 200, 1050, 1920);
        boolean result = ImageUtils.matchTemplateSqDiff(submat, StateIndicators.BATTLE_TRAINER_VICTORY_ROAD) <= 0.1;
        submat.release();
        return result;
    }

    private boolean isOutside(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 435, 635, 1215, 1400);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.STARK_MOUNTAIN_SIGN) >= 0.8;
        submat.release();
        return result;
    }

    private boolean heatranCry(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 880, 1000, 400, 685);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.HEATRAN_CRY) >= 0.8;
        submat.release();
        return result;
    }
}

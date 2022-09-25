package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.TrainerBattleState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class IronIslandCaveState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.IRON_ISLAND) >= 0.95 || isOutside(frame)) {
            setNextState(new IronIslandState());
        } else if (isBattleTrainer(frame)) {
            setNextState(new TrainerBattleState(() -> new IronIslandCaveState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.OREBURGH_MINE;
    }

    @Override
    protected boolean isBattleTrainer(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 200, 1050, 1920);
        boolean result = ImageUtils.matchTemplateSqDiff(submat, StateIndicators.BATTLE_TRAINER_VICTORY_ROAD) <= 0.1;
        submat.release();
        return result;
    }

    private boolean isOutside(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 115, 435, 770, 1235);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.IRON_ISLAND_CAVE_ENTRANCE) >= 0.8;
        submat.release();
        return result;
    }
}

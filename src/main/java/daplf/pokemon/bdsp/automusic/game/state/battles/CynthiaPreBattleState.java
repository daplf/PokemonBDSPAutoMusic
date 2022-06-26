package daplf.pokemon.bdsp.automusic.game.state.battles;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class CynthiaPreBattleState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (isBattleCynthia(frame)) {
            setNextState(new CynthiaBattleState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.CYNTHIA_THEME;
    }

    private boolean isBattleCynthia(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 630, 1065, 0, 150);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.BATTLE_ELITE_FOUR) >= 0.7;
        submat.release();
        return result;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.special;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.battles.Cyrus2PreBattleState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class LakeLegendariesAppearState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (isBrokenLeftColumn(frame)) {
            setNextState(new Cyrus2PreBattleState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.LAKE_CAVERNS;
    }

    private boolean isBrokenLeftColumn(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 250, 0, 450);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.SPEAR_PILLAR_BROKEN_LEFT_COLUMN) >= 0.8;
        submat.release();
        return result;
    }
}

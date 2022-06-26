package daplf.pokemon.bdsp.automusic.game.state.battles;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.special.LakeLegendariesAppearState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MAndJPostBattleState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (isCyrusUpset(frame)) {
            setNextState(new LakeLegendariesAppearState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.SPEAR_PILLAR;
    }

    private boolean isCyrusUpset(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 260, 390, 760, 1020);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.CYRUS_EYE_UPSET) >= 0.8;
        submat.release();
        return result;
    }
}

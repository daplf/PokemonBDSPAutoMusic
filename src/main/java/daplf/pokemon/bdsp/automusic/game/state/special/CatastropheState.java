package daplf.pokemon.bdsp.automusic.game.state.special;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.routes.SpearPillarState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class CatastropheState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (isBrokenColumn(frame)) {
            setNextState(new SpearPillarState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.CATASTROPHE;
    }

    private boolean isBrokenColumn(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 128, 1050, 1200);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.SPEAR_PILLAR_BROKEN_COLUMN) >= 0.8;
        submat.release();
        return result;
    }
}

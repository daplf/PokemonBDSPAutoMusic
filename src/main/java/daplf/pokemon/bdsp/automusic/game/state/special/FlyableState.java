package daplf.pokemon.bdsp.automusic.game.state.special;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public abstract class FlyableState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (isStaraptorBanner(frame)) {
            setNextState(new FlyState(this));
        }
    }

    private boolean isStaraptorBanner(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 285, 785, 700, 1200);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.STARAPTOR_BANNER) >= 0.8;
        submat.release();
        return result;
    }
}

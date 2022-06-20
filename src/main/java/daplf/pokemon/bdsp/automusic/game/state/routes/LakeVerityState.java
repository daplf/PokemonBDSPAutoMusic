package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.special.ChooseStarterState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class LakeVerityState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (fadedIn() && ImageUtils.isBlackScreen(frame)) {
            setNextState(new VerityLakefrontState());
        } else if (isChooseStarter(frame)) {
            setNextState(new ChooseStarterState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.LAKE;
    }

    private boolean isChooseStarter(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 370, 1080, 1300, 1920);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.CHOOSE_STARTER_TREE_DAY) >= 0.9;
        submat.release();
        return result;
    }
}

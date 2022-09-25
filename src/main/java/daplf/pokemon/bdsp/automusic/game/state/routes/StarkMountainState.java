package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class StarkMountainState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_227) >= 0.95) {
            setNextState(new Route227State());
        } else if (isInside(frame)) {
            setNextState(new StarkMountainCaveState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_225_DAY;
    }

    private boolean isInside(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 400, 615, 420, 870);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.STARK_MOUNTAIN_ROCKS) >= 0.8;
        submat.release();
        return result;
    }
}

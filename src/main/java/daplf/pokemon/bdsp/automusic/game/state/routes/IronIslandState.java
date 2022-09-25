package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.CanalaveCityState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class IronIslandState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.CANALAVE_CITY) >= 0.95) {
            setNextState(new CanalaveCityState());
        } else if (isInside(frame)) {
            setNextState(new IronIslandCaveState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_203_DAY;
    }

    private boolean isInside(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 50, 280, 850, 1200);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.IRON_ISLAND_BARRELS) >= 0.8;
        submat.release();
        return result;
    }
}

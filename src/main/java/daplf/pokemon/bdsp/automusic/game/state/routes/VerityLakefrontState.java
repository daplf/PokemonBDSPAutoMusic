package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class VerityLakefrontState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (fadedIn() && ImageUtils.isBlackScreen(ImageUtils.getGameWindowSubmat(frame))) {
            setNextState(new LakeVerityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_201) >= 0.95) {
            setNextState(new Route201State());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_201_DAY;
    }
}

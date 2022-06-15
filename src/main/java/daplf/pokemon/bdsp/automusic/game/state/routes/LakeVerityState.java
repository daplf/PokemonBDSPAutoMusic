package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
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
    public Song getSong() {
        return Song.LAKE;
    }

    private boolean isChooseStarter(final Mat frame) {
        return ImageUtils.matchTemplate(frame, StateIndicators.CHOOSE_STARTER_DAY) >= 0.95
               || ImageUtils.matchTemplate(frame, StateIndicators.CHOOSE_STARTER_NIGHT) >= 0.95;
    }
}

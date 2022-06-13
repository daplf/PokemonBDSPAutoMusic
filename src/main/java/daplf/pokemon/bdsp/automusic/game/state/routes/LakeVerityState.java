package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.special.ChooseStarterState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class LakeVerityState extends State {

    private static final Mat CHOOSE_STARTER_DAY_INDICATOR = ImageUtils.getImageResource("choose-starter-day.png");
    private static final Mat CHOOSE_STARTER_NIGHT_INDICATOR = ImageUtils.getImageResource("choose-starter-night.png");

    @Override
    public void processFrame(final Mat frame) {
        if (fadedIn() && ImageUtils.isBlackScreen(frame)) {
            setNextState(new VerityLakefrontState());
        } else if (ImageUtils.matchTemplate(frame, CHOOSE_STARTER_DAY_INDICATOR) >= 0.9 || ImageUtils.matchTemplate(frame, CHOOSE_STARTER_NIGHT_INDICATOR) >= 0.9) {
            setNextState(new ChooseStarterState());
        }
    }

    @Override
    public Song getSong() {
        return Song.LAKE;
    }
}

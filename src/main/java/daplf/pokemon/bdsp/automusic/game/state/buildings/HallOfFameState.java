package daplf.pokemon.bdsp.automusic.game.state.buildings;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.special.CongratulationsState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HallOfFameState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (fadedIn() && isBlackScreenIgnoreSaving(frame)) {
            setNextState(new CongratulationsState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.HALL_OF_FAME;
    }

    private boolean isBlackScreenIgnoreSaving(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 1080, 0, 1500);
        boolean result = ImageUtils.isBlackScreen(submat);
        submat.release();
        return result;
    }
}

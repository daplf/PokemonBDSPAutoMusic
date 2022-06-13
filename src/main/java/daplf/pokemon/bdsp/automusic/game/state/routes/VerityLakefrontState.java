package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class VerityLakefrontState extends State {

    private static final Mat ROUTE_201_INDICATOR = ImageUtils.getImageResource("route-201.png");

    @Override
    public void processFrame(final Mat frame) {
        if (fadedIn() && ImageUtils.isBlackScreen(frame)) {
            setNextState(new LakeVerityState());
        } else if (ImageUtils.matchTemplate(frame, ROUTE_201_INDICATOR) >= 0.9) {
            setNextState(new Route201State());
        }
    }

    @Override
    public Song getSong() {
        return Song.ROUTE_201_DAY;
    }
}

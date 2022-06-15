package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class ValleyWindworksPowerplantState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (fadedIn() && ImageUtils.isWhiteScreen(frame)) {
            setNextState(new ValleyWindworksState());
        }
    }

    @Override
    public Song getSong() {
        return Song.GALACTIC_ETERNA_BUILDING;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
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
    public Songs getSong() {
        return Songs.GALACTIC_ETERNA_BUILDING;
    }
}

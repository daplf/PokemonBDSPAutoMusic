package daplf.pokemon.bdsp.automusic.game.state.special;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;

public class CreditsState extends State {

    @Override
    public void processFrame(final Mat frame) { }

    @Override
    public Songs getSong() {
        return Songs.ENDING_THEME;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.special;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;

public class LegendaryAppearsState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchNameTag(frame, StateIndicators.BOSS_NAME_TAG) >= 0.9) {
            setNextState(new LegendaryAppearsClosingState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.LEGENDARY_APPEARS;
    }
}

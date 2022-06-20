package daplf.pokemon.bdsp.automusic.game.state.special;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.battles.WildBattleState;
import daplf.pokemon.bdsp.automusic.game.state.routes.LakeVerityState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class ChooseStarterState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (ImageUtils.matchTemplate(frame, StateIndicators.FIRST_FIGHT) >= 0.5) {
            setNextState(new WildBattleState(() -> new LakeVerityState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.CHOOSE_STARTER;
    }
}

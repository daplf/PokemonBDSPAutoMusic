package daplf.pokemon.bdsp.automusic.game.state.special;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.battles.BattleGrassState;
import daplf.pokemon.bdsp.automusic.game.state.routes.LakeVerityState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class ChooseStarterState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (ImageUtils.matchTemplate(frame, StateIndicators.FIRST_FIGHT) >= 0.5) {
            setNextState(new BattleGrassState(() -> new LakeVerityState()));
        }
    }

    @Override
    public Song getSong() {
        return Song.CHOOSE_STARTER;
    }
}

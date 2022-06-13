package daplf.pokemon.bdsp.automusic.game.state.battles;

import java.util.function.Supplier;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class BattleGrassState extends State {

    private Supplier<State> postBattleStateSupplier;

    public BattleGrassState(final Supplier<State> postBattleStateSupplier) {
        this.postBattleStateSupplier = postBattleStateSupplier;
    }

    @Override
    public void processFrame(final Mat frame) {
        if (fadedIn() && ImageUtils.isBlackScreen(frame)) {
            setNextState(postBattleStateSupplier.get());
        }
    }

    @Override
    public Song getSong() {
        return Song.BATTLE_WILD;
    }
}

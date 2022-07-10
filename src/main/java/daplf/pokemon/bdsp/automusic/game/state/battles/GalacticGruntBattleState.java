package daplf.pokemon.bdsp.automusic.game.state.battles;

import java.util.function.Supplier;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class GalacticGruntBattleState extends BattleState {

    private final Supplier<State> postBattleStateSupplier;

    public GalacticGruntBattleState(final Supplier<State> postBattleStateSupplier) {
        super(() -> new GalacticVictoryState(postBattleStateSupplier));
        this.postBattleStateSupplier = postBattleStateSupplier;
    }

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);
        
        if (fadedIn() && ImageUtils.isBlackScreenFrame(frame)) {
            setNextState(postBattleStateSupplier.get());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.BATTLE_GALACTIC_GRUNT;
    }

    @Override
    protected boolean fadedIn() {
        return System.currentTimeMillis() - startTime >= 7000;
    }
}

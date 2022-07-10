package daplf.pokemon.bdsp.automusic.game.state.battles;

import java.util.function.Supplier;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class RivalBattleState extends BattleState {

    private final Supplier<State> postBattleStateSupplier;

    public RivalBattleState(final Supplier<State> postBattleStateSupplier) {
        super(() -> new TrainerVictoryState(postBattleStateSupplier));
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
        return Songs.BATTLE_RIVAL;
    }

    @Override
    protected boolean fadedIn() {
        return System.currentTimeMillis() - startTime >= 7000;
    }
}

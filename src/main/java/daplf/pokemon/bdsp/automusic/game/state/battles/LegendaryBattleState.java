package daplf.pokemon.bdsp.automusic.game.state.battles;

import java.util.function.Supplier;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LegendaryBattleState extends State {

    private final Supplier<State> postBattleStateSupplier;

    @Override
    public void processFrame(final Mat frame) {
        if (fadedIn() && ImageUtils.isBlackScreenFrame(frame)) {
            setNextState(postBattleStateSupplier.get());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.BATTLE_LEGENDARY;
    }

    @Override
    protected boolean fadedIn() {
        return System.currentTimeMillis() - startTime >= 7000;
    }
}

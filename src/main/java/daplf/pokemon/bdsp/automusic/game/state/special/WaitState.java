package daplf.pokemon.bdsp.automusic.game.state.special;

import java.util.function.Supplier;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import lombok.RequiredArgsConstructor;

/**
 * This is a helper state that waits for a configurable amount of time before changing to a different state.
 */
@RequiredArgsConstructor
public class WaitState extends State {

    private final int waitTimeMs;

    private final State previousState;

    private final Supplier<State> nextStateSupplier;

    @Override
    public void processFrame(final Mat frame) {
        if (System.currentTimeMillis() - startTime >= waitTimeMs) {
            setNextState(nextStateSupplier.get());
        }
    }

    @Override
    public Songs getSong() {
        return previousState.getSong();
    }
}

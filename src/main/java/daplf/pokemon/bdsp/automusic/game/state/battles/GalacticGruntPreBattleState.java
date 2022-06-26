package daplf.pokemon.bdsp.automusic.game.state.battles;

import java.util.function.Supplier;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GalacticGruntPreBattleState extends State {

    private final State previousState;

    private final Supplier<State> postBattleStateSupplier;

    @Override
    public void processFrame(final Mat frame) {
        if (ImageUtils.isBlackScreenFrame(frame)) {
            setNextState(new GalacticGruntBattleState(postBattleStateSupplier));
        }
    }

    @Override
    public Songs getSong() {
        return previousState.getSong();
    }
}

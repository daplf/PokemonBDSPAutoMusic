package daplf.pokemon.bdsp.automusic.game.state.battles;

import java.util.function.Supplier;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BattleState extends State {

    private final Supplier<State> victoryStateSupplier;
    
    @Override
    public void processFrame(final Mat frame) {
        if (youDefeated(frame)) {
            setNextState(victoryStateSupplier.get());
        }
    }

    private boolean youDefeated(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 880, 960, 130, 510);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.YOU_DEFEATED) >= 0.8;
        submat.release();
        return result;
    }
}

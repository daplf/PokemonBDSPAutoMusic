package daplf.pokemon.bdsp.automusic.game.state.battles;

import java.util.function.Supplier;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EliteFourPreBattleState extends State {

    private final Supplier<State> postBattleStateSupplier;

    @Override
    public void processFrame(final Mat frame) {
        if (isBattleEliteFour(frame)) {
            setNextState(new EliteFourBattleState(postBattleStateSupplier));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ELITE_FOUR_APPEARS;
    }

    private boolean isBattleEliteFour(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 630, 1065, 0, 150);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.BATTLE_ELITE_FOUR) >= 0.7;
        submat.release();
        return result;
    }
}

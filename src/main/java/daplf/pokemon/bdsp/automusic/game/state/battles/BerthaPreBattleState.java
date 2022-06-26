package daplf.pokemon.bdsp.automusic.game.state.battles;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.buildings.BerthaRoomState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class BerthaPreBattleState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (isBattleEliteFour(frame)) {
            setNextState(new EliteFourBattleState(() -> new BerthaRoomState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ELITE_FOUR_APPEARS;
    }

    private boolean isBattleEliteFour(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 630, 1065, 0, 150);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.BATTLE_ELITE_FOUR) >= 0.5;
        submat.release();
        return result;
    }
}

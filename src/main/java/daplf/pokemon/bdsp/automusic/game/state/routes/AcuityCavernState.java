package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.AzelfMespritUxieBattleState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class AcuityCavernState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.LAKE_ACUITY) >= 0.95) {
            setNextState(new LakeAcuityState());
        } else if (uxieCry(frame)) {
            setNextState(new AzelfMespritUxieBattleState(() -> new AcuityCavernState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.LAKE_CAVERNS;
    }
    
    private boolean uxieCry(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 880, 1000, 390, 720);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.UXIE_CRY) >= 0.8;
        submat.release();
        return result;
    }
}

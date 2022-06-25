package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticGruntBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class ValorLakefrontState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_214) >= 0.99) {
            setNextState(new Route214State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.LAKE_VALOR) >= 0.95) {
            setNextState(new LakeValorState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_213) >= 0.99) {
            setNextState(new Route213State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_222) >= 0.95) {
            setNextState(new Route222State());
        } else if (isBattleGalacticGrunt(frame)) {
            setNextState(new GalacticGruntBattleState(() -> new ValorLakefrontState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.VALOR_LAKEFRONT_DAY;
    }

    @Override
    protected boolean isBattleGalacticGrunt(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 440, 1250, 1920);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.BATTLE_VALOR_LAKEFRONT_SUNSET) >= 0.8;
        submat.release();

        Mat submat2 = ImageUtils.getProportionalSubmat(frame, 0, 260, 1250, 1920);
        boolean result2 = ImageUtils.matchTemplate(submat2, StateIndicators.BATTLE_VALOR_LAKEFRONT_NIGHT) >= 0.8;
        submat2.release();

        return result || result2;
    }
}

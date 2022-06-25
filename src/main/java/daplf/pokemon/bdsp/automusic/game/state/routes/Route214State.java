package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.TrainerBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.VeilstoneCityState;

public class Route214State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.VEILSTONE_CITY) >= 0.95) {
            setNextState(new VeilstoneCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.VALOR_LAKEFRONT) >= 0.95) {
            setNextState(new ValorLakefrontState());
        } else if (isBattleTrainer(frame)) {
            setNextState(new TrainerBattleState(() -> new Route214State()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_210_DAY;
    }
}

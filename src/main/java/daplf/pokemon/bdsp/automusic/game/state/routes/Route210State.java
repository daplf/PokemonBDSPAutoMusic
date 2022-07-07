package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.TrainerBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.CelesticTownState;
import daplf.pokemon.bdsp.automusic.game.state.towns.SolaceonTownState;

public class Route210State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.SOLACEON_TOWN) >= 0.95) {
            setNextState(new SolaceonTownState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_215_15) >= 0.95) {
            setNextState(new Route215State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.CELESTIC_TOWN) >= 0.95) {
            setNextState(new CelesticTownState());
        } else if (isBattleTrainer(frame)) {
            setNextState(new TrainerBattleState(() -> new Route210State()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_210_DAY;
    }
}

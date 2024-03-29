package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.TrainerBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.WildBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.HearthomeCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.PastoriaCityState;

public class Route212State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.HEARTHOME_CITY) >= 0.95) {
            setNextState(new HearthomeCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.PASTORIA_CITY) >= 0.95) {
            setNextState(new PastoriaCityState());
        } else if (isBattleTrainer(frame)) {
            setNextState(new TrainerBattleState(() -> new Route212State()));
        } else if (isBattleWater(frame)) {
            setNextState(new WildBattleState(() -> new Route212State()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_209_DAY;
    }
}

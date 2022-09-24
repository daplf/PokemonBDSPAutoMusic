package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.WildBattleState;
import daplf.pokemon.bdsp.automusic.game.state.towns.OreburghCityState;

public class OreburghMineState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.OREBURGH_CITY) >= 0.95) {
            setNextState(new OreburghCityState());
        } else if (isBattleCave(frame)) {
            setNextState(new WildBattleState(() -> new OreburghMineState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.OREBURGH_MINE;
    }
}

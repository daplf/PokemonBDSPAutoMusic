package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticCommanderBattleState;

public class ValorCavernState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.LAKE_VALOR) >= 0.95) {
            setNextState(new LakeValorState());
        } else if (isBattleGalacticCommander(frame)) {
            setNextState(new GalacticCommanderBattleState(() -> new ValorCavernState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.GALACTIC_ETERNA_BUILDING;
    }
}

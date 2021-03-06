package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.WildBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.FloaromaTownState;
import daplf.pokemon.bdsp.automusic.game.state.towns.JubilifeCityState;

public class Route204State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.JUBILIFE_CITY) >= 0.95) {
            setNextState(new JubilifeCityState());
        } else if (isBattleGrass(frame)) {
            setNextState(new WildBattleState(() -> new Route204State()));
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.RAVAGED_PATH) >= 0.95) {
            setNextState(new RavagedPathState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.FLOAROMA_TOWN) >= 0.95) {
            setNextState(new FloaromaTownState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_203_DAY;
    }
}

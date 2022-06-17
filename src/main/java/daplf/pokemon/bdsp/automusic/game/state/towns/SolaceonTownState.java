package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route209State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route210State;

public class SolaceonTownState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_209) >= 0.99) {
            setNextState(new Route209State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_210) >= 0.95) {
            setNextState(new Route210State());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.SOLACEON_TOWN_DAY;
    }
}

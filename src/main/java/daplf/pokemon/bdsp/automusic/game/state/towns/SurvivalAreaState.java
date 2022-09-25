package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route225State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route226State;

public class SurvivalAreaState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_205_5) >= 0.95) {
            setNextState(new Route225State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_206_6) >= 0.95) {
            setNextState(new Route226State());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.FIGHT_AREA_DAY;
    }
}

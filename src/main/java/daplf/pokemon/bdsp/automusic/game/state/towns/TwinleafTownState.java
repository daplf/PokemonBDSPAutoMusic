package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route201State;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;

public class TwinleafTownState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);
        
        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_201) >= 0.95) {
            setNextState(new Route201State());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.TWINLEAF_TOWN_DAY;
    }
}

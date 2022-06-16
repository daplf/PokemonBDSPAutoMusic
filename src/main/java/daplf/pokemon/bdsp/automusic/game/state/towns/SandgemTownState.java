package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route201State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route202State;

public class SandgemTownState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_201) >= 0.99) {
            setNextState(new Route201State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_202) >= 0.95) {
            setNextState(new Route202State());
        }
    }

    @Override
    public Song getSong() {
        return Song.SANDGEM_TOWN_DAY;
    }
}

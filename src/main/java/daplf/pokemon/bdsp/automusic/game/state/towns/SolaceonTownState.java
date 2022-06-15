package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route209State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route210State;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;

public class SolaceonTownState extends FlyableState {

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
    public Song getSong() {
        return Song.SOLACEON_TOWN_DAY;
    }
}

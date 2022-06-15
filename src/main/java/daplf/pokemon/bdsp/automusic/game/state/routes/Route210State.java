package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.CelesticTownState;
import daplf.pokemon.bdsp.automusic.game.state.towns.SolaceonTownState;

public class Route210State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.SOLACEON_TOWN) >= 0.95) {
            setNextState(new SolaceonTownState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_215) >= 0.99) {
            setNextState(new Route215State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.CELESTIC_TOWN) >= 0.95) {
            setNextState(new CelesticTownState());
        }
    }

    @Override
    public Song getSong() {
        return Song.ROUTE_210_DAY;
    }
}

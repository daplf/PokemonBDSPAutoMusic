package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route202State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route203State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route204State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route218State;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;

public class JubilifeCityState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_202) >= 0.99) {
            setNextState(new Route202State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_203) >= 0.99) {
            setNextState(new Route203State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_204) >= 0.95) {
            setNextState(new Route204State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_218) >= 0.95) {
            setNextState(new Route218State());
        }
    }

    @Override
    public Song getSong() {
        return Song.JUBILIFE_CITY_DAY;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.routes.OreburghGateState;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route207State;

public class OreburghCityState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.OREBURGH_GATE) >= 0.95) {
            setNextState(new OreburghGateState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_207) >= 0.95) {
            setNextState(new Route207State());
        }
    }

    @Override
    public Song getSong() {
        return Song.OREBURGH_CITY_DAY;
    }
}

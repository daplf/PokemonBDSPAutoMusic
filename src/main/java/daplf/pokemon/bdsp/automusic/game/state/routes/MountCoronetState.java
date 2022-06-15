package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;

public class MountCoronetState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_207) >= 0.99) {
            setNextState(new Route207State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_208) >= 0.99) {
            setNextState(new Route208State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_211) >= 0.99) {
            setNextState(new Route211State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_216) >= 0.95) {
            setNextState(new Route216State());
        }
    }

    @Override
    public Song getSong() {
        return Song.OREBURGH_GATE;
    }
}

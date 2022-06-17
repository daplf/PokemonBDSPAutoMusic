package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.CelesticTownState;

public class Route211State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.CELESTIC_TOWN) >= 0.95) {
            setNextState(new CelesticTownState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.MOUNT_CORONET) >= 0.95) {
            setNextState(new MountCoronetState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_210_DAY;
    }
}

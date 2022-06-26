package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class MountCoronetState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_207) >= 0.95) {
            setNextState(new Route207State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_208) >= 0.95) {
            setNextState(new Route208State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_211) >= 0.95) {
            setNextState(new Route211State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_216) >= 0.95) {
            setNextState(new Route216State());
        } else if (isNearTop(frame)) {
            setNextState(new MountCoronetNearTopState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.OREBURGH_GATE;
    }

    private boolean isNearTop(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 650, 1080, 0, 550);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.MOUNT_CORONET_SNOW) >= 0.9;
        submat.release();
        return result;
    }
}

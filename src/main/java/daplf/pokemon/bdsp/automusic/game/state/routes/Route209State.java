package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.buildings.LostTowerState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.HearthomeCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.SolaceonTownState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class Route209State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.HEARTHOME_CITY) >= 0.95) {
            setNextState(new HearthomeCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.SOLACEON_TOWN) >= 0.95) {
            setNextState(new SolaceonTownState());
        } else if (isLostTowerGrave(frame)) {
            setNextState(new LostTowerState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_209_DAY;
    }

    private boolean isLostTowerGrave(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 225, 420, 870, 1070);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.LOST_TOWER_GRAVE) >= 0.9;
        submat.release();
        return result;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.buildings.EternaGalacticBuildingState;
import daplf.pokemon.bdsp.automusic.game.state.buildings.GardeniaGymState;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route205State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route206State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class EternaCityState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_205) >= 0.99) {
            setNextState(new Route205State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_206) >= 0.95) {
            setNextState(new Route206State());
        } else if (isGymWall(frame)) {
            setNextState(new GardeniaGymState());
        } else if (isGalacticBuildingShelf(frame)) {
            setNextState(new EternaGalacticBuildingState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ETERNA_CITY_DAY;
    }

    private boolean isGymWall(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 180, 520, 240, 680);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.GARDENIA_GYM_WALL) >= 0.9;
        submat.release();
        return result;
    }

    private boolean isGalacticBuildingShelf(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 150, 360, 570, 800);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.ETERNA_GALACTIC_BUILDING_SHELF) >= 0.9;
        submat.release();
        return result;
    }
}

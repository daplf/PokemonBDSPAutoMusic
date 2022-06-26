package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticGruntBattleState;
import daplf.pokemon.bdsp.automusic.game.state.buildings.GalacticHqState;
import daplf.pokemon.bdsp.automusic.game.state.buildings.MayleneGymState;
import daplf.pokemon.bdsp.automusic.game.state.buildings.VeilstoneDepartmentStoreState;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route214State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route215State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class VeilstoneCityState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_215) >= 0.95) {
            setNextState(new Route215State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_214) >= 0.95) {
            setNextState(new Route214State());
        } else if (isDepartmentStore(frame)) {
            setNextState(new VeilstoneDepartmentStoreState());
        } else if (isGym(frame)) {
            setNextState(new MayleneGymState());
        } else if (isBattleGalacticGrunt(frame)) {
            setNextState(new GalacticGruntBattleState(() -> new VeilstoneCityState()));
        } else if (isGalacticHq(frame)) {
            setNextState(new GalacticHqState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.VEILSTONE_CITY_DAY;
    }

    private boolean isDepartmentStore(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 360, 715, 735, 1080);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.VEILSTONE_DEPARTMENT_STORE_SIGN) >= 0.9;
        submat.release();
        return result;
    }

    private boolean isGym(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 175, 415, 880, 1060);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.MAYLENE_GYM_BLACK_BELT) >= 0.8;
        submat.release();

        Mat submat2 = ImageUtils.getProportionalSubmat(frame, 515, 760, 1010, 1190);
        boolean result2 = ImageUtils.matchTemplate(submat2, StateIndicators.MAYLENE_GYM_GUIDE) >= 0.9;
        submat2.release();

        return result || result2;
    }

    private boolean isGalacticHq(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 295, 370, 770, 1040);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.GALACTIC_HQ_LAMP) >= 0.9;
        submat.release();

        Mat submat2 = ImageUtils.getProportionalSubmat(frame, 280, 480, 185, 435);
        boolean result2 = ImageUtils.matchTemplate(submat2, StateIndicators.GALACTIC_HQ_FLOOR_SIGN) >= 0.9;
        submat2.release();

        return result || result2;
    }
}

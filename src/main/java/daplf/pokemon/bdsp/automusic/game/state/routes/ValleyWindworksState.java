package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticGruntBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.WildBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class ValleyWindworksState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (isPowerplantFloor(frame) || isPowerplantLamp(frame)) {
            setNextState(new ValleyWindworksPowerplantState());
        } else if (isBattleGrass(frame)) {
            setNextState(new WildBattleState(() -> new ValleyWindworksState()));
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_205) >= 0.95) {
            setNextState(new Route205State());
        } else if (isBattleGalacticGrunt(frame)) {
            setNextState(new GalacticGruntBattleState(() -> new ValleyWindworksState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_205_DAY;
    }

    private boolean isPowerplantFloor(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 325, 750, 1200, 1750);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.VALLEY_WINDWORKS_FLOOR) >= 0.8;
        submat.release();
        return result;
    }

    private boolean isPowerplantLamp(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 300, 400, 400, 800);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.VALLEY_WINDWORKS_LAMP) >= 0.8;
        submat.release();
        return result;
    }
}

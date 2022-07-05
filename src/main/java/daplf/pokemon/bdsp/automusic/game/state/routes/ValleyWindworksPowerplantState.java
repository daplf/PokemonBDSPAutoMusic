package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticCommanderBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticGruntBattleState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class ValleyWindworksPowerplantState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (isValleyWindworksSign(frame)) {
            setNextState(new ValleyWindworksState());
        } else if (isBattleGalacticGrunt(frame)) {
            setNextState(new GalacticGruntBattleState(() -> new ValleyWindworksPowerplantState()));
        } else if (isBattleGalacticCommander(frame)) {
            setNextState(new GalacticCommanderBattleState(() -> new ValleyWindworksPowerplantState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.GALACTIC_ETERNA_BUILDING;
    }

    private boolean isValleyWindworksSign(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 780, 955, 445, 615);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.VALLEY_WINDWORKS_SIGN) >= 0.9;
        submat.release();
        return result;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticGruntPreBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.WildBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class ValleyWindworksState extends FlyableState {

    private static boolean encounteredGrunt = false;

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (fadedIn() && ImageUtils.isBlackScreen(frame)) {
            setNextState(new ValleyWindworksPowerplantState());
        } else if (isBattleGrass(frame)) {
            setNextState(new WildBattleState(() -> new ValleyWindworksState()));
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_205) >= 0.95) {
            setNextState(new Route205State());
        } else if (!encounteredGrunt && StateUtils.matchNameTag(frame, StateIndicators.GRUNT_NAME_TAG) >= 0.95) {
            encounteredGrunt = true;
            setNextState(new GalacticGruntPreBattleState(this, () -> new ValleyWindworksState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_205_DAY;
    }
}

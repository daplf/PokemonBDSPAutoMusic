package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.WildBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class ValleyWindworksState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (fadedIn() && ImageUtils.isBlackScreen(frame)) {
            setNextState(new ValleyWindworksPowerplantState());
        } else if (isBattleGrass(frame)) {
            setNextState(new WildBattleState(() -> new ValleyWindworksState()));
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_205) >= 0.95) {
            setNextState(new Route205State());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_205_DAY;
    }
}

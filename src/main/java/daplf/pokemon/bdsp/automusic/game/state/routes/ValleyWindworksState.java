package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.BattleGrassState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class ValleyWindworksState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (fadedIn() && ImageUtils.isBlackScreen(frame)) {
            setNextState(new ValleyWindworksPowerplantState());
        } else if (isBattleGrass(frame)) {
            setNextState(new BattleGrassState(() -> new ValleyWindworksState()));
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_205) >= 0.95) {
            setNextState(new Route205State());
        }
    }

    @Override
    public Song getSong() {
        return Song.ROUTE_205_DAY;
    }
}

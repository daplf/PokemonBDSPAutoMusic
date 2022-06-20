package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.WildBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.EternaCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.FloaromaTownState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class Route205State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.FLOAROMA_TOWN) >= 0.95) {
            setNextState(new FloaromaTownState());
        } else if (isBattleGrass(frame)) {
            setNextState(new WildBattleState(() -> new Route205State()));
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.VALLEY_WINDWORKS) >= 0.95) {
            setNextState(new ValleyWindworksState());
        } else if (fadedIn() && ImageUtils.isBlackScreen(frame)) {
            setNextState(new EternaForestState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ETERNA_CITY) >= 0.95) {
            setNextState(new EternaCityState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_205_DAY;
    }
}

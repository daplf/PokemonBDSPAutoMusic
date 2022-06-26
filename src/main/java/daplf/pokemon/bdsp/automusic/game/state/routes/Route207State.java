package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.WildBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.OreburghCityState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class Route207State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.OREBURGH_CITY) >= 0.95) {
            setNextState(new OreburghCityState());
        } else if (isBattleGrass(frame)) {
            setNextState(new WildBattleState(() -> new Route207State()));
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_206) >= 0.95) {
            setNextState(new Route206State());
        } else if (fadedIn() && ImageUtils.isBlackScreenFrame(frame)) {
            setNextState(new MountCoronetState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_206_DAY;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.WildBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.SandgemTownState;
import daplf.pokemon.bdsp.automusic.game.state.towns.TwinleafTownState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class Route201State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if ((fadedIn() && ImageUtils.isBlackScreen(frame)) || StateUtils.matchAreaTitle(frame, StateIndicators.TWINLEAF_TOWN) >= 0.95) {
            setNextState(new TwinleafTownState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.VERITY_LAKEFRONT) >= 0.95) {
            setNextState(new VerityLakefrontState());
        } else if (isBattleGrass(frame)) {
            setNextState(new WildBattleState(() -> new Route201State()));
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.SANDGEM_TOWN) >= 0.95) {
            setNextState(new SandgemTownState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_201_DAY;
    }
}

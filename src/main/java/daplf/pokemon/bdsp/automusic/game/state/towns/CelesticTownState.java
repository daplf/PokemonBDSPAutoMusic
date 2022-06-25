package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticGruntBattleState;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route210State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route211State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class CelesticTownState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_210) >= 0.99) {
            setNextState(new Route210State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_211) >= 0.95) {
            setNextState(new Route211State());
        } else if (isBattleGalacticGrunt(frame)) {
            setNextState(new GalacticGruntBattleState(() -> new CelesticTownState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ETERNA_CITY_DAY;
    }

    @Override
    protected boolean isBattleGalacticGrunt(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 254, 1050, 1920);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.BATTLE_GALACTIC) >= 0.8;
        submat.release();
        return result;
    }
}

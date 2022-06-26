package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticGruntBattleState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class MountCoronetNearTopState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_207) >= 0.99) {
            setNextState(new Route207State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_208) >= 0.99) {
            setNextState(new Route208State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_211) >= 0.99) {
            setNextState(new Route211State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_216) >= 0.95) {
            setNextState(new Route216State());
        } else if (isBattleGalacticGrunt(frame)) {
            setNextState(new GalacticGruntBattleState(() -> new MountCoronetNearTopState()));
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.SPEAR_PILLAR) >= 0.9) {
            setNextState(new SpearPillarState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.MOUNT_CORONET;
    }

    protected boolean isBattleGalacticGrunt(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 1080, 700, 1000);
        boolean result = ImageUtils.matchTemplateSqDiff(submat, StateIndicators.BATTLE_GALACTIC) <= 0.15;
        submat.release();
        return result;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.DialgaPalkiaBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticGruntBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.MAndJPreBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.LegendaryAppearsState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class SpearPillarState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.MOUNT_CORONET) >= 0.9) {
            setNextState(new MountCoronetNearTopState());
        } else if (isBattleGalacticGrunt(frame)) {
            setNextState(new GalacticGruntBattleState(() -> new SpearPillarState()));
        } else if (isLeftColumn(frame)) {
            setNextState(new LegendaryAppearsState());
        } else if (StateUtils.matchNameTag(frame, StateIndicators.MARS_NAME_TAG) >= 0.9) {
            setNextState(new MAndJPreBattleState());
        } else if (isBattleDialgaPalkia(frame)) {
            setNextState(new DialgaPalkiaBattleState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.SPEAR_PILLAR;
    }

    private boolean isLeftColumn(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 1080, 0, 500);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.SPEAR_PILLAR_LEFT_COLUMN) >= 0.8;
        submat.release();
        return result;
    }

    private boolean isBattleDialgaPalkia(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 370, 0, 610);
        boolean result = ImageUtils.matchTemplateSqDiff(submat, StateIndicators.BATTLE_DIALGA_PALKIA) <= 0.1;
        submat.release();
        return result;
    }
}

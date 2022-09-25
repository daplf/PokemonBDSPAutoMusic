package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticCommanderBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticGruntBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.ChooseStarterState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class LakeVerityState extends FlyableState {

    private static int noVisits = 0;

    public LakeVerityState() {
        noVisits++;
    }

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.VERITY_LAKEFRONT) >= 0.95) {
            setNextState(new VerityLakefrontState());
        } else if (isChooseStarter(frame)) {
            setNextState(new ChooseStarterState());
        } else if(isBattleGalacticGrunt(frame)) {
            setNextState(new GalacticGruntBattleState(() -> new LakeVerityState()));
        } else if (isBattleGalacticCommander(frame)) {
            setNextState(new GalacticCommanderBattleState(() -> new LakeVerityState()));
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.VERITY_CAVERN) >= 0.95) {
            setNextState(new VerityCavernState());
        } 
    }

    @Override
    public Songs getSong() {
        if (noVisits > 2 && noVisits < 6) {
            return Songs.GALACTIC_ETERNA_BUILDING;
        } else {
            return Songs.LAKE;
        }
        
    }

    private boolean isChooseStarter(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 370, 1080, 1300, 1920);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.CHOOSE_STARTER_TREE_DAY) >= 0.9;
        submat.release();
        return result;
    }

    @Override
    protected boolean isBattleGalacticGrunt(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 800, 650, 1200);
        boolean result = ImageUtils.matchTemplateSqDiff(submat, StateIndicators.BATTLE_GALACTIC_LAKE) <= 0.1;
        submat.release();
        return result;
    }
}

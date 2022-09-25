package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.AzelfMespritUxieBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.GalacticCommanderBattleState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class ValorCavernState extends State {

    private static int noVisits = 0;

    public ValorCavernState() {
        noVisits++;
    }

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.LAKE_VALOR) >= 0.95) {
            setNextState(new LakeValorState());
        } else if (isBattleGalacticCommander(frame)) {
            setNextState(new GalacticCommanderBattleState(() -> new ValorCavernState()));
        } else if (azelfCry(frame)) {
            setNextState(new AzelfMespritUxieBattleState(() -> new ValorCavernState()));
        }
    }

    @Override
    public Songs getSong() {
        if (noVisits < 3) {
            return Songs.GALACTIC_ETERNA_BUILDING;
        } else {
            return Songs.LAKE_CAVERNS;
        }
    }
    
    private boolean azelfCry(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 880, 1000, 390, 670);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.AZELF_CRY) >= 0.8;
        submat.release();
        return result;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.TrainerBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.WildBattleState;
import daplf.pokemon.bdsp.automusic.game.state.towns.OreburghCityState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class OreburghGateState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_203) >= 0.95) {
            setNextState(new Route203State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.OREBURGH_CITY) >= 0.95) {
            setNextState(new OreburghCityState());
        } else if (isBattleCave(frame)) {
            setNextState(new WildBattleState(() -> new OreburghGateState()));
        } else if (isBattleTrainer(frame)) {
            setNextState(new TrainerBattleState(() -> new OreburghGateState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.OREBURGH_GATE;
    }

    @Override
    protected boolean isBattleTrainer(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 200, 1050, 1920);
        boolean result = ImageUtils.matchTemplateSqDiff(submat, StateIndicators.BATTLE_TRAINER_VICTORY_ROAD) <= 0.1;
        submat.release();
        return result;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.TrainerBattleState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class VictoryRoadState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.POKEMON_LEAGUE) >= 0.95) {
            setNextState(new PokemonLeagueState());
        } else if (isBattleTrainer(frame)) {
            setNextState(new TrainerBattleState(() -> new VictoryRoadState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.VICTORY_ROAD;
    }

    @Override
    protected boolean isBattleTrainer(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 200, 1050, 1920);
        boolean result = ImageUtils.matchTemplateSqDiff(submat, StateIndicators.BATTLE_TRAINER_VICTORY_ROAD) <= 0.1;
        submat.release();
        return result;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.TrainerBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.game.state.towns.SunyshoreCityState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class Route223State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.SUNYSHORE_CITY) >= 0.95) {
            setNextState(new SunyshoreCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.POKEMON_LEAGUE) >= 0.95) {
            setNextState(new PokemonLeagueState());
        } else if (isBattleTrainer(frame)) {
            setNextState(new TrainerBattleState(() -> new Route223State()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_210_DAY;
    }

    @Override
    protected boolean isBattleTrainer(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 1080, 0, 100);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.BATTLE_TRAINER_WATER) >= 0.9;
        submat.release();

        Mat submat2 = ImageUtils.getProportionalSubmat(frame, 0, 1080, 1820, 1920);
        boolean result2 = ImageUtils.matchTemplate(submat2, StateIndicators.BATTLE_TRAINER_WATER) >= 0.9;
        submat2.release();

        return result || result2;
    }
}

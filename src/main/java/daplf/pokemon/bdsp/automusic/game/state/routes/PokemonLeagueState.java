package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.buildings.PokemonLeagueInsideState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class PokemonLeagueState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_223) >= 0.95) {
            setNextState(new Route223State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.VICTORY_ROAD) >= 0.95) {
            setNextState(new VictoryRoadState());
        } else if (isPokemonLeagueStatue(frame)) {
            setNextState(new PokemonLeagueInsideState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.POKEMON_LEAGUE_DAY;
    }

    private boolean isPokemonLeagueStatue(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 50, 450, 1125, 1365);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.POKEMON_LEAGUE_STATUE) >= 0.9;
        submat.release();
        return result;
    }
}

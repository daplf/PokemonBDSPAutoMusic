package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;

public class PokemonLeagueState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_223) >= 0.95) {
            setNextState(new Route223State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.VICTORY_ROAD) >= 0.95) {
            setNextState(new VictoryRoadState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.POKEMON_LEAGUE_DAY;
    }
}

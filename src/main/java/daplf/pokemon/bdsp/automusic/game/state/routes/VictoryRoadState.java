package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;

public class VictoryRoadState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.POKEMON_LEAGUE) >= 0.95) {
            setNextState(new PokemonLeagueState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.VICTORY_ROAD;
    }
}

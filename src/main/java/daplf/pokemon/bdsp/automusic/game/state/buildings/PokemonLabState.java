package daplf.pokemon.bdsp.automusic.game.state.buildings;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.towns.SandgemTownState;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PokemonLabState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.SANDGEM_TOWN) >= 0.95) {
            setNextState(new SandgemTownState());
        }
    }

    @Override
    public Song getSong() {
        return Song.POKEMON_LAB;
    }
}

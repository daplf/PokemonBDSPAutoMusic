package daplf.pokemon.bdsp.automusic.game.state.buildings;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.towns.VeilstoneCityState;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VeilstoneDepartmentStoreState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.VEILSTONE_CITY) >= 0.95) {
            setNextState(new VeilstoneCityState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.POKE_MART;
    }
}

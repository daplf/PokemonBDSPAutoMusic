package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.buildings.PokeMartState;
import daplf.pokemon.bdsp.automusic.game.state.buildings.PokemonCenterState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public abstract class TownState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (isPokemonCenter(frame)) {
            setNextState(new PokemonCenterState());
        } else if (isPokeMart(frame)) {
            setNextState(new PokeMartState());
        }
    }

    private boolean isPokemonCenter(final Mat frame) {
        return ImageUtils.matchTemplate(
            ImageUtils.getProportionalSubmat(frame, 0, 250, 700, 1300), StateIndicators.POKEMON_CENTER_MONITOR
        ) >= 0.9;
    }

    private boolean isPokeMart(final Mat frame) {
        return ImageUtils.matchTemplate(
            ImageUtils.getProportionalSubmat(frame, 130, 340, 1000, 1200), StateIndicators.POKE_MART_REGISTER
        ) >= 0.9;
    }
}

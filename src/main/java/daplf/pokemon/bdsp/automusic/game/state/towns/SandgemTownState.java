package daplf.pokemon.bdsp.automusic.game.state.towns;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.buildings.PokemonLabState;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route201State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route202State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class SandgemTownState extends TownState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_201) >= 0.99) {
            setNextState(new Route201State());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_202) >= 0.95) {
            setNextState(new Route202State());
        } else if (isPokemonLab(frame)) {
            setNextState(new PokemonLabState());
        }
    }

    @Override
    public Song getSong() {
        return Song.SANDGEM_TOWN_DAY;
    }

    private boolean isPokemonLab(final Mat frame) {
        return ImageUtils.matchTemplate(
            ImageUtils.getProportionalSubmat(frame, 160, 400, 870, 1030), StateIndicators.PROFESSOR_ROWAN
        ) >= 0.9;
    }
}

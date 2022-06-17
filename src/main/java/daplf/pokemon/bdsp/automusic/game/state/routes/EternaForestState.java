package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.battles.BattleGrassState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class EternaForestState extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (fadedIn() && ImageUtils.isWhiteScreen(frame)) {
            setNextState(new Route205State());
        } else if (isBattleGrass(frame)) {
            setNextState(new BattleGrassState(() -> new EternaForestState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ETERNA_FOREST;
    }
}

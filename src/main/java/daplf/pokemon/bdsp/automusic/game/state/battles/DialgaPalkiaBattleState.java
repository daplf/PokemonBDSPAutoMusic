package daplf.pokemon.bdsp.automusic.game.state.battles;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.routes.SpearPillarState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class DialgaPalkiaBattleState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (fadedIn() && ImageUtils.isBlackScreenFrame(frame)) {
            setNextState(new SpearPillarState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.BATTLE_DIALGA_PALKIA;
    }

    @Override
    protected boolean fadedIn() {
        return System.currentTimeMillis() - startTime >= 7000;
    }
}

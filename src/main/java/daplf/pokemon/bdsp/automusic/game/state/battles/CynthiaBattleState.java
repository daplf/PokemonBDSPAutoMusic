package daplf.pokemon.bdsp.automusic.game.state.battles;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class CynthiaBattleState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (fadedIn() && ImageUtils.isBlackScreen(ImageUtils.getGameWindowSubmat(frame))) {
            setNextState(new CynthiaPostBattleState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.BATTLE_CHAMPION;
    }

    @Override
    protected boolean fadedIn() {
        return System.currentTimeMillis() - startTime >= 7000;
    }
}

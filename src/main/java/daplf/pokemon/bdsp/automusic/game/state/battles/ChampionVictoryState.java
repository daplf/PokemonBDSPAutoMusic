package daplf.pokemon.bdsp.automusic.game.state.battles;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class ChampionVictoryState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (ImageUtils.isBlackScreenFrame(frame)) {
            setNextState(new CynthiaPostBattleState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.VICTORY_CHAMPION;
    }
}

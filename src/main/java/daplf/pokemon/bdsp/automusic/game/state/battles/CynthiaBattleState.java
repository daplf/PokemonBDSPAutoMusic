package daplf.pokemon.bdsp.automusic.game.state.battles;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class CynthiaBattleState extends BattleState {

    public CynthiaBattleState() {
        super(() -> new ChampionVictoryState());
    }

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);
        
        if (fadedIn() && ImageUtils.isBlackScreenFrame(frame)) {
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

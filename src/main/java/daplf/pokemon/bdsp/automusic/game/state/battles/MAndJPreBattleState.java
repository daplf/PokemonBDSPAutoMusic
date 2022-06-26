package daplf.pokemon.bdsp.automusic.game.state.battles;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MAndJPreBattleState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (isBattleGalacticGrunt(frame)) {
            setNextState(new GalacticCommanderBattleState(() -> new MAndJPostBattleState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.SPEAR_PILLAR;
    }
}

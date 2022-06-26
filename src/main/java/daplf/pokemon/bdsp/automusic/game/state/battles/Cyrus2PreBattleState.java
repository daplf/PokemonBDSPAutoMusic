package daplf.pokemon.bdsp.automusic.game.state.battles;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.routes.SpearPillarState;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Cyrus2PreBattleState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (isBattleGalacticCommander(frame)) {
            setNextState(new GalacticBossBattleState(() -> new SpearPillarState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.SPEAR_PILLAR;
    }
}

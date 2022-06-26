package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.TrainerBattleState;
import daplf.pokemon.bdsp.automusic.game.state.special.FlyableState;

public class Route216State extends FlyableState {

    @Override
    public void processFrame(final Mat frame) {
        super.processFrame(frame);

        if (StateUtils.matchAreaTitle(frame, StateIndicators.MOUNT_CORONET) >= 0.95) {
            setNextState(new MountCoronetState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ROUTE_217) >= 0.99) {
            setNextState(new Route217State());
        } else if (isBattleTrainer(frame)) {
            setNextState(new TrainerBattleState(() -> new Route216State()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.ROUTE_216_DAY;
    }
}

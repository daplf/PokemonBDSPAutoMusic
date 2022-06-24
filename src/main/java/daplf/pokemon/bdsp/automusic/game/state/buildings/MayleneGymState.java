package daplf.pokemon.bdsp.automusic.game.state.buildings;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.GymLeaderBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.TrainerBattleState;
import daplf.pokemon.bdsp.automusic.game.state.towns.VeilstoneCityState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class MayleneGymState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (isBattleTrainer(frame)) {
            setNextState(new TrainerBattleState(() -> new MayleneGymState()));
        } else if (isGymLeader(frame)) {
            setNextState(new GymLeaderBattleState(() -> new MayleneGymState()));
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.VEILSTONE_CITY) >= 0.95) {
            setNextState(new VeilstoneCityState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.POKEMON_GYM;
    }

    private boolean isGymLeader(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 230, 610, 0, 900);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.GYM_LEADER_BANNER) >= 0.9;
        submat.release();
        return result;
    }
}

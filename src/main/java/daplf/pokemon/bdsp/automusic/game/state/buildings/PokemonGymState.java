package daplf.pokemon.bdsp.automusic.game.state.buildings;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.GymLeaderBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.TrainerBattleState;
import daplf.pokemon.bdsp.automusic.game.state.towns.CanalaveCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.EternaCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.HearthomeCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.OreburghCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.PastoriaCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.SnowpointCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.SunyshoreCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.VeilstoneCityState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class PokemonGymState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (isBattleTrainer(frame)) {
            setNextState(new TrainerBattleState(() -> new PokemonGymState()));
        } else if (isGymLeader(frame)) {
            setNextState(new GymLeaderBattleState(() -> new PokemonGymState()));
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.OREBURGH_CITY) >= 0.95) {
            setNextState(new OreburghCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ETERNA_CITY) >= 0.95) {
            setNextState(new EternaCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.HEARTHOME_CITY) >= 0.95) {
            setNextState(new HearthomeCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.VEILSTONE_CITY) >= 0.95) {
            setNextState(new VeilstoneCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.PASTORIA_CITY) >= 0.95) {
            setNextState(new PastoriaCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.CANALAVE_CITY) >= 0.95) {
            setNextState(new CanalaveCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.SNOWPOINT_CITY) >= 0.95) {
            setNextState(new SnowpointCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.SUNYSHORE_CITY) >= 0.95) {
            setNextState(new SunyshoreCityState());
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

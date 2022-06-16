package daplf.pokemon.bdsp.automusic.game.state.buildings;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.routes.PokemonLeagueState;
import daplf.pokemon.bdsp.automusic.game.state.towns.CanalaveCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.CelesticTownState;
import daplf.pokemon.bdsp.automusic.game.state.towns.EternaCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.FloaromaTownState;
import daplf.pokemon.bdsp.automusic.game.state.towns.HearthomeCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.JubilifeCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.OreburghCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.PastoriaCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.SandgemTownState;
import daplf.pokemon.bdsp.automusic.game.state.towns.SnowpointCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.SolaceonTownState;
import daplf.pokemon.bdsp.automusic.game.state.towns.SunyshoreCityState;
import daplf.pokemon.bdsp.automusic.game.state.towns.TwinleafTownState;
import daplf.pokemon.bdsp.automusic.game.state.towns.VeilstoneCityState;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PokemonCenterState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.TWINLEAF_TOWN) >= 0.95) {
            setNextState(new TwinleafTownState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.SANDGEM_TOWN) >= 0.95) {
            setNextState(new SandgemTownState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.JUBILIFE_CITY) >= 0.95) {
            setNextState(new JubilifeCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.OREBURGH_CITY) >= 0.95) {
            setNextState(new OreburghCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.FLOAROMA_TOWN) >= 0.95) {
            setNextState(new FloaromaTownState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.ETERNA_CITY) >= 0.95) {
            setNextState(new EternaCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.HEARTHOME_CITY) >= 0.95) {
            setNextState(new HearthomeCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.SOLACEON_TOWN) >= 0.95) {
            setNextState(new SolaceonTownState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.VEILSTONE_CITY) >= 0.95) {
            setNextState(new VeilstoneCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.PASTORIA_CITY) >= 0.95) {
            setNextState(new PastoriaCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.CELESTIC_TOWN) >= 0.95) {
            setNextState(new CelesticTownState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.CANALAVE_CITY) >= 0.95) {
            setNextState(new CanalaveCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.SNOWPOINT_CITY) >= 0.95) {
            setNextState(new SnowpointCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.SUNYSHORE_CITY) >= 0.95) {
            setNextState(new SunyshoreCityState());
        } else if (StateUtils.matchAreaTitle(frame, StateIndicators.POKEMON_LEAGUE) >= 0.95) {
            setNextState(new PokemonLeagueState());
        }
    }

    @Override
    public Song getSong() {
        return Song.POKEMON_CENTER_DAY;
    }
}

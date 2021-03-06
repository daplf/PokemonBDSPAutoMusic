package daplf.pokemon.bdsp.automusic.music;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import daplf.pokemon.bdsp.automusic.game.music.Songs;

public class MusicUtils {
    
    public static Map<Songs, String> parseSongManifest(final String songManifestPath) throws IOException {
        HashMap<Songs, String> songManifest = new HashMap<>();

        InputStream inputStream = new FileInputStream(songManifestPath);
        Properties properties = new Properties();
        properties.load(inputStream);

        songManifest.put(Songs.TWINLEAF_TOWN_DAY, properties.getProperty("twinleaf-town-day"));
        songManifest.put(Songs.TWINLEAF_TOWN_NIGHT, properties.getProperty("twinleaf-town-night"));
        songManifest.put(Songs.ROUTE_201_DAY, properties.getProperty("route-201-day"));
        songManifest.put(Songs.ROUTE_201_NIGHT, properties.getProperty("route-201-night"));
        songManifest.put(Songs.BATTLE_WILD, properties.getProperty("battle-wild"));
        songManifest.put(Songs.LAKE, properties.getProperty("lake"));
        songManifest.put(Songs.CHOOSE_STARTER, properties.getProperty("choose-starter"));
        songManifest.put(Songs.SANDGEM_TOWN_DAY, properties.getProperty("sandgem-town-day"));
        songManifest.put(Songs.SANDGEM_TOWN_NIGHT, properties.getProperty("sandgem-town-night"));
        songManifest.put(Songs.POKEMON_CENTER_DAY, properties.getProperty("pokemon-center-day"));
        songManifest.put(Songs.POKEMON_CENTER_NIGHT, properties.getProperty("pokemon-center-night"));
        songManifest.put(Songs.POKE_MART, properties.getProperty("poke-mart"));
        songManifest.put(Songs.POKEMON_LAB, properties.getProperty("pokemon-lab"));
        songManifest.put(Songs.BATTLE_TRAINER, properties.getProperty("battle-trainer"));
        songManifest.put(Songs.VICTORY_TRAINER, properties.getProperty("victory-trainer"));
        songManifest.put(Songs.JUBILIFE_CITY_DAY, properties.getProperty("jubilife-city-day"));
        songManifest.put(Songs.JUBILIFE_CITY_NIGHT, properties.getProperty("jubilife-city-night"));
        songManifest.put(Songs.ROUTE_203_DAY, properties.getProperty("route-203-day"));
        songManifest.put(Songs.ROUTE_203_NIGHT, properties.getProperty("route-203-night"));
        songManifest.put(Songs.BATTLE_RIVAL, properties.getProperty("battle-rival"));
        songManifest.put(Songs.OREBURGH_GATE, properties.getProperty("oreburgh-gate"));
        songManifest.put(Songs.OREBURGH_CITY_DAY, properties.getProperty("oreburgh-city-day"));
        songManifest.put(Songs.OREBURGH_CITY_NIGHT, properties.getProperty("oreburgh-city-night"));
        songManifest.put(Songs.POKEMON_GYM, properties.getProperty("pokemon-gym"));
        songManifest.put(Songs.BATTLE_GYM_LEADER, properties.getProperty("battle-gym-leader"));
        songManifest.put(Songs.VICTORY_GYM_LEADER, properties.getProperty("victory-gym-leader"));
        songManifest.put(Songs.BATTLE_GALACTIC_GRUNT, properties.getProperty("battle-galactic-grunt"));
        songManifest.put(Songs.VICTORY_GALACTIC, properties.getProperty("victory-galactic"));
        songManifest.put(Songs.FLOAROMA_TOWN_DAY, properties.getProperty("floaroma-town-day"));
        songManifest.put(Songs.FLOAROMA_TOWN_NIGHT, properties.getProperty("floaroma-town-night"));
        songManifest.put(Songs.ROUTE_205_DAY, properties.getProperty("route-205-day"));
        songManifest.put(Songs.ROUTE_205_NIGHT, properties.getProperty("route-205-night"));
        songManifest.put(Songs.BATTLE_GALACTIC_COMMANDER, properties.getProperty("battle-galactic-commander"));
        songManifest.put(Songs.ETERNA_FOREST, properties.getProperty("eterna-forest"));
        songManifest.put(Songs.ETERNA_CITY_DAY, properties.getProperty("eterna-city-day"));
        songManifest.put(Songs.ETERNA_CITY_NIGHT, properties.getProperty("eterna-city-night"));
        songManifest.put(Songs.GALACTIC_ETERNA_BUILDING, properties.getProperty("galactic-eterna-building"));
        songManifest.put(Songs.ROUTE_206_DAY, properties.getProperty("route-206-day"));
        songManifest.put(Songs.ROUTE_206_NIGHT, properties.getProperty("route-206-night"));
        songManifest.put(Songs.HEARTHOME_CITY_DAY, properties.getProperty("hearthome-city-day"));
        songManifest.put(Songs.HEARTHOME_CITY_NIGHT, properties.getProperty("hearthome-city-night"));
        songManifest.put(Songs.ROUTE_209_DAY, properties.getProperty("route-209-day"));
        songManifest.put(Songs.ROUTE_209_NIGHT, properties.getProperty("route-209-night"));
        songManifest.put(Songs.SOLACEON_TOWN_DAY, properties.getProperty("solaceon-town-day"));
        songManifest.put(Songs.SOLACEON_TOWN_NIGHT, properties.getProperty("solaceon-town-night"));
        songManifest.put(Songs.ROUTE_210_DAY, properties.getProperty("route-210-day"));
        songManifest.put(Songs.ROUTE_210_NIGHT, properties.getProperty("route-210-night"));
        songManifest.put(Songs.VEILSTONE_CITY_DAY, properties.getProperty("veilstone-city-day"));
        songManifest.put(Songs.VEILSTONE_CITY_NIGHT, properties.getProperty("veilstone-city-night"));
        songManifest.put(Songs.VALOR_LAKEFRONT_DAY, properties.getProperty("valor-lakefront-day"));
        songManifest.put(Songs.VALOR_LAKEFRONT_NIGHT, properties.getProperty("valor-lakefront-night"));
        songManifest.put(Songs.CANALAVE_CITY_DAY, properties.getProperty("canalave-city-day"));
        songManifest.put(Songs.CANALAVE_CITY_NIGHT, properties.getProperty("canalave-city-night"));
        songManifest.put(Songs.ROUTE_216_DAY, properties.getProperty("route-216-day"));
        songManifest.put(Songs.ROUTE_216_NIGHT, properties.getProperty("route-216-night"));
        songManifest.put(Songs.SNOWPOINT_CITY_DAY, properties.getProperty("snowpoint-city-day"));
        songManifest.put(Songs.SNOWPOINT_CITY_NIGHT, properties.getProperty("snowpoint-city-night"));
        songManifest.put(Songs.GALACTIC_HQ, properties.getProperty("galactic-hq"));
        songManifest.put(Songs.BATTLE_GALACTIC_BOSS, properties.getProperty("battle-galactic-boss"));
        songManifest.put(Songs.DEEP_WITHIN_GALACTIC_HQ, properties.getProperty("deep-within-galactic-hq"));
        songManifest.put(Songs.MOUNT_CORONET, properties.getProperty("mount-coronet"));
        songManifest.put(Songs.SPEAR_PILLAR, properties.getProperty("spear-pillar"));
        songManifest.put(Songs.LEGENDARY_APPEARS, properties.getProperty("legendary-appears"));
        songManifest.put(Songs.CATASTROPHE, properties.getProperty("catastrophe"));
        songManifest.put(Songs.LAKE_CAVERNS, properties.getProperty("lake-caverns"));
        songManifest.put(Songs.BATTLE_DIALGA_PALKIA, properties.getProperty("battle-dialga-palkia"));
        songManifest.put(Songs.SUNYSHORE_CITY_DAY, properties.getProperty("sunyshore-city-day"));
        songManifest.put(Songs.SUNYSHORE_CITY_NIGHT, properties.getProperty("sunyshore-city-night"));
        songManifest.put(Songs.VICTORY_ROAD, properties.getProperty("victory-road"));
        songManifest.put(Songs.POKEMON_LEAGUE_DAY, properties.getProperty("pokemon-league-day"));
        songManifest.put(Songs.POKEMON_LEAGUE_NIGHT, properties.getProperty("pokemon-league-night"));
        songManifest.put(Songs.DECISIVE_BATTLE, properties.getProperty("decisive-battle"));
        songManifest.put(Songs.ELITE_FOUR_APPEARS, properties.getProperty("elite-four-appears"));
        songManifest.put(Songs.BATTLE_ELITE_FOUR, properties.getProperty("battle-elite-four"));
        songManifest.put(Songs.VICTORY_ELITE_FOUR, properties.getProperty("victory-elite-four"));
        songManifest.put(Songs.CYNTHIA_THEME, properties.getProperty("cynthia-theme"));
        songManifest.put(Songs.BATTLE_CHAMPION, properties.getProperty("battle-champion"));
        songManifest.put(Songs.VICTORY_CHAMPION, properties.getProperty("victory-champion"));
        songManifest.put(Songs.HALL_OF_FAME, properties.getProperty("hall-of-fame"));
        songManifest.put(Songs.CONGRATULATIONS_HALL_OF_FAME, properties.getProperty("congratulations-hall-of-fame"));
        songManifest.put(Songs.ENDING_THEME, properties.getProperty("ending-theme"));

        return songManifest;
    }
}

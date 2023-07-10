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

        songManifest.put(Songs.TWINLEAF_TOWN_DAY, getSong(properties, "twinleaf-town-day"));
        songManifest.put(Songs.TWINLEAF_TOWN_NIGHT, getSong(properties, "twinleaf-town-night"));
        songManifest.put(Songs.ROUTE_201_DAY, getSong(properties, "route-201-day"));
        songManifest.put(Songs.ROUTE_201_NIGHT, getSong(properties, "route-201-night"));
        songManifest.put(Songs.BATTLE_WILD, getSong(properties, "battle-wild"));
        songManifest.put(Songs.LAKE, getSong(properties, "lake"));
        songManifest.put(Songs.CHOOSE_STARTER, getSong(properties, "choose-starter"));
        songManifest.put(Songs.SANDGEM_TOWN_DAY, getSong(properties, "sandgem-town-day"));
        songManifest.put(Songs.SANDGEM_TOWN_NIGHT, getSong(properties, "sandgem-town-night"));
        songManifest.put(Songs.POKEMON_CENTER_DAY, getSong(properties, "pokemon-center-day"));
        songManifest.put(Songs.POKEMON_CENTER_NIGHT, getSong(properties, "pokemon-center-night"));
        songManifest.put(Songs.POKE_MART, getSong(properties, "poke-mart"));
        songManifest.put(Songs.POKEMON_LAB, getSong(properties, "pokemon-lab"));
        songManifest.put(Songs.BATTLE_TRAINER, getSong(properties, "battle-trainer"));
        songManifest.put(Songs.VICTORY_TRAINER, getSong(properties, "victory-trainer"));
        songManifest.put(Songs.JUBILIFE_CITY_DAY, getSong(properties, "jubilife-city-day"));
        songManifest.put(Songs.JUBILIFE_CITY_NIGHT, getSong(properties, "jubilife-city-night"));
        songManifest.put(Songs.ROUTE_203_DAY, getSong(properties, "route-203-day"));
        songManifest.put(Songs.ROUTE_203_NIGHT, getSong(properties, "route-203-night"));
        songManifest.put(Songs.BATTLE_RIVAL, getSong(properties, "battle-rival"));
        songManifest.put(Songs.OREBURGH_GATE, getSong(properties, "oreburgh-gate"));
        songManifest.put(Songs.OREBURGH_MINE, getSong(properties, "oreburgh-mine"));
        songManifest.put(Songs.OREBURGH_CITY_DAY, getSong(properties, "oreburgh-city-day"));
        songManifest.put(Songs.OREBURGH_CITY_NIGHT, getSong(properties, "oreburgh-city-night"));
        songManifest.put(Songs.POKEMON_GYM, getSong(properties, "pokemon-gym"));
        songManifest.put(Songs.BATTLE_GYM_LEADER, getSong(properties, "battle-gym-leader"));
        songManifest.put(Songs.VICTORY_GYM_LEADER, getSong(properties, "victory-gym-leader"));
        songManifest.put(Songs.BATTLE_GALACTIC_GRUNT, getSong(properties, "battle-galactic-grunt"));
        songManifest.put(Songs.VICTORY_GALACTIC, getSong(properties, "victory-galactic"));
        songManifest.put(Songs.FLOAROMA_TOWN_DAY, getSong(properties, "floaroma-town-day"));
        songManifest.put(Songs.FLOAROMA_TOWN_NIGHT, getSong(properties, "floaroma-town-night"));
        songManifest.put(Songs.ROUTE_205_DAY, getSong(properties, "route-205-day"));
        songManifest.put(Songs.ROUTE_205_NIGHT, getSong(properties, "route-205-night"));
        songManifest.put(Songs.BATTLE_GALACTIC_COMMANDER, getSong(properties, "battle-galactic-commander"));
        songManifest.put(Songs.ETERNA_FOREST, getSong(properties, "eterna-forest"));
        songManifest.put(Songs.ETERNA_CITY_DAY, getSong(properties, "eterna-city-day"));
        songManifest.put(Songs.ETERNA_CITY_NIGHT, getSong(properties, "eterna-city-night"));
        songManifest.put(Songs.GALACTIC_ETERNA_BUILDING, getSong(properties, "galactic-eterna-building"));
        songManifest.put(Songs.ROUTE_206_DAY, getSong(properties, "route-206-day"));
        songManifest.put(Songs.ROUTE_206_NIGHT, getSong(properties, "route-206-night"));
        songManifest.put(Songs.HEARTHOME_CITY_DAY, getSong(properties, "hearthome-city-day"));
        songManifest.put(Songs.HEARTHOME_CITY_NIGHT, getSong(properties, "hearthome-city-night"));
        songManifest.put(Songs.ROUTE_209_DAY, getSong(properties, "route-209-day"));
        songManifest.put(Songs.ROUTE_209_NIGHT, getSong(properties, "route-209-night"));
        songManifest.put(Songs.SOLACEON_TOWN_DAY, getSong(properties, "solaceon-town-day"));
        songManifest.put(Songs.SOLACEON_TOWN_NIGHT, getSong(properties, "solaceon-town-night"));
        songManifest.put(Songs.ROUTE_210_DAY, getSong(properties, "route-210-day"));
        songManifest.put(Songs.ROUTE_210_NIGHT, getSong(properties, "route-210-night"));
        songManifest.put(Songs.VEILSTONE_CITY_DAY, getSong(properties, "veilstone-city-day"));
        songManifest.put(Songs.VEILSTONE_CITY_NIGHT, getSong(properties, "veilstone-city-night"));
        songManifest.put(Songs.VALOR_LAKEFRONT_DAY, getSong(properties, "valor-lakefront-day"));
        songManifest.put(Songs.VALOR_LAKEFRONT_NIGHT, getSong(properties, "valor-lakefront-night"));
        songManifest.put(Songs.CANALAVE_CITY_DAY, getSong(properties, "canalave-city-day"));
        songManifest.put(Songs.CANALAVE_CITY_NIGHT, getSong(properties, "canalave-city-night"));
        songManifest.put(Songs.ROUTE_216_DAY, getSong(properties, "route-216-day"));
        songManifest.put(Songs.ROUTE_216_NIGHT, getSong(properties, "route-216-night"));
        songManifest.put(Songs.SNOWPOINT_CITY_DAY, getSong(properties, "snowpoint-city-day"));
        songManifest.put(Songs.SNOWPOINT_CITY_NIGHT, getSong(properties, "snowpoint-city-night"));
        songManifest.put(Songs.GALACTIC_HQ, getSong(properties, "galactic-hq"));
        songManifest.put(Songs.BATTLE_GALACTIC_BOSS, getSong(properties, "battle-galactic-boss"));
        songManifest.put(Songs.DEEP_WITHIN_GALACTIC_HQ, getSong(properties, "deep-within-galactic-hq"));
        songManifest.put(Songs.MOUNT_CORONET, getSong(properties, "mount-coronet"));
        songManifest.put(Songs.SPEAR_PILLAR, getSong(properties, "spear-pillar"));
        songManifest.put(Songs.LEGENDARY_APPEARS, getSong(properties, "legendary-appears"));
        songManifest.put(Songs.CATASTROPHE, getSong(properties, "catastrophe"));
        songManifest.put(Songs.LAKE_CAVERNS, getSong(properties, "lake-caverns"));
        songManifest.put(Songs.BATTLE_DIALGA_PALKIA, getSong(properties, "battle-dialga-palkia"));
        songManifest.put(Songs.BATTLE_AZELF_MESPRIT_UXIE, getSong(properties, "battle-azelf-mesprit-uxie"));
        songManifest.put(Songs.SUNYSHORE_CITY_DAY, getSong(properties, "sunyshore-city-day"));
        songManifest.put(Songs.SUNYSHORE_CITY_NIGHT, getSong(properties, "sunyshore-city-night"));
        songManifest.put(Songs.VICTORY_ROAD, getSong(properties, "victory-road"));
        songManifest.put(Songs.POKEMON_LEAGUE_DAY, getSong(properties, "pokemon-league-day"));
        songManifest.put(Songs.POKEMON_LEAGUE_NIGHT, getSong(properties, "pokemon-league-night"));
        songManifest.put(Songs.DECISIVE_BATTLE, getSong(properties, "decisive-battle"));
        songManifest.put(Songs.ELITE_FOUR_APPEARS, getSong(properties, "elite-four-appears"));
        songManifest.put(Songs.BATTLE_ELITE_FOUR, getSong(properties, "battle-elite-four"));
        songManifest.put(Songs.VICTORY_ELITE_FOUR, getSong(properties, "victory-elite-four"));
        songManifest.put(Songs.CYNTHIA_THEME, getSong(properties, "cynthia-theme"));
        songManifest.put(Songs.BATTLE_CHAMPION, getSong(properties, "battle-champion"));
        songManifest.put(Songs.VICTORY_CHAMPION, getSong(properties, "victory-champion"));
        songManifest.put(Songs.HALL_OF_FAME, getSong(properties, "hall-of-fame"));
        songManifest.put(Songs.CONGRATULATIONS_HALL_OF_FAME, getSong(properties, "congratulations-hall-of-fame"));
        songManifest.put(Songs.ENDING_THEME, getSong(properties, "ending-theme"));
        songManifest.put(Songs.FIGHT_AREA_DAY, getSong(properties, "fight-area-day"));
        songManifest.put(Songs.FIGHT_AREA_NIGHT, getSong(properties, "fight-area-night"));
        songManifest.put(Songs.ROUTE_225_DAY, getSong(properties, "route-225-day"));
        songManifest.put(Songs.ROUTE_225_NIGHT, getSong(properties, "route-225-night"));
        songManifest.put(Songs.STARK_MOUNTAIN, getSong(properties, "stark-mountain"));
        songManifest.put(Songs.BATTLE_LEGENDARY, getSong(properties, "battle-legendary"));

        return songManifest;
    }

    private static String getSong(final Properties properties, final String songName) {
        String song = properties.getProperty(songName);

        if (song != null) {
            return song;
        } else {
            throw new IllegalArgumentException("Song manifest entry " + songName + " is missing");
        }
    }
}

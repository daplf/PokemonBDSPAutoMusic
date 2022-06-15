package daplf.pokemon.bdsp.automusic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import daplf.pokemon.bdsp.automusic.game.GameManager;
import daplf.pokemon.bdsp.automusic.game.MusicManager;
import daplf.pokemon.bdsp.automusic.utils.ConfigurationProperties;
import daplf.pokemon.bdsp.automusic.video.VideoCaptureManager;

public class App {

    /**
     * Setup OpenCV.
     */
    static {
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(final String[] args) throws IOException {
        AppArguments arguments = new AppArgumentsParser().parseArguments(args);

        setupConfigurationProperties(arguments);

        VideoCaptureManager videoCaptureManager = new VideoCaptureManager(arguments.getDevice(), arguments.getWidth(), arguments.getHeight());
        MusicManager musicManager = new MusicManager(getSongManifest(arguments.getSongManifestPath()));
        GameManager gameManager = new GameManager(videoCaptureManager, musicManager);

        gameManager.play();
    }

    private static Map<MusicManager.Song, String> getSongManifest(final String songManifestPath) throws IOException {
        HashMap<MusicManager.Song, String> songManifest = new HashMap<>();

        InputStream inputStream = new FileInputStream(songManifestPath);
        Properties properties = new Properties();
        properties.load(inputStream);

        songManifest.put(MusicManager.Song.TWINLEAF_TOWN_DAY, properties.getProperty("twinleaf-town-day"));
        songManifest.put(MusicManager.Song.TWINLEAF_TOWN_NIGHT, properties.getProperty("twinleaf-town-night"));
        songManifest.put(MusicManager.Song.ROUTE_201_DAY, properties.getProperty("route-201-day"));
        songManifest.put(MusicManager.Song.ROUTE_201_NIGHT, properties.getProperty("route-201-night"));
        songManifest.put(MusicManager.Song.BATTLE_WILD, properties.getProperty("battle-wild"));
        songManifest.put(MusicManager.Song.LAKE, properties.getProperty("lake"));
        songManifest.put(MusicManager.Song.CHOOSE_STARTER, properties.getProperty("choose-starter"));
        songManifest.put(MusicManager.Song.SANDGEM_TOWN_DAY, properties.getProperty("sandgem-town-day"));
        songManifest.put(MusicManager.Song.SANDGEM_TOWN_NIGHT, properties.getProperty("sandgem-town-night"));
        songManifest.put(MusicManager.Song.JUBILIFE_CITY_DAY, properties.getProperty("jubilife-city-day"));
        songManifest.put(MusicManager.Song.JUBILIFE_CITY_NIGHT, properties.getProperty("jubilife-city-night"));
        songManifest.put(MusicManager.Song.ROUTE_203_DAY, properties.getProperty("route-203-day"));
        songManifest.put(MusicManager.Song.ROUTE_203_NIGHT, properties.getProperty("route-203-night"));
        songManifest.put(MusicManager.Song.OREBURGH_GATE, properties.getProperty("oreburgh-gate"));
        songManifest.put(MusicManager.Song.OREBURGH_CITY_DAY, properties.getProperty("oreburgh-city-day"));
        songManifest.put(MusicManager.Song.OREBURGH_CITY_NIGHT, properties.getProperty("oreburgh-city-night"));
        songManifest.put(MusicManager.Song.FLOAROMA_TOWN_DAY, properties.getProperty("floaroma-town-day"));
        songManifest.put(MusicManager.Song.FLOAROMA_TOWN_NIGHT, properties.getProperty("floaroma-town-night"));
        songManifest.put(MusicManager.Song.ROUTE_205_DAY, properties.getProperty("route-205-day"));
        songManifest.put(MusicManager.Song.ROUTE_205_NIGHT, properties.getProperty("route-205-night"));
        songManifest.put(MusicManager.Song.ETERNA_FOREST, properties.getProperty("eterna-forest"));
        songManifest.put(MusicManager.Song.ETERNA_CITY_DAY, properties.getProperty("eterna-city-day"));
        songManifest.put(MusicManager.Song.ETERNA_CITY_NIGHT, properties.getProperty("eterna-city-night"));
        songManifest.put(MusicManager.Song.GALACTIC_ETERNA_BUILDING, properties.getProperty("galactic-eterna-building"));
        songManifest.put(MusicManager.Song.ROUTE_206_DAY, properties.getProperty("route-206-day"));
        songManifest.put(MusicManager.Song.ROUTE_206_NIGHT, properties.getProperty("route-206-night"));
        songManifest.put(MusicManager.Song.HEARTHOME_CITY_DAY, properties.getProperty("hearthome-city-day"));
        songManifest.put(MusicManager.Song.HEARTHOME_CITY_NIGHT, properties.getProperty("hearthome-city-night"));
        songManifest.put(MusicManager.Song.ROUTE_209_DAY, properties.getProperty("route-209-day"));
        songManifest.put(MusicManager.Song.ROUTE_209_NIGHT, properties.getProperty("route-209-night"));
        songManifest.put(MusicManager.Song.SOLACEON_TOWN_DAY, properties.getProperty("solaceon-town-day"));
        songManifest.put(MusicManager.Song.SOLACEON_TOWN_NIGHT, properties.getProperty("solaceon-town-night"));
        songManifest.put(MusicManager.Song.ROUTE_210_DAY, properties.getProperty("route-210-day"));
        songManifest.put(MusicManager.Song.ROUTE_210_NIGHT, properties.getProperty("route-210-night"));
        songManifest.put(MusicManager.Song.VEILSTONE_CITY_DAY, properties.getProperty("veilstone-city-day"));
        songManifest.put(MusicManager.Song.VEILSTONE_CITY_NIGHT, properties.getProperty("veilstone-city-night"));
        songManifest.put(MusicManager.Song.VALOR_LAKEFRONT_DAY, properties.getProperty("valor-lakefront-day"));
        songManifest.put(MusicManager.Song.VALOR_LAKEFRONT_NIGHT, properties.getProperty("valor-lakefront-night"));
        songManifest.put(MusicManager.Song.CANALAVE_CITY_DAY, properties.getProperty("canalave-city-day"));
        songManifest.put(MusicManager.Song.CANALAVE_CITY_NIGHT, properties.getProperty("canalave-city-night"));
        songManifest.put(MusicManager.Song.ROUTE_216_DAY, properties.getProperty("route-216-day"));
        songManifest.put(MusicManager.Song.ROUTE_216_NIGHT, properties.getProperty("route-216-night"));
        songManifest.put(MusicManager.Song.SNOWPOINT_CITY_DAY, properties.getProperty("snowpoint-city-day"));
        songManifest.put(MusicManager.Song.SNOWPOINT_CITY_NIGHT, properties.getProperty("snowpoint-city-night"));
        songManifest.put(MusicManager.Song.SUNYSHORE_CITY_DAY, properties.getProperty("sunyshore-city-day"));
        songManifest.put(MusicManager.Song.SUNYSHORE_CITY_NIGHT, properties.getProperty("sunyshore-city-night"));
        songManifest.put(MusicManager.Song.VICTORY_ROAD, properties.getProperty("victory-road"));
        songManifest.put(MusicManager.Song.POKEMON_LEAGUE_DAY, properties.getProperty("pokemon-league-day"));
        songManifest.put(MusicManager.Song.POKEMON_LEAGUE_NIGHT, properties.getProperty("pokemon-league-night"));

        return songManifest;
    }

    private static void setupConfigurationProperties(final AppArguments appArguments) {
        // The image width/height factor is useful in situations where the game width/height is smaller than the camera output.
        // For example, when using the Streamlabs virtual camera, the camera outputs the entire scene,
        // which may contain other things (like splits, chat, etc). The width/height factor allows us to resize all templates accordingly.
        ConfigurationProperties.IMAGE_WIDTH_FACTOR = (double) appArguments.getGameWidth() / ConfigurationProperties.DEFAULT_WIDTH;
        ConfigurationProperties.IMAGE_HEIGHT_FACTOR = (double) appArguments.getGameHeight() / ConfigurationProperties.DEFAULT_HEIGHT;
    }
}

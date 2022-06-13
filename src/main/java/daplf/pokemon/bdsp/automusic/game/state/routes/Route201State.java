package daplf.pokemon.bdsp.automusic.game.state.routes;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.battles.BattleGrassState;
import daplf.pokemon.bdsp.automusic.game.state.towns.TwinleafTownState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class Route201State extends State {

    private static final Mat TWINLEAF_TOWN_INDICATOR = ImageUtils.getImageResource("twinleaf-town.png");
    private static final Mat VERITY_LAKEFRONT_INDICATOR = ImageUtils.getImageResource("verity-lakefront.png");
    private static final Mat BATTLE_GRASS_INDICATOR = ImageUtils.getImageResource("battle-grass.png");

    @Override
    public void processFrame(final Mat frame) {
        if ((fadedIn() && ImageUtils.isBlackScreen(frame)) || ImageUtils.matchTemplate(frame, TWINLEAF_TOWN_INDICATOR) >= 0.9) {
            setNextState(new TwinleafTownState());
        } else if (ImageUtils.matchTemplate(frame, VERITY_LAKEFRONT_INDICATOR) >= 0.9) {
            setNextState(new VerityLakefrontState());
        } else if (ImageUtils.matchTemplate(frame, BATTLE_GRASS_INDICATOR) >= 0.5) {
            setNextState(new BattleGrassState(() -> new Route201State()));
        }
    }

    @Override
    public Song getSong() {
        return Song.ROUTE_201_DAY;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.special;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.MusicManager.Song;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.battles.BattleGrassState;
import daplf.pokemon.bdsp.automusic.game.state.routes.LakeVerityState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public class ChooseStarterState extends State {

    private static final Mat FIRST_FIGHT_INDICATOR = ImageUtils.getImageResource("first-fight.png");

    @Override
    public void processFrame(final Mat frame) {
        if (ImageUtils.matchTemplate(frame, FIRST_FIGHT_INDICATOR) >= 0.5) {
            setNextState(new BattleGrassState(() -> new LakeVerityState()));
        }
    }

    @Override
    public Song getSong() {
        return Song.CHOOSE_STARTER;
    }
}

package daplf.pokemon.bdsp.automusic.game.state.buildings;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BerthaElevatorRoomState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (fadedIn() && ImageUtils.isBlackScreen(ImageUtils.getGameWindowSubmat(frame))) {
            setNextState(new BerthaRoomState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.DECISIVE_BATTLE;
    }
}

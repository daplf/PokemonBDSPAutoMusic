package daplf.pokemon.bdsp.automusic.game.state.buildings;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.battles.FlintPreBattleState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FlintRoomState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (isCutscene(frame)) {
            setNextState(new FlintPreBattleState());
        } else if (isElevatorRoomLeftWall(frame)) {
            setNextState(new LucianElevatorRoomState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.DECISIVE_BATTLE;
    }

    private boolean isCutscene(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 220, 640, 765, 1085);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.FLINT_CUTSCENE) >= 0.9;
        submat.release();
        return result;
    }

    private boolean isElevatorRoomLeftWall(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 750, 70, 560);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.POKEMON_LEAGUE_ELEVATOR_ROOM_LEFT_WALL) >= 0.9;
        submat.release();
        return result;
    }
}

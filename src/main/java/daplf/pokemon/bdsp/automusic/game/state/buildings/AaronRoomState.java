package daplf.pokemon.bdsp.automusic.game.state.buildings;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.battles.EliteFourBattleState;
import daplf.pokemon.bdsp.automusic.game.state.battles.EliteFourPreBattleState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AaronRoomState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (isCutscene(frame)) {
            setNextState(new EliteFourPreBattleState(() -> new AaronRoomState()));
        } else if (isElevatorRoomLeftWall(frame)) {
            setNextState(new BerthaElevatorRoomState());
        } else if (isBattleEliteFour(frame)) {
            setNextState(new EliteFourBattleState(() -> new AaronRoomState()));
        }
    }

    @Override
    public Songs getSong() {
        return Songs.DECISIVE_BATTLE;
    }

    private boolean isCutscene(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 335, 750, 590, 1400);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.AARON_CUTSCENE) >= 0.9;
        submat.release();
        return result;
    }

    private boolean isElevatorRoomLeftWall(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 750, 70, 560);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.POKEMON_LEAGUE_ELEVATOR_ROOM_LEFT_WALL) >= 0.9;
        submat.release();
        return result;
    }

    private boolean isBattleEliteFour(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 630, 1065, 0, 150);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.BATTLE_ELITE_FOUR) >= 0.7;
        submat.release();
        return result;
    }
}

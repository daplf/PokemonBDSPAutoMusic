package daplf.pokemon.bdsp.automusic.game.state.buildings;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.StateIndicators;
import daplf.pokemon.bdsp.automusic.game.state.StateUtils;
import daplf.pokemon.bdsp.automusic.game.state.battles.RivalBattleState;
import daplf.pokemon.bdsp.automusic.game.state.routes.PokemonLeagueState;
import daplf.pokemon.bdsp.automusic.image.ImageUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PokemonLeagueInsideState extends State {

    @Override
    public void processFrame(final Mat frame) {
        if (StateUtils.matchAreaTitle(frame, StateIndicators.POKEMON_LEAGUE) >= 0.95) {
            setNextState(new PokemonLeagueState());
        } else if (isBattleRival(frame)) {
            setNextState(new RivalBattleState(() -> new PokemonLeagueInsideState()));
        } else if (isElevatorRoomWall(frame)) {
            setNextState(new AaronElevatorRoomState());
        }
    }

    @Override
    public Songs getSong() {
        return Songs.POKEMON_CENTER_DAY;
    }

    private boolean isBattleRival(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 0, 250, 1250, 1920);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.BATTLE_RIVAL_POKEMON_LEAGUE) >= 0.9;
        submat.release();
        return result;
    }

    private boolean isElevatorRoomWall(final Mat frame) {
        Mat submat = ImageUtils.getProportionalSubmat(frame, 5, 300, 380, 1500);
        boolean result = ImageUtils.matchTemplate(submat, StateIndicators.POKEMON_LEAGUE_ELEVATOR_ROOM_WALL) >= 0.8;
        submat.release();
        return result;
    }
}

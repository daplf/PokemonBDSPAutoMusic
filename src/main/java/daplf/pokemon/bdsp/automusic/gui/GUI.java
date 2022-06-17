package daplf.pokemon.bdsp.automusic.gui;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import daplf.pokemon.bdsp.automusic.game.GameManager;
import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.game.state.State;
import daplf.pokemon.bdsp.automusic.game.state.routes.AcuityLakefrontState;
import daplf.pokemon.bdsp.automusic.game.state.routes.EternaForestState;
import daplf.pokemon.bdsp.automusic.game.state.routes.LakeValorState;
import daplf.pokemon.bdsp.automusic.game.state.routes.LakeVerityState;
import daplf.pokemon.bdsp.automusic.game.state.routes.MountCoronetState;
import daplf.pokemon.bdsp.automusic.game.state.routes.OreburghGateState;
import daplf.pokemon.bdsp.automusic.game.state.routes.PokemonLeagueState;
import daplf.pokemon.bdsp.automusic.game.state.routes.RavagedPathState;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route201State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route202State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route203State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route204State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route205State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route206State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route207State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route208State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route209State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route210State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route211State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route213State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route214State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route215State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route216State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route217State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route218State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route222State;
import daplf.pokemon.bdsp.automusic.game.state.routes.Route223State;
import daplf.pokemon.bdsp.automusic.game.state.routes.ValleyWindworksState;
import daplf.pokemon.bdsp.automusic.game.state.routes.ValorLakefrontState;
import daplf.pokemon.bdsp.automusic.game.state.routes.VerityLakefrontState;
import daplf.pokemon.bdsp.automusic.game.state.routes.VictoryRoadState;
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
import daplf.pokemon.bdsp.automusic.gui.music.GUIMusicPlayer;
import daplf.pokemon.bdsp.automusic.gui.music.SimpleGUIMusicPlayer;
import daplf.pokemon.bdsp.automusic.gui.music.YoutubeGUIMusicPlayer;
import daplf.pokemon.bdsp.automusic.music.LocalMusicPlayer;
import daplf.pokemon.bdsp.automusic.music.MusicUtils;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class GUI extends Application {

	private static final int WINDOW_WIDTH = 1500;

	private static final int WINDOW_HEIGHT = 900;

	@RequiredArgsConstructor
	@Getter
	private static class MapLocationButton {
		private final String buttonText;

		private final Supplier<State> instanceSupplier;

		private final double x;

		private final double y;

		private final double width;

		private final double height;
	}

	private static final List<MapLocationButton> MAP_BUTTONS = List.of(
		new MapLocationButton("Twinleaf\nTown", TwinleafTownState::new, 100, 850, 60, 40),
		new MapLocationButton("Route\n201", Route201State::new, 100, 800,60, 40),
		new MapLocationButton("Verity\nLakefront", VerityLakefrontState::new, 20, 800, 70, 40),
		new MapLocationButton("Lake\nVerity", LakeVerityState::new, 20, 750, 70, 40),
		new MapLocationButton("Sandgem\nTown", SandgemTownState::new, 170, 800, 70, 40),
		new MapLocationButton("Route\n202", Route202State::new, 175, 710, 60, 80),
		new MapLocationButton("Jubilife\nCity", JubilifeCityState::new, 170, 660, 70, 40),
		new MapLocationButton("Route\n218", Route218State::new, 100, 660, 60, 40),
		new MapLocationButton("Canalave\nCity", CanalaveCityState::new, 20, 660, 70, 40),
		new MapLocationButton("Route\n203", Route203State::new, 250, 660, 60, 40),
		new MapLocationButton("Oreburgh\nGate", OreburghGateState::new, 320, 660, 80, 40),
		new MapLocationButton("Oreburgh\nCity", OreburghCityState::new, 410, 660, 70, 40),
		new MapLocationButton("Route\n204", Route204State::new, 175, 610, 60, 40),
		new MapLocationButton("Ravaged\nPath", RavagedPathState::new, 170, 560, 70, 40),
		new MapLocationButton("Floaroma\nTown", FloaromaTownState::new, 170, 510, 70, 40),
		new MapLocationButton("Route\n205", Route205State::new, 250, 510, 60, 40),
		new MapLocationButton("Valley\nWindworks", ValleyWindworksState::new, 320, 510, 80, 40),
		new MapLocationButton("Eterna\nForest", EternaForestState::new, 250, 460, 60, 40),
		new MapLocationButton("Route\n205", Route205State::new, 330, 460, 60, 40),
		new MapLocationButton("Eterna\nCity", EternaCityState::new, 410, 460, 70, 40),
		new MapLocationButton("Route\n206", Route206State::new, 415, 515, 60, 80),
		new MapLocationButton("Route\n207", Route207State::new, 415, 610, 135, 40),
		new MapLocationButton("Mount\nCoronet", MountCoronetState::new, 560, 360, 60, 290),
		new MapLocationButton("Route\n208", Route208State::new, 630, 610, 60, 40),
		new MapLocationButton("Hearthome\nCity", HearthomeCityState::new, 700, 610, 70, 40),
		new MapLocationButton("Route\n209", Route209State::new, 785, 610, 60, 40),
		new MapLocationButton("Solaceon\nTown", SolaceonTownState::new, 780, 560, 70, 40),
		new MapLocationButton("Route\n210", Route210State::new, 785, 460, 60, 90),
		new MapLocationButton("Route\n215", Route215State::new, 855, 490, 120, 40),
		new MapLocationButton("Veilstone\nCity", VeilstoneCityState::new, 985, 490, 70, 40),
		new MapLocationButton("Route\n214", Route214State::new, 990, 540, 60, 90),
		new MapLocationButton("Valor\nLakefront", ValorLakefrontState::new, 985, 640, 70, 80),
		new MapLocationButton("Lake\nValor", LakeValorState::new, 905, 650, 70, 40),
		new MapLocationButton("Route\n213", Route213State::new, 935, 730, 120, 40),
		new MapLocationButton("Pastoria\nCity", PastoriaCityState::new, 855, 730, 70, 40),
		new MapLocationButton("Celestic\nTown", CelesticTownState::new, 700, 460, 70, 40),
		new MapLocationButton("Route\n211", Route211State::new, 630, 460, 60, 40),
		new MapLocationButton("Route\n216", Route216State::new, 430, 360, 120, 40),
		new MapLocationButton("Route\n217", Route217State::new, 430, 230, 60, 120),
		new MapLocationButton("Acuity\nLakefront", AcuityLakefrontState::new, 430, 180, 70, 40),
		new MapLocationButton("Snowpoint\nCity", SnowpointCityState::new, 510, 180, 80, 40),
		new MapLocationButton("Route\n222", Route222State::new, 1065, 680, 120, 40),
		new MapLocationButton("Sunyshore\nCity", SunyshoreCityState::new, 1195, 680, 80, 40),
		new MapLocationButton("Route\n223", Route223State::new, 1205, 550, 60, 120),
		new MapLocationButton("Pokemon\nLeague", PokemonLeagueState::new, 1200, 500, 70, 40),
		new MapLocationButton("Victory\nRoad", VictoryRoadState::new, 1200, 450, 70, 40),
		new MapLocationButton("Pokemon\nLeague", PokemonLeagueState::new, 1200, 400, 70, 40)
	);

	private static GameManager gameManager;

	private static String songManifestPath;

	private static String songManifestType;

	public static void start(final GameManager gameManager, final String songManifestPath, final String songManifestType) {
		GUI.gameManager = gameManager;
		GUI.songManifestPath = songManifestPath;
		GUI.songManifestType = songManifestType;
		launch();
	}

    @Override
	public void start(final Stage primaryStage) {
		Group root = new Group();

		setupMapButtons(root);
		setupMusicPlayerNode(root);

		primaryStage.setTitle("Pokemon BDSP Automusic");
		primaryStage.setScene(new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT));
		primaryStage.show();
	}

	private void setupMapButtons(final Group root) {
		MAP_BUTTONS.forEach(buttonProperties -> {
			Button button = new Button();

			button.setLayoutX(buttonProperties.getX());
			button.setLayoutY(buttonProperties.getY());
			button.setPrefSize(buttonProperties.getWidth(), buttonProperties.getHeight());
			button.setText(buttonProperties.getButtonText());
			button.textAlignmentProperty().setValue(TextAlignment.CENTER);
			button.setOnAction(event -> gameManager.setCurrentState(buttonProperties.getInstanceSupplier().get()));

			root.getChildren().addAll(button);
		});
	}

	private void setupMusicPlayerNode(final Group root) {
		try {
			GUIMusicPlayer musicPlayer = setupMusicPlayer(songManifestPath, songManifestType);
			Node node = musicPlayer.getCurrentSongNode();
			node.setLayoutX(1000);
			node.setLayoutY(10);
			root.getChildren().add(node);

			Timeline musicLoop = new Timeline(new KeyFrame(Duration.millis(10), event -> {
				musicPlayer.play(gameManager.getCurrentState().getSong());
			}));

			musicLoop.setCycleCount(Timeline.INDEFINITE);
			musicLoop.play();
		} catch (final IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	private static GUIMusicPlayer setupMusicPlayer(final String songManifestPath, final String songManifestType) throws IOException {
        Map<Songs, String> songManifest = MusicUtils.parseSongManifest(songManifestPath);

        if (songManifestType.equals("local")) {
            return new SimpleGUIMusicPlayer(new LocalMusicPlayer(songManifest));
        } else {
            return new YoutubeGUIMusicPlayer(songManifest);
        }
    }
}

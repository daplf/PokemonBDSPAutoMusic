package daplf.pokemon.bdsp.automusic.gui.music;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import javafx.concurrent.Worker;
import javafx.scene.Node;
import javafx.scene.web.WebView;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class YoutubeGUIMusicPlayer implements GUIMusicPlayer {

    private static final Pattern VIDEO_ID_REGEX = Pattern.compile("(?!v)(?!=)([^&]*)");

    private Map<Songs, String> songs = new HashMap<>();

    @Getter
    private Songs currentSong = null;

    private WebView webView = new WebView();

    private boolean ready = false;

    public YoutubeGUIMusicPlayer(final Map<Songs, String> songManifest) {
        songManifest.entrySet().forEach(entry -> {
            try {
                URL url = new URL(entry.getValue());

                if (url.getHost().equals("youtube.com") || url.getHost().equals("www.youtube.com")) {
                    Matcher videoIdMatcher = VIDEO_ID_REGEX.matcher(url.getQuery());

                    if (videoIdMatcher.find()) {
                        String videoId = videoIdMatcher.group();
                        songs.put(entry.getKey(), videoId);
                    }
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException("Failed to parse URL: " + entry.getValue());
            }
        });
        webView.getEngine().load("https://www.youtube.com/embed?autoplay=1&loop=1");
        webView.setPrefSize(320, 240);
        webView.getEngine().getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                ready = true;
            }
        });
    }

    @Override
    public void play(final Songs song) {
        if (ready && (currentSong == null || currentSong != song)) {
            log.info("Playing: {}", song);

            String videoId = songs.get(song);
            webView.getEngine().executeScript("{" +
                "let player = document.getElementById('player');" +
                    "if (player != null) {" +
                        "player.firstChild.loadVideoById('" + videoId + "');" +
                        "player.firstChild.setLoop(true);" +
                        "player.firstChild.playVideo();" +
                    "}" +
            "}");

            currentSong = song;
        }
    }

    @Override
    public Node getCurrentSongNode() {
        return webView;
    }
}

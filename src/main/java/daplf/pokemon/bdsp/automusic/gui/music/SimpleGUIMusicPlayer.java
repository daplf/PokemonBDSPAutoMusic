package daplf.pokemon.bdsp.automusic.gui.music;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import daplf.pokemon.bdsp.automusic.music.MusicPlayer;
import javafx.scene.Node;
import javafx.scene.control.Label;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SimpleGUIMusicPlayer implements GUIMusicPlayer {

    private final MusicPlayer musicPlayer;

    private final Label currentSongLabel = new Label("No song playing");

    @Override
    public Node getCurrentSongNode() {
        return currentSongLabel;
    }

    @Override
    public void play(Songs song) {
        musicPlayer.play(song);
        Songs currentSong = musicPlayer.getCurrentSong();
        if (currentSong != null) {
            currentSongLabel.setText(currentSong.toString());
        }
    }

    @Override
    public Songs getCurrentSong() {
        return musicPlayer.getCurrentSong();
    }
}

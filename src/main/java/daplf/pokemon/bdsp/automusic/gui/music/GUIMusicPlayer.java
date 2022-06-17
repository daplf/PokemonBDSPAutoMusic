package daplf.pokemon.bdsp.automusic.gui.music;

import daplf.pokemon.bdsp.automusic.music.MusicPlayer;
import javafx.scene.Node;

public interface GUIMusicPlayer extends MusicPlayer {

    Node getCurrentSongNode();
}

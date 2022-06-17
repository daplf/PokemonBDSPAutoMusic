package daplf.pokemon.bdsp.automusic.music;

import daplf.pokemon.bdsp.automusic.game.music.Songs;

public interface MusicPlayer {

    void play(final Songs song);

    Songs getCurrentSong();
}

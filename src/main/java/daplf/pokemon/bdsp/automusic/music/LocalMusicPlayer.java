package daplf.pokemon.bdsp.automusic.music;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import daplf.pokemon.bdsp.automusic.game.music.Songs;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalMusicPlayer implements MusicPlayer {

    private Map<Songs, File> songs = new HashMap<>();

    private Clip clip;

    @Getter
    private Songs currentSong = null;

    public LocalMusicPlayer(final Map<Songs, String> songManifest) {
        songManifest.entrySet().forEach(entry -> {
            songs.put(entry.getKey(), new File(entry.getValue()));
        });

        try {
            clip = AudioSystem.getClip();
        } catch (final LineUnavailableException ex) {
            log.error("Error occurred getting a clip instance: {}", ex.getMessage());
            throw new RuntimeException("Failed to get a clip instance");
        }
    }

    @Override
    public void play(final Songs song) {
        if (currentSong == null || currentSong != song) {
            try {
                log.info("Playing: {}", song);
                AudioInputStream audioStream =  AudioSystem.getAudioInputStream(songs.get(song));

                clip.close();
                clip.open(audioStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);

                currentSong = song;
            } catch (final LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                log.error("Error playing new song: {}", ex.getMessage());
            }
        }
    }
}

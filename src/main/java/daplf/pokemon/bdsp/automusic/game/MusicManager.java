package daplf.pokemon.bdsp.automusic.game;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MusicManager {

    public enum Song {
        TWINLEAF_TOWN_DAY,
        TWINLEAF_TOWN_NIGHT,
        ROUTE_201_DAY,
        ROUTE_201_NIGHT,
        BATTLE_WILD,
        LAKE,
        CHOOSE_STARTER
    }

    private Map<Song, File> songs = new HashMap<>();

    private Clip clip;

    private Song currentSong = null;

    public MusicManager(final Map<Song, String> songManifest) {
        songManifest.entrySet().forEach(entry -> {
            songs.put(entry.getKey(),new File(entry.getValue()));
        });

        try {
            clip = AudioSystem.getClip();
        } catch (final LineUnavailableException ex) {
            log.error("Error occurred getting a clip instance: {}", ex.getMessage());
            throw new RuntimeException("Failed to get a clip instance");
        }
    }

    public void play(final Song song) {
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

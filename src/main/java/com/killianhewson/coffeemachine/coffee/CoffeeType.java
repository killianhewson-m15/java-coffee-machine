package com.killianhewson.coffeemachine.coffee;

import com.killianhewson.coffeemachine.logging.ApplicationLogger;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

/** Base class for the coffee types available from the machine. */
public abstract class CoffeeType {

    private final String nameKey;
    private final int preparationTime;
    private final String soundFile;

    protected CoffeeType(String nameKey, int preparationTime, String soundFile) {
        this.nameKey = nameKey;
        this.preparationTime = preparationTime;
        this.soundFile = soundFile;
    }

    public String getNameKey() {
        return nameKey;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public abstract String getPreparationMessageKey();

    /** Starts the sound associated with this coffee when the resource is available. */
    public Optional<Clip> playSound() {
        URL soundResource = getClass().getClassLoader().getResource("sounds/" + soundFile);

        if (soundResource == null) {
            ApplicationLogger.warning("Sound resource was not found: " + soundFile, null);
            return Optional.empty();
        }

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundResource)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            return Optional.of(clip);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
            ApplicationLogger.warning("Unable to play sound: " + soundFile, exception);
            return Optional.empty();
        }
    }
}


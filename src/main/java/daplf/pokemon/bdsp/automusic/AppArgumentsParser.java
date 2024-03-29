package daplf.pokemon.bdsp.automusic;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public class AppArgumentsParser {

    private CommandLineParser parser;

    private Options options;

    public AppArgumentsParser() {
        this.parser = new DefaultParser();
        this.options = new Options();

        options.addOption(Option.builder("d").longOpt("device").desc("the device number").hasArg(true).required(true).build());
        options.addOption(Option.builder("w").longOpt("width").desc("the width of the device output").hasArg(true).required(true).build());
        options.addOption(Option.builder("h").longOpt("height").desc("the height of the device output").hasArg(true).required(true).build());
        options.addOption(Option.builder("gw").longOpt("game-width").desc("the width of the game inside the output device").hasArg(true).required(false).build());
        options.addOption(Option.builder("gh").longOpt("game-height").desc("the height of the game inside the output device").hasArg(true).required(false).build());
        options.addOption(Option.builder("gx").longOpt("game-offset-x").desc("the X offset of the game inside the output device").hasArg(true).required(false).build());
        options.addOption(Option.builder("gy").longOpt("game-offset-y").desc("the Y offset of the game inside the output device").hasArg(true).required(false).build());
        options.addOption(Option.builder("s").longOpt("song-manifest").desc("the song manifest path").hasArg(true).required(true).build());
        options.addOption(Option.builder("st").longOpt("song-manifest-type").desc("the song manifest type (local/youtube)").hasArg(true).required(false).build());
        options.addOption(Option.builder("de").longOpt("debug").desc("output debug logging").build());
    }

    public AppArguments parseArguments(final String[] args) {
        try {
            CommandLine line = parser.parse(options, args);

            int device = Integer.parseInt(line.getOptionValue("d"));
            int width = Integer.parseInt(line.getOptionValue("w"));
            int height = Integer.parseInt(line.getOptionValue("h"));
            int gameWidth = Integer.parseInt(line.getOptionValue("gw", String.valueOf(width)));
            int gameHeight = Integer.parseInt(line.getOptionValue("gh", String.valueOf(height)));
            int gameOffsetX = Integer.parseInt(line.getOptionValue("gx", String.valueOf(0)));
            int gameOffsetY = Integer.parseInt(line.getOptionValue("gy", String.valueOf(0)));
            String songManifestPath = line.getOptionValue("s");
            String songManifestType = line.getOptionValue("st", "local");
            boolean debug = line.hasOption("de");

            Logger root = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
            
            if (debug) {
                root.setLevel(Level.DEBUG);
            } else {
                root.setLevel(Level.INFO);
            }

            return new AppArguments(device, width, height, gameWidth, gameHeight, gameOffsetX, gameOffsetY, songManifestPath, songManifestType);
        } catch (final ParseException ex) {
            throw new RuntimeException("Failed to parse program arguments: " + ex.getMessage());
        }
    }
}

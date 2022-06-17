package daplf.pokemon.bdsp.automusic;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

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
        options.addOption(Option.builder("s").longOpt("song-manifest").desc("the song manifest path").hasArg(true).required(true).build());
        options.addOption(Option.builder("st").longOpt("song-manifest-type").desc("the song manifest type (local/youtube)").hasArg(true).required(false).build());
    }

    public AppArguments parseArguments(final String[] args) {
        try {
            CommandLine line = parser.parse(options, args);

            int device = Integer.parseInt(line.getOptionValue("d"));
            int width = Integer.parseInt(line.getOptionValue("w"));
            int height = Integer.parseInt(line.getOptionValue("h"));
            int gameWidth = Integer.parseInt(line.getOptionValue("gw", String.valueOf(width)));
            int gameHeight = Integer.parseInt(line.getOptionValue("gh", String.valueOf(height)));
            String songManifestPath = line.getOptionValue("s");
            String songManifestType = line.getOptionValue("st", "youtube");

            return new AppArguments(device, width, height, gameWidth, gameHeight, songManifestPath, songManifestType);
        } catch (final ParseException ex) {
            throw new RuntimeException("Failed to parse program arguments: " + ex.getMessage());
        }
    }
}

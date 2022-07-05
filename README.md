# PokemonBDSPAutoMusic

A tool to auto play Pokemon BDSP songs depending on where you are currently in the game. It requires a capture card. The tool consumes the capture card output and tries to understand where you are in the game based on what's on screen.

The tool uses OpenCV for the image recognition stuff.

Here's a demo showing how it works: https://www.youtube.com/watch?v=PgHiY_KTaB0

## Motivation

If you've ever done/watched a Pokemon BDSP speedrun, you've certainly noticed that the game is a lot faster with the Background Music option set to 0. This unfortunately makes the speedrun very dull. This tool tries to solve this issue by playing BDSP songs based on the output of your capture card.

## Disclaimer

This is currently just a prototype. I have only tested it on Windows 10 and using an Elgato HD60 S+ capture card. A minimal version of the entire game is covered, but it has not been thoroughly tested. It was built with the Kadachar route in mind, which means only things that are used by this route are considered for now. Other things may or may not work. I also left out some events for now (either because they were not that relevant for a first release or because they were very difficult to include).

## Usage

You need Java 11+ to use the tool. You can then download the [latest release](https://github.com/daplf/PokemonBDSPAutoMusic/releases) (the JAR file) and run:

```
java -jar pokemon-bdsp-automusic.jar -d <device-number> -w <device-width> -h <device-height> -gw <game-width> -gh <game-height> -gx <game-offset-x> -gy <game-offset-y> -s <path-to-song-manifest> -st <song-manifest-type>
```

Where:

- `device-number` - The number of your capturing device. Anything your computer recognizes as a camera (this includes capture cards) is given an index (starting with 0). You can technically find the number of your capture card using other tools (like ffmpeg) but you can just try to run the tool with 0, 1, 2, etc until it works. Note that if you use a virtual camera, the index will be different than the one used for the capture card.
- `device-width` - The width of your capturing device (e.g., 1920).
- `device-height` - The height of your capturing device (e.g., 1080).
- `game-width` - The width of your game window (e.g., 1920). This is optional and it's only relevant when your game window doesn't match the capture device resolution (see [Setting up a Virtual Camera](#setting-up-a-virtual-camera)).
- `game-height` - The height of your game window (e.g., 1080). This is optional and it's only relevant when your game window doesn't match the capture device resolution (see [Setting up a Virtual Camera](#setting-up-a-virtual-camera)).
- `game-offset-x` - The X offset of your game window (e.g., 100). This is optional and it's only relevant when your game window doesn't match the capture device resolution (see [Setting up a Virtual Camera](#setting-up-a-virtual-camera)).
- `game-offset-y` - The Y offset of your game window (e.g., 100). This is optional and it's only relevant when your game window doesn't match the capture device resolution (see [Setting up a Virtual Camera](#setting-up-a-virtual-camera)).
- `path-to-song-manifest` - The file system path to your song manifest (see [Song Manifest](#song-manifest)).
- `song-manifest-type` - The type of song manifest. Supported values: `local` and `youtube` (defaults to `local`).

## GUI

The tool has a GUI to help you change the current state (song) in case you need it for whatever reason. This can be helpful if you run into a bug (e.g., some transition failed). In this situation, you can use the GUI to manually set the state, allowing you to continue listening to all the songs for the remainder of your run. If you do find a bug though, make sure you report it so it can hopefully be fixed.

Please keep in mind that using one of the buttons will change the state, which means any possible transitions from that state to the next ones will still happen. As such, if you set the wrong state for a location, unexpected transitions may still occur depending on whatever is on screen. For example, if you set the battle state while near a cave and you enter the cave, the battle state will end (because the battle state ends whenever you get a black screen).

## Setting up a Virtual Camera

Since you can't use the capture card with multiple apps at the same time, you'll most likely need to set up some kind of virtual camera. Streamlabs and OBS support this (although I've only tested it with Streamlabs). Streamlabs provides a Virtual Webcam feature (needs to be installed) that allows a virtual camera to be created based on your current scene. If your game window doesn't occupy the entire scene (for example, because you also have splits on it), you can use the `-gw`, `-gh`, `-gx` and `-gy` command line options to specify the resolution and location of the game window inside the scene. The tool will then resize the templates used for image recognition accordingly.

Note that this is only needed because you will be recording/streaming your speedrun. If you weren't, you could just use the capture card output directly using this tool.

## Song manifest

I do not provide the songs as part of the tool. You have to get them yourself. The tool currently only supports `.wav` files. You can use the `-s` command line option to specify the path to a song manifest file. The song manifest file looks like this:

```
twinleaf-town-day=C:\\path\\to\\twinleaf-town-day.wav
twinleaf-town-night=C:\\path\\to\\twinleaf-town-day.wav
route-201-day=C:\\path\\to\\route-201-day.wav
route-201-night=C:\\path\\to\\route-201-day.wav
battle-wild=C:\\path\\to\\battle-wild.wav
lake=C:\\path\\to\\lake.wav
choose-starter=C:\\path\\to\\choose-starter.wav
sandgem-town-day=C:\\path\\to\\sandgem-town-day.wav
sandgem-town-night=C:\\path\\to\\sandgem-town-day.wav
pokemon-center-day=C:\\path\\to\\pokemon-center-day.wav
pokemon-center-night=C:\\path\\to\\pokemon-center-day.wav
poke-mart=C:\\path\\to\\poke-mart.wav
pokemon-lab=C:\\path\\to\\pokemon-lab.wav
battle-trainer=C:\\path\\to\\battle-trainer.wav
jubilife-city-day=C:\\path\\to\\jubilife-city-day.wav
jubilife-city-night=C:\\path\\to\\jubilife-city-day.wav
route-203-day=C:\\path\\to\\route-203-day.wav
route-203-night=C:\\path\\to\\route-203-day.wav
battle-rival=C:\\path\\to\\battle-rival.wav
oreburgh-gate=C:\\path\\to\\oreburgh-gate.wav
oreburgh-city-day=C:\\path\\to\\oreburgh-city-day.wav
oreburgh-city-night=C:\\path\\to\\oreburgh-city-day.wav
pokemon-gym=C:\\path\\to\\pokemon-gym.wav
battle-gym-leader=C:\\path\\to\\battle-gym-leader.wav
battle-galactic-grunt=C:\\path\\to\\battle-galactic-grunt.wav
floaroma-town-day=C:\\path\\to\\floaroma-town-day.wav
floaroma-town-night=C:\\path\\to\\floaroma-town-day.wav
route-205-day=C:\\path\\to\\route-205-day.wav
route-205-night=C:\\path\\to\\route-205-day.wav
battle-galactic-commander=C:\\path\\to\\battle-galactic-commander.wav
eterna-forest=C:\\path\\to\\eterna-forest.wav
eterna-city-day=C:\\path\\to\\eterna-city-day.wav
eterna-city-night=C:\\path\\to\\eterna-city-day.wav
galactic-eterna-building=C:\\path\\to\\galactic-eterna-building.wav
route-206-day=C:\\path\\to\\route-206-day.wav
route-206-night=C:\\path\\to\\route-206-day.wav
hearthome-city-day=C:\\path\\to\\hearthome-city-day.wav
hearthome-city-night=C:\\path\\to\\hearthome-city-day.wav
route-209-day=C:\\path\\to\\route-209-day.wav
route-209-night=C:\\path\\to\\route-209-day.wav
solaceon-town-day=C:\\path\\to\\solaceon-town-day.wav
solaceon-town-night=C:\\path\\to\\solaceon-town-day.wav
route-210-day=C:\\path\\to\\route-210-day.wav
route-210-night=C:\\path\\to\\route-210-day.wav
veilstone-city-day=C:\\path\\to\\veilstone-city-day.wav
veilstone-city-night=C:\\path\\to\\veilstone-city-day.wav
valor-lakefront-day=C:\\path\\to\\valor-lakefront-day.wav
valor-lakefront-night=C:\\path\\to\\valor-lakefront-day.wav
canalave-city-day=C:\\path\\to\\canalave-city-day.wav
canalave-city-night=C:\\path\\to\\canalave-city-day.wav
route-216-day=C:\\path\\to\\route-216-day.wav
route-216-night=C:\\path\\to\\route-216-day.wav
snowpoint-city-day=C:\\path\\to\\snowpoint-city-day.wav
snowpoint-city-night=C:\\path\\to\\snowpoint-city-day.wav
galactic-hq=C:\\path\\to\\galactic-hq.wav
battle-galactic-boss=C:\\path\\to\\battle-galactic-boss.wav
deep-within-galactic-hq=C:\\path\\to\\deep-within-galactic-hq.wav
mount-coronet=C:\\path\\to\\mount-coronet.wav
spear-pillar=C:\\path\\to\\spear-pillar.wav
legendary-appears=C:\\path\\to\\legendary-appears.wav
catastrophe=C:\\path\\to\\catastrophe.wav
lake-caverns=C:\\path\\to\\lake-caverns.wav
battle-dialga-palkia=C:\\path\\to\\battle-dialga-palkia.wav
sunyshore-city-day=C:\\path\\to\\sunyshore-city-day.wav
sunyshore-city-night=C:\\path\\to\\sunyshore-city-day.wav
victory-road=C:\\path\\to\\victory-road.wav
pokemon-league-day=C:\\path\\to\\pokemon-league-day.wav
pokemon-league-night=C:\\path\\to\\pokemon-league-day.wav
decisive-battle=C:\\path\\to\\decisive-battle.wav
elite-four-appears=C:\\path\\to\\elite-four-appears.wav
battle-elite-four=C:\\path\\to\\battle-elite-four.wav
cynthia-theme=C:\\path\\to\\cynthia-theme.wav
battle-champion=C:\\path\\to\\battle-champion.wav
hall-of-fame=C:\\path\\to\\hall-of-fame.wav
congratulations-hall-of-fame=C:\\path\\to\\congratulations-hall-of-fame.wav
ending-theme=C:\\path\\to\\ending-theme.wav
```

I also provide experimental support for Youtube backed songs. You can use the `-st youtube` option to use the youtube player. The manifest is the same, but with youtube URLs rather than local file URIs.

## Development

You need JDK 11 and Maven installed.

To package the tool, use:

```
mvn clean package
```

Afterwards, you can run it with:

```
java -jar target\pokemon-bdsp-automusic-jar-with-dependencies.jar -d <device-number> -w <device-width> -h <device-height> -gw <game-width> -gh <game-height> -s <path-to-song-manifest>
```

## Authors

[Furyst](https://www.speedrun.com/user/Furyst)

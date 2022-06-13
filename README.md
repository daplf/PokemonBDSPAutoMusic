# PokemonBDSPAutoMusic

A tool to auto play Pokemon BDSP songs depending on where you are currently in the game. It requires a capture card. The tool consumes the capture card input and tries to understand where you are in the game based on what's on screen.

The tool uses OpenCV for the image recognition stuff.

## Motivation

If you've ever done/watched a Pokemon BDSP speedrun, you've certainly noticed that the game is a lot faster with the Background Music option set to 0. This unfortunately makes the speedrun very dull. This tool tries to solve this issue by playing BDSP songs based on the output of your capture card.

## Disclaimer

This is currently just a prototype. I have only tested it on Windows 10 and using an Elgato HD60 S+ capture card. Only the first 5 minutes of the game are supported for now. If there's enough interest, I can keep working on this to cover the entire game.

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

Where:

- `device-number` - The number of your capturing device. Anything your computer recognizes as a camera (this includes capture cards) is given an index (starting with 0). You can technically find the number of your capture card using other tools (like ffmpeg) but you can just try to run the tool with 0, 1, 2, etc until it works. Note that if you use a virtual camera, the index will be different than the one used for the capture card.
- `device-width` - The width of your capturing device (e.g., 1920).
- `device-height` - The height of your capturing device (e.g., 1080).
- `game-width` - The width of your game window (e.g., 1920). This is optional and it's only relevant when your game window doesn't match the capture device resolution (see [Setting up a Virtual Camera](#Setting_up_a_virtual_camera)).
- `game-height` - The width of your game window (e.g., 1080). This is optional and it's only relevant when your game window doesn't match the capture device resolution (see [Setting up a Virtual Camera](#Setting_up_a_virtual_camera)).
- `path-to-song-manifest` - The file system path to your song manifest (see [Song Manifest](##Song_manifest)).

## Setting up a Virtual Camera

Since you can't use the capture card with multiple apps at the same time, you'll most likely need to set up some kind of virtual camera. Streamlabs and OBS support this (although I've only tested it with Streamlabs). Streamlabs provides a Virtual Webcam feature (needs to be installed) that allows a virtual camera to be created based on your current scene. If your game window doesn't occupy the entire scene (for example, because you also have splits on it), you can use the `-gw` and `-gh` command line options to specify the resolution of the game window inside the scene. The tool will then resize the templates used for image recongition accordingly.

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
```

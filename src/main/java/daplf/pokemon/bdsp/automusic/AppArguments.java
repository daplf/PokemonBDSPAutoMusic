package daplf.pokemon.bdsp.automusic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AppArguments {

    private final int device;
    
    private final int width;

    private final int height;

    private final int gameWidth;

    private final int gameHeight;

    private final int gameOffsetX;

    private final int gameOffsetY;

    private final String songManifestPath;

    private final String songManifestType;
}

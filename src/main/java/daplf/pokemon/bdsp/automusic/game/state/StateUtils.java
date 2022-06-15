package daplf.pokemon.bdsp.automusic.game.state;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public abstract class StateUtils {

    public static Mat getAreaTitleSubmatrix(final Mat frame) {
        return ImageUtils.getProportionalSubmat(frame, 0, 140, 0, 900);
    }

    public static double matchAreaTitle(final Mat frame, final Mat template) {
        return ImageUtils.matchTemplate(getAreaTitleSubmatrix(frame), template);
    }
}

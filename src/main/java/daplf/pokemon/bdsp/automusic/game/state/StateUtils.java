package daplf.pokemon.bdsp.automusic.game.state;

import org.opencv.core.Mat;

import daplf.pokemon.bdsp.automusic.image.ImageUtils;

public abstract class StateUtils {

    public static Mat getAreaTitleSubmatrix(final Mat frame) {
        return ImageUtils.getProportionalSubmat(frame, 0, 140, 0, 900);
    }

    public static Mat getNameTagSubmatrix(final Mat frame) {
        return ImageUtils.getProportionalSubmat(frame, 800, 875, 385, 860);
    }

    public static double matchAreaTitle(final Mat frame, final Mat template) {
        Mat submat = getAreaTitleSubmatrix(frame);
        double result = ImageUtils.matchTemplate(submat, template);
        submat.release();
        return result;
    }

    public static double matchNameTag(final Mat frame, final Mat template) {
        Mat submat = getNameTagSubmatrix(frame);
        double result = ImageUtils.matchTemplate(submat, template);
        submat.release();
        return result;
    }
}

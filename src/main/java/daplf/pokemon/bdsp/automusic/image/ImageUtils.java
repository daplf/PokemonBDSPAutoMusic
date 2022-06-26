package daplf.pokemon.bdsp.automusic.image;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import daplf.pokemon.bdsp.automusic.utils.ConfigurationProperties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImageUtils {

    private ImageUtils() {}

    private static Map<String, Mat> images = new HashMap<>();

    public static double matchTemplate(final Mat image, final Mat template) {
        if (image.width() >= template.width() && image.height() >= template.height()) {
            Mat result = new Mat();
            Imgproc.matchTemplate(image, template, result, Imgproc.TM_CCOEFF_NORMED);

            MinMaxLocResult mmr = Core.minMaxLoc(result);
            double matchResult = mmr.maxVal;
            result.release();
            return matchResult;
        } else {
            return 0.0;
        }
    }

    public static double matchTemplateSqDiff(final Mat image, final Mat template) {
        if (image.width() >= template.width() && image.height() >= template.height()) {
            Mat result = new Mat();
            Imgproc.matchTemplate(image, template, result, Imgproc.TM_SQDIFF_NORMED);

            MinMaxLocResult mmr = Core.minMaxLoc(result);
            double matchResult = mmr.minVal;
            result.release();
            return matchResult;
        } else {
            return 1.0;
        }
    }

    public static boolean isBlackScreen(final Mat image) {
        Mat imageGray = new Mat();
        Imgproc.cvtColor(image, imageGray, Imgproc.COLOR_BGR2GRAY);
        boolean result = Core.countNonZero(imageGray) == 0;
        imageGray.release();
        return result;
    }

    public static Mat getImageResource(final String resourceName) {
        Mat res = images.get(resourceName);

        if (res == null) {
            try {
                InputStream resourceStream = ImageUtils.class.getClassLoader().getResourceAsStream(resourceName);
                byte[] imageBytes = IOUtils.toByteArray(resourceStream);

                res = Imgcodecs.imdecode(new MatOfByte(imageBytes), Imgcodecs.IMREAD_UNCHANGED);
                Imgproc.resize(res, res, new Size(res.width() * ConfigurationProperties.IMAGE_WIDTH_FACTOR, res.height() * ConfigurationProperties.IMAGE_HEIGHT_FACTOR));
                
                images.put(resourceName, res);
            } catch (final IOException ex) {
                log.error("Error reading an image resource: {}", ex.getMessage());
            }
        }

        return res;
    }

    public static Mat getProportionalSubmat(final Mat mat, final int rowStart, final int rowEnd, final int colStart, final int colEnd) {
        return mat.submat(
            ConfigurationProperties.IMAGE_OFFSET_Y + (int) (rowStart * ConfigurationProperties.IMAGE_HEIGHT_FACTOR),
            ConfigurationProperties.IMAGE_OFFSET_Y + (int) (rowEnd * ConfigurationProperties.IMAGE_HEIGHT_FACTOR),
            ConfigurationProperties.IMAGE_OFFSET_X + (int) (colStart * ConfigurationProperties.IMAGE_WIDTH_FACTOR),
            ConfigurationProperties.IMAGE_OFFSET_X + (int) (colEnd * ConfigurationProperties.IMAGE_WIDTH_FACTOR)
        );
    }

    public static Mat getGameWindowSubmat(final Mat mat) {
        return mat.submat(
            ConfigurationProperties.IMAGE_OFFSET_Y,
            ConfigurationProperties.IMAGE_OFFSET_Y + ConfigurationProperties.IMAGE_HEIGHT,
            ConfigurationProperties.IMAGE_OFFSET_X,
            ConfigurationProperties.IMAGE_OFFSET_X + ConfigurationProperties.IMAGE_WIDTH
        );
    }
}

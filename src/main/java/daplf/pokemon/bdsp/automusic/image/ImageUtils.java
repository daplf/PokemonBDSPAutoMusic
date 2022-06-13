package daplf.pokemon.bdsp.automusic.image;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.opencv.core.Core;
import org.opencv.core.Mat;
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
            return mmr.maxVal;
        } else {
            return 0.0;
        }
    }

    public static boolean isBlackScreen(final Mat image) {
        Mat imageGray = new Mat();
        Imgproc.cvtColor(image, imageGray, Imgproc.COLOR_BGR2GRAY);
        return Core.countNonZero(imageGray) == 0;
    }

    public static Mat getImageResource(final String resourceName) {
        Mat res = images.get(resourceName);

        if (res == null) {
            try {
                URL resource = ImageUtils.class.getClassLoader().getResource(resourceName);
                String path = Paths.get(resource.toURI()).toAbsolutePath().toString();

                res = Imgcodecs.imread(path);
                Imgproc.resize(res, res, new Size(res.width() * ConfigurationProperties.IMAGE_WIDTH_FACTOR, res.height() * ConfigurationProperties.IMAGE_HEIGHT_FACTOR));
                
                images.put(resourceName, res);
            } catch (final URISyntaxException ex) {
                log.error("Error parsing the resource URL. This is most certainly a bug: {}", ex.getMessage());
            }
        }

        return res;
    }
}

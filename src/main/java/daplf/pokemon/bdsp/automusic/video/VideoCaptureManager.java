package daplf.pokemon.bdsp.automusic.video;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class VideoCaptureManager {

    private VideoCapture videoCapture;

    public VideoCaptureManager(final int captureDeviceIndex, final int width, final int height) {
        videoCapture = new VideoCapture(captureDeviceIndex);
        videoCapture.set(Videoio.CAP_PROP_FRAME_WIDTH, width);
        videoCapture.set(Videoio.CAP_PROP_FRAME_HEIGHT, height);

        /**
         * We need to grab all the frames as they come in. This allows #getCurrentFrame to actually retrieve the current frame.
         */
        new Thread(() -> {
            while (true) {
                if (!videoCapture.grab()) break;
            }
        }).start();
    }

    public Mat getCurrentFrame() {
        Mat image = new Mat();
        
        if (videoCapture.retrieve(image)) {
            return image;
        } else {
            return null;
        }
    }
}

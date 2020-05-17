package camera.model;

import camera.ui.CameraTextUI;

public class DOFCalculator {

    // (focal length)^2 / (aperture/circle of confusion)
    public static double hyperFocalDist(int focalLength, double aperture, double coc) {
        double top = focalLength * focalLength;
        double bottom = aperture*coc;
        return top/bottom;
    }

    // (hyper focal * distance)/ (hyper focal + (distance - focal length))
    public static double nearFocalPoint(double hyperFocal, double distance, double focalLength) {
        double top = hyperFocal*distance;
        double bottom = (hyperFocal +(distance-focalLength));
        return top/bottom;
    }

    //(hyper focal * distance)/ (hyper focal + (distance - focal length)
    public static double farFocalPoint(double hyperFocal, double distance, double focalLength) {
        double farFocal;
        if (distance > hyperFocal ) {
            farFocal = Double.POSITIVE_INFINITY;
        } else {
            double top = hyperFocal * distance;
            double bottom = (hyperFocal - (distance - focalLength));
            farFocal = top / bottom;
        }
        return farFocal;
    }

    // far focal - near focal
    public static double depthOfField (double farFocal, double nearFocal) {
        return (farFocal-nearFocal);
    }

}

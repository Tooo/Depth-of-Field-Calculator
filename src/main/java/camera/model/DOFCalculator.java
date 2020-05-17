package camera.model;

import camera.ui.CameraTextUI;

public class DOFCalculator {

    // (focal length)^2 / (aperture/circle of confusion)
    private double hyperFocalDist(int focalLength, double aperture, double coc) {
        double top = focalLength * focalLength;
        double bottom = aperture*coc;
        return top/bottom;
    }

    // (hyper focal * distance)/ (hyper focal + (distance - focal length))
    private double nearFocalPoint(double hyperFocal, int distance, int focalLength) {
        double top = hyperFocal*distance;
        double bottom = (hyperFocal +(distance-focalLength));
        return top/bottom;
    }

    //(hyper focal * distance)/ (hyper focal + (distance - focal length)
    private double farFocalPoint(double hyperFocal, int distance, int focalLength) {
        double top = hyperFocal*distance;
        double bottom = (hyperFocal - (distance - focalLength));
        double farFocal = top/bottom;
        if (farFocal > hyperFocal) {
            farFocal = Double.POSITIVE_INFINITY;
        }
        return farFocal;
    }

    // far focal - near focal
    public int depthOfField (double aperture, int distance, int focalLength, double coc) {
        double hyperFocal = hyperFocalDist(focalLength, aperture, coc);
        double nearFocal = nearFocalPoint(hyperFocal, distance, focalLength);
        double farFocal = farFocalPoint(hyperFocal, distance, focalLength);
        return (int)(farFocal-nearFocal);
    }

}

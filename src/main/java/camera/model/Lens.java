package camera.model;

public class Lens {
    String make;
    double  maxAperture;
    int focalLength;

    public Lens (String make, double maxAperture, int focalLength) {
        this.make = make;
        this.maxAperture = maxAperture;
        this.focalLength = focalLength;
    }

}

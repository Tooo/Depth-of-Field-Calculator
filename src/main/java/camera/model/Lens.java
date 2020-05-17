package camera.model;

public class Lens {
    String make;
    float  maxAperture;
    int focalLength;

    public Lens (String make, float maxAperture, int focalLength) {
        this.make = make;
        this.maxAperture = maxAperture;
        this.focalLength = focalLength;
    }

}

package camera.ui;

import camera.model.DOFCalculator;
import camera.model.Lens;
import camera.model.LensManager;

import java.security.spec.RSAOtherPrimeInfo;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Sample (incomplete) text UI to interact with the user.
 * You may change any part of this!
 */
public class CameraTextUI {
    private static final double COC = 0.029;    // "Circle of Confusion" for a "Full Frame" camera
    private LensManager manager;
    private Scanner in = new Scanner(System.in);// Read from keyboard


    public CameraTextUI(LensManager manager) {
        // Accept and store a reference to the lens manager (the model)
        // (this design is called "dependency injection")
        this.manager = manager;

        // Populate lenses (Make, max aperture (smallest supported F number), focal length [mm]):
        manager.add(new Lens("Canon", 1.8, 50));
        manager.add(new Lens("Tamron", 2.8, 90));
        manager.add(new Lens("Sigma", 2.8, 200));
        manager.add(new Lens("Nikon", 4, 200));
    }

    public void show() {
        boolean isDone = false;
        while (!isDone) {
            lensListPrint();
            int choice = in.nextInt();
            if (choice == -1) {
                isDone = true;
            } else if (choice > 3 || choice < -1) {
                System.out.println("Error: Invalid lens index.\n");
            } else {
                Lens len = manager.get(choice);
                System.out.print("Aperture [the F number]: ");
                double aperture = in.nextDouble();
                if (aperture < len.getMaxAperture()) {
                    System.out.println("ERROR: This aperture is not possible with this lens\n");
                } else {
                    System.out.print("Distance to subject [m]: ");
                    double distance = in.nextDouble()*1000;
                    int focalLength = len.getFocalLength();
                    double hyperFocal = DOFCalculator.hyperFocalDist(focalLength, aperture, COC);
                    double nearFocal = DOFCalculator.nearFocalPoint(hyperFocal, distance, focalLength);
                    double farFocal = DOFCalculator.farFocalPoint(hyperFocal, distance, focalLength);
                    double depthOfField = DOFCalculator.depthOfField(farFocal, nearFocal);
                    System.out.println(" In focus: " + formatM(nearFocal/1000) +
                            "m to " + formatM(farFocal/1000) +
                            "m [DoF = " + formatM(depthOfField/1000) +
                            "m]");
                    System.out.println(" Hyperfocal point: " + formatM(hyperFocal/1000) +"m\n");
                }
            }

        }
    }

    //Print Lens List
    private void lensListPrint() {
        System.out.println("Lenses to pick from:");
        int count = 0;
        for (Lens lens : manager) {
            System.out.println(" " + count + ". " + lens);
            count++;
        }
        System.out.println(" (-1 to exit)");
        System.out.print(": ");
    }

    private String formatM(double distanceInM) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(distanceInM);
    }
}

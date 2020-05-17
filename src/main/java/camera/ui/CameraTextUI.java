package camera.ui;

import camera.model.Lens;
import camera.model.LensManager;

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
        int count = 0;
        boolean isDone = false;
        while (!isDone) {
            System.out.println("Lenses to pick from:");
            for (Lens lens : manager) {
                System.out.println(" " + count + ". " + lens);
                count++;
            }
            System.out.println(" (-1 to exit)");
            int choice = in.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("hihi");
                case 2:
                    System.out.println("byebye");
                    isDone = true;
                default:
                    System.out.println("invalid");
            }
        }
    }

    private String formatM(double distanceInM) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(distanceInM);
    }
}

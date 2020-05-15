import camera.ui.CameraTextUI;

/**
 * Launch application test
 */
public class Main {
    public static void main(String args[]) {
        LensManager manager = new LensManager();
        CameraTextUI ui = new CameraTextUI(manager);
        ui.show();
    }
}

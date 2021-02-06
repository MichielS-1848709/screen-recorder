import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static String getMonitorName(GraphicsDevice monitor) {
        String name = monitor.getIDstring();
        return name.substring(1);
    }

    public static void main(String[] args) {

        try {
            Robot robot = new Robot();

            // Multi monitor
            GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice[] monitors = environment.getScreenDevices();

            for (GraphicsDevice monitor : monitors) {
                Rectangle screen = monitor.getDefaultConfiguration().getBounds();

                BufferedImage screenshot = robot.createScreenCapture(screen);

                String monitorName = getMonitorName(monitor);
                String name = "screenshot-" + monitorName + ".png";
                File path = new File(name);
                ImageIO.write(screenshot,"png" , path);
            }

            System.out.println("Done!");
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }

    }

}

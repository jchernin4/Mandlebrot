import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageCreator {
    private int width;
    private int height;

    private BufferedImage bufferedImage;
    private Graphics2D g2d;

    public ImageCreator(int width, int height) {
        this.width = width;
        this.height = height;

        bufferedImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
        g2d = bufferedImage.createGraphics();

        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);
    }

    public void fillCoord(int x, int y, int n, int MAX_ITERS) {
        /*if (n != 0 || n == 0) {
            return;
        }*/
        //System.out.println("Printed coord " + x + " " + y + " " + n);

        int color = 255 - (int) (n * 255 / MAX_ITERS);
        g2d.setColor(Color.BLACK); // TODO: Change based on n value
        g2d.fillRect(x, y, 1, 1);
    }

    public void createImage() throws IOException {
        g2d.dispose();
        File file = new File("Output.png");
        ImageIO.write(bufferedImage, "png", file);
    }
}
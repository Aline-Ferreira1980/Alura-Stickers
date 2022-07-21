package resizeble;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class ResizeImage {


    public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 120, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

}
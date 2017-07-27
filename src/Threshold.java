import java.awt.image.BufferedImage;

/**
 * @author Matheus Buarque
 * @version 1.0
 * @since 2017-07-25
 */
public class Threshold {
	public static BufferedImage getBinaryImage(BufferedImage img, int thresholdValue){
		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {
				int r = (img.getRGB(x, y) & 0x00ff0000 >> 16);
				int g = (img.getRGB(x, y) & 0x0000ff00 >> 00);
				int b = (img.getRGB(x, y) & 0x000000ff);
				int grayscale = (int)(0.2126 * r + 0.7152 * g + 0.0722 * b);
				if (grayscale >= thresholdValue) {
					img.setRGB(x, y, 0xffffffff);
				}else{
					img.setRGB(x, y, 0x00000000);
				}
			}
		}
		return img;
	}
}

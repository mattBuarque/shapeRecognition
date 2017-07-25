import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Process {
	
	public static String IMAGE10X10 = "Quadrado10x10.jpg";
	
	private BufferedImage image;
	private HashMap<Integer, Mapping> map;

	public Process(BufferedImage image) {
		map = new HashMap<>();
		this.image = image;
	}
	
	protected void startProcessing(){
		int position = 0;
		for (int x = 0; x < getImage().getWidth(); x++) {
			for (int y = 0; y < getImage().getHeight(); y++) {
				int pixel = getPixel(y, y);
				if (pixel != -1) {
					getMap().put(position, new Mapping(x, y));
					position++;
				}
			}
		}
	}
	
	private int getPixel(int x, int y){
		return getImage().getRGB(x, y);
	}
	
	private String getRGB(int pixel){
		int red = (pixel & 0x00ff0000) >> 16;
		int green = (pixel & 0x0000ff00) >> 8;
		int blue = (pixel & 0x000000ff);
		return red + "|" + green + "|"+ blue;
	}
	
	private void checkRoundedPixels(int x, int y, boolean isCorner){
		int upPixel 	= 0;
		int downPixel 	= 0;
		int rightPixel 	= 0;
		int leftPixel 	= 0;
		int upRight		= 0;
		int upLeft		= 0;
		int downRight 	= 0;
		int downLeft 	= 0;
		
		if (isCorner) {
			
		}
		upPixel 	= getPixel(x - 1, y);
		downPixel 	= getPixel(x + 1, y);
		rightPixel 	= getPixel(x, y + 1);
		leftPixel	= getPixel(x, y - 1);
		upRight 	= getPixel(x - 1, y + 1);
		upLeft		= getPixel(x - 1, y - 1);
		downRight 	= getPixel(x + 1, y + 1);
		downLeft	= getPixel(x + 1, y - 1);
		
	}
	
	private void checkRoundedPixels(int x, int y){
		checkRoundedPixels(x, y, false);
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public HashMap<Integer, Mapping> getMap() {
		return map;
	}

	public void setMap(HashMap<Integer, Mapping> map) {
		this.map = map;
	}
}

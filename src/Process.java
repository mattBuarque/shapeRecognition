import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author Matheus Buarque
 * @version 1.0
 * @since 2017-07-25
 */
public class Process {
	
	public static String IMAGE10X10 = "Quadrado10x10.jpg";
	public static String IMAGE180X180 = "Quadrado180x180.jpg";
	public static String IMAGE520X520 = "Quadrado520x520.jpg";
	public static String IMAGEDIAGONAL490X490 = "QuadradoDiagonal490x490.jpg";
	public static String UNKNOWNSHAPE = "UnknownShape.jpg";
	
	private BufferedImage image;
	private LinkedHashMap<Integer, Mapping> map;
	private Shape shape;
	
	public Process(BufferedImage image) {
		this.map = new LinkedHashMap<>();
		this.image = image;
		this.shape = new Shape();
	}
	
	protected void startProcessing(){
//		ImageLog.writeInLog("Starting process [" + getImage().getWidth() + "x" + getImage().getHeight() + "]");
		setImage(Threshold.getBinaryImage(getImage(), 180));
		int position = 0;
		for (int x = 0; x < getImage().getWidth(); x++) {
			for (int y = 0; y < getImage().getHeight(); y++) {
				int pixel = getPixel(x, y);
				if (pixel != -1) {
					if (checkRoundedPixels(x, y, cornerPixel(x, y))) {
						getMap().put(position, new Mapping(x, y));
					}
					position++;
				}
			}
		}
		recognizeShape();
		System.out.println("Shape size (pixels): " + this.shape.getWidth() +"x"+ this.shape.getHeight());
		if (shape.getType() == Shape.UNKNOWNSHAPE) {
			System.out.println("\nANSWER: I did my job, but I'm like dumb baby, I only know some shapes.");
			return;
		}
		System.out.println("\nANSWER: I did my job, ur shape is a " + Shape.getName(shape.getType()) + "!");
//		ImageLog.writeInLog("Process finished");
//		ImageLog.writeInLog("=====================================================");
	}
	
	private int getPixel(int x, int y){
		return getImage().getRGB(x, y);
	}
	
	private boolean cornerPixel(int x, int y){
		return (x == 0 || y == 0 || x == getImage().getWidth() || y == getImage().getHeight());
	}
	
	private String getRGB(int pixel){
		int red = (pixel & 0x00ff0000) >> 16;
		int green = (pixel & 0x0000ff00) >> 8;
		int blue = (pixel & 0x000000ff);
		return red +"|" + green + "|"+ blue;
	}
	
	private boolean checkRoundedPixels(int x, int y, boolean isCorner){
		int rightPixel 	= 0;
		int downPixel 	= 0;
		int downRightPixel 	= 0;
		
		if (isCorner) {
			if (x == getImage().getWidth()) {
				rightPixel 		= getPixel(x, y + 1);
				return rightPixel != -1;
			}else if (y == getImage().getHeight()) {
				downPixel 		= getPixel(x + 1, y);
				return downPixel != -1;
			}
		}
		
		downPixel 		= getPixel(x + 1, y);
		rightPixel 		= getPixel(x, y + 1);
		downRightPixel 	= getPixel(x + 1, y + 1);
		if (downPixel != -1 || rightPixel != -1 || downRightPixel != -1) {
			return true;
		}
		return false;
		
	}
	
	private void recognizeShape(){
		int oldx = getMap().get(0).getX();
		int oldy = getMap().get(0).getY();
		for (Integer index : getMap().keySet()) {
			if (getMap().get(index).getX() != oldx) {
				this.shape.setWidth(shape.getWidth() + 1);
			}
			if (getMap().get(index).getY() < oldy) {
				this.shape.setHeight(shape.getHeight() + 1);
			}
			oldx = getMap().get(index).getX();
			oldy = getMap().get(index).getY();
//			ImageLog.writeInLog(oldx + " | " + oldy + " | " + index);
		}
		if (this.shape.getWidth() == this.shape.getHeight()) {
			shape.setType(Shape.SHAPESQUARE);
		}else{
			shape.setType(Shape.UNKNOWNSHAPE);
		}
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

	public void setMap(LinkedHashMap<Integer, Mapping> map) {
		this.map = map;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}
}

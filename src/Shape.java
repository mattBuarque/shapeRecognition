
/**
 * @author Matheus Buarque
 * @version 1.0
 * @since 2017-07-25
 */
public class Shape {
	
	public static final byte UNKNOWNSHAPE = 0;
	public static final byte SHAPESQUARE = 1;
	public static final byte SHAPERECTANGLE = 2;
	public static final byte SHAPETRIANGLE = 3;
	public static final byte SHAPECIRCLE = 4;
	
	private int width;
	private int height;
	private byte type;
	
	public Shape() {
		this.width = 0;
		this.height = 0;
	}
	
	public static String getName(byte type){
		switch (type) {
		case 0:
			return "Unknown";	
		case 1:
			return "Square";
		case 2:
			return "Rectangle";
		case 3:
			return "Triangle";
		case 4:
			return "Circle";
		}
		return "";
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}
}



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

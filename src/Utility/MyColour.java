package Utility;

/**
 * Created by Nishanth on 22/06/2016.
 */
public class MyColour {

	public float r, g, b;

	/**
	 * Black
	 */
	public MyColour () {
		r = 0.0F;
		g = 0.0F;
		b = 0.0F;
	}

	/**
	 * Unique colour
	 */
	public MyColour (float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public MyColour (MyColour colour) {
		r = colour.r;
		g = colour.g;
		b = colour.b;
	}

	public void add (MyColour colour) {
		r += colour.r;
		g += colour.g;
		b += colour.b;
	}

	public void divide (int scalar) {
		r /= scalar;
		g /= scalar;
		b /= scalar;
	}

	public int toInteger() {
		return (int)(r*255)<<16|(int)(g*255)<<8|(int)(b*255);
	}
}

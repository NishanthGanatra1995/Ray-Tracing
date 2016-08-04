package Utility;

/**
 * Created by Nishanth on 22/06/2016.
 */
public class MyPoint3D {

	public double x, y, z;

	/**
	 * Default constructor
	 */
	public MyPoint3D () {
		x = 0.0;
		y = 0.0;
		z = 0.0;
	}

	/**
	 * Constructor
	 */
	public MyPoint3D (double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Deep copy
	 */
	public MyPoint3D (MyPoint3D point3D) {
		x = point3D.x;
		y = point3D.y;
		z = point3D.z;
	}

	public MyPoint3D add (MyPoint3D point) {
		return new MyPoint3D(x+point.x, y+point.y, z+point.z);
	}

	public MyPoint3D subtract (MyPoint3D point) {
		return new MyPoint3D(x-point.x, y-point.y, z-point.z);
	}

	/**
	 * Projection of one point onto another to give scalar value
	 */
	public double dot (MyPoint3D point3D) {
		return x*point3D.x + y*point3D.y + z*point3D.z;
	}

	/**
	 * Projection of one point onto a vector to give scalar value
	 */
	public double dot (MyVector3D vector3D) {
		return x*vector3D.x + y*vector3D.y + z*vector3D.z;
	}

	public double dot (Normal normal) {
		return x*normal.x + y*normal.y + z*normal.z;
	}


}

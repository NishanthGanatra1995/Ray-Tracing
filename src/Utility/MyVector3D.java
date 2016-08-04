package Utility;

/**
 * Created by Nishanth on 22/06/2016.
 */
public class MyVector3D {

	public double x, y, z;

	public MyVector3D () {
		x = 0.0;
		y = 0.0;
		z = 0.0;
	}

	public MyVector3D (double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public MyVector3D (MyVector3D vector) {
		x = vector.x;
		y = vector.y;
		z = vector.z;
	}

	public MyVector3D add (MyVector3D vector3D) {
		return new MyVector3D(x+vector3D.x, y+vector3D.y, z+vector3D.z);
	}

	public MyVector3D subtract (MyVector3D vector3D) {
		return new MyVector3D(x-vector3D.x, y-vector3D.y, z-vector3D.z);
	}

	/**
	 * Projection of one vector onto another to give scalar value
	 */
	public double dot (MyVector3D vector3D) {
		return x*vector3D.x + y*vector3D.y + z*vector3D.z;
	}

	/**
	 * Projection of one vector onto a point to give scalar value
	 */
	public double dot (MyPoint3D point3D) {
		return x*point3D.x + y*point3D.y + z*point3D.z;
	}

	public double dot (Normal normal) {
		return x*normal.x + y*normal.y + z*normal.z;
	}

	public void normalize() {
		double magnitude = Math.sqrt(x*x + y*y +  z*z);

		x /= magnitude;
		y /= magnitude;
		z /= magnitude;
	}


}

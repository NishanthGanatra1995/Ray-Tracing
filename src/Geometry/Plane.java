package Geometry;

import Utility.MyColour;
import Utility.MyPoint3D;
import Utility.MyRay;
import Utility.Normal;

/**
 * Created by Nishanth on 22/06/2016.
 */
public class Plane extends GeometricObject {

	/**
	 * Plane is defined as a point with a normal
	 */
	MyPoint3D point3D;
	Normal normal;

	public Plane (MyPoint3D Point3D, Normal normal, MyColour colour) {
		this.point3D = new MyPoint3D(Point3D);
		this.normal = new Normal(normal);
		this.colour = new MyColour(colour);
	}

	@Override
	public double hit(MyRay ray) {
		double t = point3D.subtract(ray.origin).dot(normal) / ray.direction.dot(normal);

		if (t > 10E-9) {
			return t;
		} else {
			return 0.0;
		}
	}
}

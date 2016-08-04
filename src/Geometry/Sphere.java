package Geometry;

import Utility.MyColour;
import Utility.MyPoint3D;
import Utility.MyRay;

/**
 * Created by Nishanth on 22/06/2016.
 */
public class Sphere extends GeometricObject {

	public MyPoint3D centre;
	public double radius;

	public Sphere (MyPoint3D centre, double radius, MyColour colour) {
		this.centre = new MyPoint3D(centre);
		this.radius = radius;
		this.colour = new MyColour(colour);
	}

	@Override
	public double hit(MyRay ray) {
		double a = ray.direction.dot(ray.direction);
		double b = 2*ray.origin.subtract(centre).dot(ray.direction);
		double c = ray.origin.subtract(centre).dot(ray.origin.subtract(centre))-radius*radius;
		double discriminant = b*b - 4*a*c;

		if (discriminant < 0) {
			//No intersections
			return 0.0;
		} else {
			double t = (-b - Math.sqrt(discriminant))/(2*a);
			if (t > 10E-9) {
				//t is large enough
				return t;
			} else {
				//no intersection
				return 0.0;
			}
		}
	}
}

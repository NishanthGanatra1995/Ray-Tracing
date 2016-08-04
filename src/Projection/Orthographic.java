package Projection;

import Launcher.Driver;
import Utility.MyPoint2D;
import Utility.MyRay;

/**
 * Created by Nishanth on 22/06/2016.
 */
public class Orthographic extends Projection {

	@Override
	public MyRay createRay(MyPoint2D point2D) {
		MyRay ray = new MyRay();
		ray.origin.x = Driver.world.viewPlane.pixelSize * point2D.x;
		ray.origin.y = Driver.world.viewPlane.pixelSize * point2D.y;
		ray.origin.z = 100;

		ray.direction.x = 0.0;
		ray.direction.y = 0.0;
		ray.direction.z = -1.0;

		return ray;
	}
}

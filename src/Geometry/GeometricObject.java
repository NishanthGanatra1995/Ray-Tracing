package Geometry;

import Utility.MyColour;
import Utility.MyRay;

/**
 * Created by Nishanth on 22/06/2016.
 */
public abstract class GeometricObject {

	public MyColour colour;
	public abstract double hit (MyRay ray);

}

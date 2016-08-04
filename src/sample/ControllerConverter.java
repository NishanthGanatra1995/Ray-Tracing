package sample;

import Geometry.GeometricObject;
import Geometry.Plane;
import Geometry.Sphere;
import Utility.MyColour;
import Utility.MyPoint3D;
import Utility.Normal;

import java.util.ArrayList;

/**
 * Created by Nishanth on 24/06/2016.
 */
public class ControllerConverter {

	public ArrayList<GeometricObject> getObjectWorld (String selected) {

		ArrayList<GeometricObject> tempGeometricObjects = new ArrayList<>();

		switch (selected) {
			case "One Sphere": {
				tempGeometricObjects.add(new Sphere(new MyPoint3D(0.0, 0.0, 0.0), 50, new MyColour(1.0F, 0.0F, 0.0F)));
				break;
			}
			case "Two Spheres": {
				tempGeometricObjects.add(new Sphere(new MyPoint3D(0.0, 0.0, 0.0), 50, new MyColour(1.0F, 0.0F, 0.0F)));
				tempGeometricObjects.add(new Sphere(new MyPoint3D(-150.0, 0.0, 0.0), 50, new MyColour(0.0F, 1.0F, 0.0F)));
				break;
			}
			case "Three Spheres": {
				tempGeometricObjects.add(new Sphere(new MyPoint3D(0.0, 0.0, 0.0), 50, new MyColour(1.0F, 0.0F, 0.0F)));
				tempGeometricObjects.add(new Sphere(new MyPoint3D(-150.0, 0.0, 0.0), 50, new MyColour(0.0F, 1.0F, 0.0F)));
				tempGeometricObjects.add(new Sphere(new MyPoint3D(150.0, 0.0, 0.0), 50, new MyColour(0.0F, 0.0F, 1.0F)));
				break;
			}
			case "Three Spheres and Plane": {
				tempGeometricObjects.add(new Sphere(new MyPoint3D(0.0, 0.0, 0.0), 50, new MyColour(1.0F, 0.0F, 0.0F)));
				tempGeometricObjects.add(new Sphere(new MyPoint3D(-150.0, 0.0, 0.0), 50, new MyColour(0.0F, 1.0F, 0.0F)));
				tempGeometricObjects.add(new Sphere(new MyPoint3D(150.0, 0.0, 0.0), 50, new MyColour(0.0F, 0.0F, 1.0F)));
				tempGeometricObjects.add(new Plane(new MyPoint3D(0.0, 0.0, 0.0), new Normal(0.0, 1.0, 0.2), new MyColour(1.0F, 1.0F, 0.0F)));
				break;
			}
			default: {}
		}
		return tempGeometricObjects;
	}

}

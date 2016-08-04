package Scene;

import Geometry.GeometricObject;
import Utility.MyColour;

import java.util.ArrayList;

/**
 * Created by Nishanth on 22/06/2016.
 */
public class World {

	public ViewPlane viewPlane;
	public ArrayList<GeometricObject> objects;
	public MyColour background;

	public World(double pizeSize, int width, int height, ArrayList<GeometricObject> objects) {
		viewPlane = new ViewPlane(pizeSize, width, height);
		background = new MyColour(0.0F, 0.0F, 0.0F);
		this.objects = objects;
	}
}

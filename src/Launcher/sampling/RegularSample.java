package Launcher.sampling;

import Launcher.Driver;
import Utility.MyPoint2D;

/**
 * Created by Nishanth on 22/06/2016.
 */
public class RegularSample extends Sampler {

	public RegularSample (int samples) {
		this.samples = samples;
	}

	public MyPoint2D sample(int row, int col, int x, int y) {
		MyPoint2D point = new MyPoint2D();
		point.x = x - Driver.world.viewPlane.width/2+(col+0.5)/samples;
		point.y = y - Driver.world.viewPlane.height/2+(row+0.5)/samples;
		return point;
	}
}

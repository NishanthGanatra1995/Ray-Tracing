package Launcher.sampling;

import Utility.MyPoint2D;

/**
 * Created by Nishanth on 22/06/2016.
 */
public abstract class Sampler {

	public int samples;
	public abstract MyPoint2D sample (int row, int col, int x, int y);

}

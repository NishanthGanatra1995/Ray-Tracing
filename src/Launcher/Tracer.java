package Launcher;

import Utility.MyColour;
import Utility.MyPoint2D;
import Utility.MyRay;

/**
 * Created by Nishanth on 22/06/2016.
 */
public class Tracer implements Runnable {

	private int y;
	private int x;

	public void setXY (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void trace(int x, int y) {
		MyColour colour = new MyColour(0.0F, 0.0F, 0.0F);
		Boolean hit = false;
		for (int row = 0; row < Driver.sampler.samples; row++) {
			for (int col = 0; col < Driver.sampler.samples; col++) {
				MyPoint2D point2D = Driver.sampler.sample(row, col, x, y);
				MyRay ray = Driver.projection.createRay(point2D);

				double min = Double.MAX_VALUE;
				MyColour tempColour = Driver.world.background;

				for (int i = 0; i < Driver.world.objects.size(); i++) {
					double temp = Driver.world.objects.get(i).hit(ray);

					if (temp != 0.0 && temp < min) {
						min = temp;
						hit = true;
						tempColour = Driver.world.objects.get(i).colour;
					}
				}
				colour.add(tempColour);
			}
		}
		colour.divide(Driver.sampler.samples * Driver.sampler.samples);
		if (hit)
			Driver.image.buffer.setRGB(x, Driver.world.viewPlane.height-y-1, colour.toInteger());
		else
			Driver.image.buffer.setRGB(x, Driver.world.viewPlane.height-y-1, Driver.world.background.toInteger());

	}

	@Override
	public void run() {
		trace(x, y);
	}
}
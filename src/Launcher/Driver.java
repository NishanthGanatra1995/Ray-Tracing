package Launcher;

import Geometry.GeometricObject;
import Launcher.sampling.RegularSample;
import Launcher.sampling.Sampler;
import Projection.Orthographic;
import Projection.Projection;
import Scene.World;
import Utility.Image;
import javafx.scene.control.ProgressBar;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by Nishanth on 22/06/2016.
 */
public class Driver {

	public static World world;
	public static Image image;
	public static Tracer tracer;
	public static Sampler sampler;
	public static Projection projection;

	public Image writeToFile(ProgressBar progressBar, ArrayList<GeometricObject> objects) throws InterruptedException {
		world = new World(1.0, 1600, 900, objects);
		image = new Image("src/image.png");
		tracer = new Tracer();
		sampler = new RegularSample(8);
		projection = new Orthographic();

		long start = System.nanoTime();
		ExecutorService executorService = Executors.newFixedThreadPool(7);
		for (int x = 0; x < world.viewPlane.width; x++) {
			for (int y = 0; y < world.viewPlane.height; y++) {
				Tracer workClass = new Tracer();
				workClass.setXY(x, y);
				Thread thread = new Thread(workClass);
				executorService.execute(thread);
			}
			float value = (float)(x) / (float)(Driver.world.viewPlane.width);
			progressBar.setProgress(value);
		}

		executorService.shutdown();
		while (!executorService.isTerminated()) {
		}

		long end = System.nanoTime();

		image.write("PNG");

		System.out.println("Took "+(end - start)/1000000);

		return image;
	}


}

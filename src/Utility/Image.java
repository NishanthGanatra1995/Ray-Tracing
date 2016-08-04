package Utility;

import Launcher.Driver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nishanth on 22/06/2016.
 */
public class Image {

	public BufferedImage buffer;
	public File image;

	public Image (String fileName) {
		image = new File(fileName);
		buffer = new BufferedImage(Driver.world.viewPlane.width,
				Driver.world.viewPlane.height,
				BufferedImage.TYPE_INT_BGR
		);
	}

	public void write (String fileType) {
		try {
			ImageIO.write(buffer, fileType, image);
		} catch (IOException e) {
			System.out.println("Cannot write image");
			System.exit(1);
			e.printStackTrace();
		}
	}

}

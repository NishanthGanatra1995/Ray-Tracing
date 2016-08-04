package Utility;

/**
 * Created by Nishanth on 22/06/2016.
 */
public class MyRay {

	public MyPoint3D origin;
	public MyVector3D direction;

	public MyRay () {
		origin = new MyPoint3D();
		direction = new MyVector3D();
	}

	public MyRay (MyPoint3D origin, MyVector3D direction) {
		this.origin = new MyPoint3D(origin);
		this.direction = new MyVector3D(direction);
	}
}

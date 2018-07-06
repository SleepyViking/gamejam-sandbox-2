package net.sleepyviking.gjsb2.model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {

	private final static Vector2 VIEWPORT = new Vector2(10,10);
	private OrthographicCamera camera;

	public World(){

		this.camera = new OrthographicCamera();
	}

	public OrthographicCamera getCamera(){
		return camera;
	}

	public Vector2 getViewport(){
		return VIEWPORT;
	}


}

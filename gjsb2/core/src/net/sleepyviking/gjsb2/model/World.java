package net.sleepyviking.gjsb2.model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {

	private Vector2 viewPort;
	private OrthographicCamera camera;

	public World(){

	}

	public OrthographicCamera getCamera(){
		return camera;
	}

	public Vector2 getViewport(){
		return viewPort;
	}


}

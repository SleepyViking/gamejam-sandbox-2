package net.sleepyviking.gjsb2.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import net.sleepyviking.gjsb2.model.map.Map;

public class World {

	private final static Vector2 VIEWPORT = new Vector2(20, 12);
	private PerspectiveCamera camera;
	

	public Map map;
	public Array<Entity> entities = new Array<Entity>();
	public Array<Mob> mobs = new Array<Mob>();
	private Player player;

	public World(){
		this.camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	public PerspectiveCamera getCamera(){
		return camera;
	}

	public Vector2 getViewport(){
		return VIEWPORT;
	}

	public void setPlayer(Player player){
		this.player = player;
	}

	public Player getPlayer(){
		return player;
	}


}

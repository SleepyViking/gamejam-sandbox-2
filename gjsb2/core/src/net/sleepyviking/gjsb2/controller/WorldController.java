package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import net.sleepyviking.gjsb2.model.Entity;
import net.sleepyviking.gjsb2.model.Player;
import net.sleepyviking.gjsb2.model.World;
import net.sleepyviking.gjsb2.model.map.Map;


//Class that sorts out and tells everything to update
public class WorldController extends Controller{

	private World world;

	private PlayerController playerController;
	private EntityController entityController;
	private CameraController cameraController;

	public WorldController(World world){
		this.world = world;
		this.world.map = new Map(new FileHandle("world1.json"));

		Player player = new Player(new Vector2(64,64));

		setPlayerController(new PlayerController(player));
		setEntityController(new EntityController());

		world.setPlayer(player);
		addEntity(player);

		cameraController = new CameraController(world);
	}

	@Override
	public void update(float dt) {
		playerController.update(dt);
		entityController.update(dt);
		cameraController.update();
	}

	public PlayerController getPlayerController() {
		return playerController;
	}

	public void setPlayerController(PlayerController playerController) {
		this.playerController = playerController;
	}

	public EntityController getEntityController() {
		return entityController;
	}

	public void setEntityController(EntityController entityController) {
		this.entityController = entityController;
	}

	 public void addEntity(Entity e){
		entityController.addEntity(e);
		world.addEntity(e);
	 }

}

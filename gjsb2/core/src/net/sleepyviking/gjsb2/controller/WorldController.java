package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import net.sleepyviking.gjsb2.model.Entity;
import net.sleepyviking.gjsb2.model.Player;
import net.sleepyviking.gjsb2.model.World;
import net.sleepyviking.gjsb2.model.map.Map;

public class WorldController extends Controller{

	World world;

	PlayerController playerController;
	EntityController entityController;

	public WorldController(World world){
		this.world = world;
		this.world.map = new Map(
						new Texture("tilesheet.png"),
						64, //width in tiles
						64, //height in tiles
						16, //width of tiles in pixels
						16	//height of tiles in pixels
		);

		Player player = new Player(new Vector2(64,64));

		setPlayerController(new PlayerController(player));
		setEntityController(new EntityController());

		this.addEntity(player);
	}

	@Override
	public void update(float dt) {
		playerController.update(dt);
		entityController.update(dt);
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

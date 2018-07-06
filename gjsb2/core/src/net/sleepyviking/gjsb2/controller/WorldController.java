package net.sleepyviking.gjsb2.controller;

import net.sleepyviking.gjsb2.model.World;

public class WorldController extends Controller{

	World world;

	PlayerController playerController;
	EntityController entityController;

	public WorldController(World world){
		this.world = world;

		setPlayerController(new PlayerController());
		setEntityController(new EntityController());

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

}

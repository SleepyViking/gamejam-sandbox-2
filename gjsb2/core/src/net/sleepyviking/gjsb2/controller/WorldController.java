package net.sleepyviking.gjsb2.controller;

import net.sleepyviking.gjsb2.model.World;

public class WorldController extends Controller{

	World world;

<<<<<<< HEAD

	PlayerController playerController;
	EntityController entityController;



=======
>>>>>>> 67609f1b582f4e7e7c0cf5fee53f8fd30b299187
	public WorldController(World world){
		this.world = world;

		setPlayerController(new PlayerController());
		setEntityController(new EntityController());

	}

	@Override
	public void update(float dt) {

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

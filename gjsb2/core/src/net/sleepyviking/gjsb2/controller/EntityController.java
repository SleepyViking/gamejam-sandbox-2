package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.utils.Array;
import net.sleepyviking.gjsb2.model.Entity;

public class EntityController extends Controller {

	protected Array<Entity> entities;

	public EntityController(){
		entities = new Array<Entity>();
	}

	@Override
	public void update(float dt) {
		Entity e;
		for (int i = 0; i < entities.size; i++) {
			e = entities.get(i);
			e.getPos().add(e.getVel().scl(dt));
		}
	}

	public void addEntity(Entity e){
		entities.add(e);
	}

}

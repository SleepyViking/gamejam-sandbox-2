package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.utils.Array;
import net.sleepyviking.gjsb2.model.Entity;

public class EntityController extends Controller {

	public Array<Entity> entities;

	@Override
	public void update(float dt) {
		Entity e;
		for (int i = 0; i < entities.size; i++) {
			e = entities.get(i);
			e.getPos().add(e.getVel().scl(dt));
		}
	}

}

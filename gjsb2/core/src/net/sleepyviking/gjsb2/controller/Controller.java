package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.utils.Array;
import net.sleepyviking.gjsb2.model.Model;

public abstract class Controller {
	private Array<Model> models;
	public abstract void update(float dt);


}

package net.sleepyviking.gjsb2.model;

import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import net.sleepyviking.gjsb2.controller.Controller;

public class Entity extends Model{
	Vector2 pos;
	Vector2 vel;

	public Entity(){
		//pos = new Vector2(0, 0);
	}

	public Entity(Vector2 pos, Controller controller){
		this.pos = pos;
		this.controller = controller;
	}

	public Entity(Vector2 pos){
		setPos(pos);
	}

	public void setController(Controller c){
		this.controller = c;
	}

	public Vector2 getPos(){
		return pos;
	}

	public Vector2 getVel() {
		return vel;
	}

	public void setVel(Vector2 vel) {
		this.vel = vel;
	}

	public void setPos(Vector2 pos){
		this.pos.set(pos);
	}
	//One day, I'll be moving around the game world
}

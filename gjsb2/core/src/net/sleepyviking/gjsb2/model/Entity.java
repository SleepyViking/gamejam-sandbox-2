package net.sleepyviking.gjsb2.model;

import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import net.sleepyviking.gjsb2.controller.Controller;

public class Entity extends Model{
	Vector2 pos;
	Vector2 vel;

	public Entity(){
		this.pos = new Vector2();
		this.vel = new Vector2();
	}

	public Entity(Vector2 pos){
		this.pos = new Vector2();
		this.vel = new Vector2();
		setPos(pos);
	}

	public Entity(Vector2 pos, Vector2 vel){
		this.pos = new Vector2();
		this.vel = new Vector2();
		setPos(pos);
		setVel(pos);
	}

	public Vector2 getPos(){
		return pos;
	}

	public Vector2 getVel() {
		return vel;
	}

	public void setVel(Vector2 vel) {
		this.vel.set(vel);
	}

	public void setPos(Vector2 pos){
		this.pos.set(pos);
	}
	//One day, I'll be moving around the game world
}

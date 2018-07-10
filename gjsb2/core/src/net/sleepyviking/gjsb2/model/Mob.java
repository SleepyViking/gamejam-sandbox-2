package net.sleepyviking.gjsb2.model;

import com.badlogic.gdx.math.Vector2;

public class Mob{

	Entity entity;

	Vector2 moveDir;
	float moveSpeed;

	int health;
	int level;

	int STR;
	int CON;
	int DEX;
	int WIS;
	int INT;
	int CHA;

	public Mob(){
	}

	public Mob(Entity entity, float moveSpeed){
		this.entity = entity;
		this.moveSpeed = moveSpeed;
	}

	public float getMoveSpeed(){
		return moveSpeed;
	}

}

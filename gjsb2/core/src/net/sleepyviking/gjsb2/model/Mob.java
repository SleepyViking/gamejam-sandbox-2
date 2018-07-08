package net.sleepyviking.gjsb2.model;

import com.badlogic.gdx.math.Vector2;

public class Mob extends Entity{

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

	public Mob(Vector2 pos){
		super(pos);
	}

	public float getMoveSpeed(){
		return moveSpeed;
	}

}

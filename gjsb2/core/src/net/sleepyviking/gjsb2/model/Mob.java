package net.sleepyviking.gjsb2.model;

import com.badlogic.gdx.math.Vector2;

public class Mob{

	Entity entity;

	Vector2 moveDir;
	float moveSpeed;
	float sprintMultiplier;
	float jumpHeight;

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

	public Mob(Entity entity,
			   float moveSpeed,
			   float sprintMultiplier,
			   float jumpHeight,
			   int health,
			   int level,
			   int STR,
			   int CON,
			   int DEX,
			   int WIS,
			   int INT,
			   int CHA
	){
		this.entity = entity;
		this.moveSpeed = moveSpeed;
		this.sprintMultiplier = sprintMultiplier;
		this.jumpHeight = jumpHeight;
		
		this.health = health;
		this.level = level;
		this.STR = STR;
		this.CON = CON;
		this.DEX = DEX;
		this.WIS = WIS;
		this.INT = INT;
		this.CHA = CHA;
		
	}

	public float getMoveSpeed(){
		return moveSpeed;
	}
	
	public float getSprintMultiplier(){
		return sprintMultiplier;
	}
	
	public void setMoveDir(float x, float y) {
		this.moveDir.set(x, y).nor();
	}
	
	public void setMoveY(float y) {
		this.moveDir.y = y;
		this.moveDir.nor();
	}
	
	public void setMoveX(float x) {
		this.moveDir.x = x;
		this.moveDir.nor();
	}
	
	public Vector2 getMoveDir() {
		return moveDir;
	}
	
	public Vector2 getVel(){return entity.vel;}
	public Vector2 getPos(){return entity.pos;}
	
	
}

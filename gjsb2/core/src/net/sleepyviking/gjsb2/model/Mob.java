package net.sleepyviking.gjsb2.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import net.sleepyviking.gjsb2.model.physical.Constants;

public class Mob{
	
	public float drawStrengthMax;	//Max
	public float jumpStrengthMax;	//
	public float drawStrength = 0;		//Instantaneous
	public float jumpStrength = 0;		//
	public boolean drawing = false,	//With weapon - preparing to fire, throw, etc.
			chargingJump = false,	//Preparing to jump, similar to drawing.
			crouching = false,
			sprinting = false,
			jumping = false,
			attacking = false;
	
	Entity entity;

	Vector2 moveDir;
	float moveSpeed;
	float sprintMultiplier;

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
		this.health = health;
		this.level = level;
		this.STR = STR;
		this.CON = CON;
		this.DEX = DEX;
		this.WIS = WIS;
		this.INT = INT;
		this.CHA = CHA;
		
		moveDir = new Vector2(0, 0);
		
		drawStrengthMax = STR*Constants.drawCoefficient;
		jumpStrengthMax = STR*Constants.jumpCoefficient;
		
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
	
	public Vector3 getVel(){return entity.vel;}
	public Vector3 getPos(){return entity.pos;}
	
	
	public Entity getEntity(){
		return entity;
	}
	public void setEntity(Entity entity){
		this.entity = entity;
	}
	public void setMoveDir(Vector2 moveDir){
		this.moveDir = moveDir;
	}
	public void setMoveSpeed(float moveSpeed){
		this.moveSpeed = moveSpeed;
	}
	public void setSprintMultiplier(float sprintMultiplier){
		this.sprintMultiplier = sprintMultiplier;
	}
	public int getHealth(){
		return health;
	}
	public void setHealth(int health){
		this.health = health;
	}
	public int getLevel(){
		return level;
	}
	public void setLevel(int level){
		this.level = level;
	}
	public int getSTR(){
		return STR;
	}
	public void setSTR(int STR){
		this.STR = STR;
	}
	public int getCON(){
		return CON;
	}
	public void setCON(int CON){
		this.CON = CON;
	}
	public int getDEX(){
		return DEX;
	}
	public void setDEX(int DEX){
		this.DEX = DEX;
	}
	public int getWIS(){
		return WIS;
	}
	public void setWIS(int WIS){
		this.WIS = WIS;
	}
	public int getINT(){
		return INT;
	}
	public void setINT(int INT){
		this.INT = INT;
	}
	public int getCHA(){
		return CHA;
	}
	public void setCHA(int CHA){
		this.CHA = CHA;
	}
	
	public float getWeight(){
		return entity.weight;
	}
	
	
}

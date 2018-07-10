package net.sleepyviking.gjsb2.model;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import net.sleepyviking.gjsb2.controller.PlayerController;

public class Player extends Mob{


	public Player(Entity entity, float moveSpeed, String name){
		this.entity = entity;
		this.entity.name = name;
		this.moveSpeed = moveSpeed;
		moveDir = new Vector2(0,0);

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

package net.sleepyviking.gjsb2.model;

import com.badlogic.gdx.math.Vector2;
import net.sleepyviking.gjsb2.controller.PlayerController;

public class Player extends Mob{

	public Player(Vector2 pos){
		super(pos);
		this.moveSpeed = 25.0f;
		this.moveDir = new Vector2(0, 0);
		this.size = new Vector2(1, 1);
		this.name = "Player";
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

}

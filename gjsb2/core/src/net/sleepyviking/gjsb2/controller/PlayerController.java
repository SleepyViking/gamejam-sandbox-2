package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import net.sleepyviking.gjsb2.model.Mob;
import net.sleepyviking.gjsb2.model.Player;

public class PlayerController implements InputProcessor {

	private CameraController cameraController;
	private EntityController entityController;
	private Player player;
	private Ray ray = new Ray();

	boolean wdown = false,
			adown = false,
			sdown = false,
			ddown = false;
	
	
	Vector3 mouse;
	
	float moveSpeed;
	float sprintMultiplier;
	
	public Vector3 getMouseOnPlane(int screenx, int screeny){
		return mouse;
	}
	
	
	PlayerController(Player player){
		this.setPlayer(player);
		this.moveSpeed = player.getMoveSpeed();
		this.sprintMultiplier = player.getSprintMultiplier();
		
		Gdx.input.setInputProcessor(this);
	}
	
	public void update(float dt) {
		
	}

	@Override
	public boolean keyDown(int keycode) {
		
		if(player == null) return false;
		else{
			if		(keycode == Input.Keys.W) {player.setMoveY( 1f ); wdown = true;}
			else if	(keycode == Input.Keys.S) {player.setMoveY(-1f ); sdown = true;}
			else if	(keycode == Input.Keys.A) {player.setMoveX(-1f ); adown = true;}
			else if	(keycode == Input.Keys.D) {player.setMoveX( 1f ); ddown = true;}
			else if (keycode == Input.Keys.SPACE){
				player.chargingJump = true;
			}
			else if(keycode == Input.Keys.SHIFT_LEFT){
				player.sprinting = true;
			}
			
			return true;
		}
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(player == null) return false;

		else{
			
			if(keycode == Input.Keys.W){
				if (sdown){player.setMoveY( -1f );}
				else {player.setMoveY( 0f ); }
				wdown = false;
			}
			else if	(keycode == Input.Keys.S) {
				if (wdown){player.setMoveY( 1f );}
				else {player.setMoveY( 0f ); }
				sdown = false;
			}
			else if	(keycode == Input.Keys.A) {
				if (ddown){player.setMoveX( 1f );}
				else {player.setMoveX( 0f ); }
				adown = false;
			}
			else if	(keycode == Input.Keys.D) {
				if (adown){player.setMoveX( -1f );}
				else {player.setMoveX( 0f );}
					ddown = false;
			}
			else if(keycode == Input.Keys.SHIFT_LEFT){
				player.sprinting = false;
			}
			else if(keycode == Input.Keys.SPACE){
				player.jumping = true;
				player.chargingJump = false;
			}
			return true;
		}
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(player == null) return false;
		
		if(button == Input.Buttons.LEFT){
			player.drawing = true;
		}
		
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if(player == null) return false;
		
		if(button == Input.Buttons.LEFT){
			player.attacking = true;
			player.drawing = false;
		}
		
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
		
		
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
	
	public void setCameraController(CameraController cameraController){
		this.cameraController = cameraController;
	}
	public void setEntityController(EntityController entityController){
		this.entityController = entityController;
	}
	
	
	


}

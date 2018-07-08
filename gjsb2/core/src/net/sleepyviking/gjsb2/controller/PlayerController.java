package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import net.sleepyviking.gjsb2.model.Entity;
import net.sleepyviking.gjsb2.model.Player;

public class PlayerController extends EntityController implements InputProcessor {

	Player player;


	PlayerController(Player player){
		this.setPlayer(player);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void update(float dt) {
		player.getVel().set(player.getMoveDir().x*player.getMoveSpeed(), player.getMoveDir().y*player.getMoveSpeed());
		//System.out.println(player.getMoveDir() +"     "+ player.getPos());
	}

	@Override
	public boolean keyDown(int keycode) {
		if(player == null) return false;

		else{
			if			(keycode == Input.Keys.W) player.setMoveY( 1f );
			else if	(keycode == Input.Keys.S) player.setMoveY(-1f );
			else if	(keycode == Input.Keys.A) player.setMoveX(-1f );
			else if	(keycode == Input.Keys.D) player.setMoveX( 1f );
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
			if			(keycode == Input.Keys.W) player.setMoveY( 0f );
			else if	(keycode == Input.Keys.S) player.setMoveY( 0f );
			else if	(keycode == Input.Keys.A) player.setMoveX( 0f );
			else if	(keycode == Input.Keys.D) player.setMoveX( 0f );
			return true;
		}
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
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



}

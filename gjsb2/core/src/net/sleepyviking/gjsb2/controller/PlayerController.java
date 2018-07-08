package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import net.sleepyviking.gjsb2.model.Entity;
import net.sleepyviking.gjsb2.model.Player;

public class PlayerController extends EntityController implements InputProcessor {

	PlayerController(Player player){
		this.addEntity(player);
	}

	PlayerController(){
		entities = new Array<Entity>();
		Gdx.input.setInputProcessor(this);

	}

	@Override
	public void update(float dt) {

	}

	@Override
	public boolean keyDown(int keycode) {
		switch(keycode){
			case Input.Keys.W:
				System.out.print("W");
				break;
			case Input.Keys.S:
				System.out.print("S");
				break;
			case Input.Keys.D:
				System.out.print("D");
				break;
			case Input.Keys.A:
				System.out.print("A");
				break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
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

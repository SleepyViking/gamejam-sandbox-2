package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import net.sleepyviking.gjsb2.model.Player;

public class PlayerController extends EntityController{

	Player player;

	PlayerController(Player player){
		this.player = player;
	}

	@Override
	public void update(float dt) {
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			System.out.println("LEFT");
		}
	}
}

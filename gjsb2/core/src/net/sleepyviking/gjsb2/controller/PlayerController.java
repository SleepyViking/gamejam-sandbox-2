package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import net.sleepyviking.gjsb2.model.Player;

public class PlayerController extends EntityController{

	PlayerController(Player player){
		this.addEntity(player);
	}

	PlayerController(){
		this.addEntity(new Player(new Vector2(0,0)));
	}

	@Override
	public void update(float dt) {
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			System.out.println("LEFT");
		}
	}
}

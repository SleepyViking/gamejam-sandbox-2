package net.sleepyviking.gjsb2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.sleepyviking.gjsb2.controller.EntityController;
import net.sleepyviking.gjsb2.controller.WorldController;
import net.sleepyviking.gjsb2.model.World;

public class Game extends ApplicationAdapter {

	WorldController worldController;


	@Override
	public void create () {
		this.worldController = new WorldController(new World());


	}

	@Override
	public void render () {

	}
	
	@Override
	public void dispose () {

	}
}

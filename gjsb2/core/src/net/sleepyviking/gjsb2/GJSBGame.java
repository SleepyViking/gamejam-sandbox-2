package net.sleepyviking.gjsb2;

import com.badlogic.gdx.Game;

import net.sleepyviking.gjsb2.screen.ScreenGame;

public class GJSBGame extends Game {

	@Override
	public void create () {

		setScreen(new ScreenGame(this));

	}
}

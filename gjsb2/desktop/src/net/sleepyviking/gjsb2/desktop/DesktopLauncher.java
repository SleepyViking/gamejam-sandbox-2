package net.sleepyviking.gjsb2.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.sleepyviking.gjsb2.GJSBGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "GJSB";
		config.width = 1280;
		config.height = 768;

		new LwjglApplication(new GJSBGame(), config);
	}
}

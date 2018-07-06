package net.sleepyviking.gjsb2.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import net.sleepyviking.gjsb2.Game;
import net.sleepyviking.gjsb2.controller.WorldController;
import net.sleepyviking.gjsb2.model.World;
import net.sleepyviking.gjsb2.view.WorldRenderer;


public class ScreenGame extends ScreenBase implements InputProcessor {

    //world variables
    private World world;
    private WorldController worldController;
    private WorldRenderer worldRenderer;

    //initializing world variables
    public ScreenGame(Game game){

        world = new World();
        worldController = new WorldController(world);
        worldRenderer = new WorldRenderer(world);

        Gdx.input.setInputProcessor(this);

    }

    //rendering world variables
    @Override
    public void render(float delta){

        if(delta < 0.05f){
            worldController.update(delta);
            worldRenderer.render();
        }
    }

/*
* Class that renders game-world variables
*/

    @Override
    public boolean keyDown(int keycode) {
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

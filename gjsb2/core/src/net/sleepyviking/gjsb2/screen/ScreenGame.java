package net.sleepyviking.gjsb2.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import net.sleepyviking.gjsb2.controller.WorldController;
import net.sleepyviking.gjsb2.model.World;
import net.sleepyviking.gjsb2.view.WorldRenderer;


public class ScreenGame extends ScreenBase{

    //world variables
    private World world;
    private WorldController worldController;
    private WorldRenderer worldRenderer;

    //initializing world variables
    public ScreenGame(Game game){

        world = new World();
        worldController = new WorldController(world);
        worldRenderer = new WorldRenderer(world);
    }

    //rendering world variables
    @Override
    public void render(float delta){

        if(delta < 0.05f){
            worldController.update(delta);
            worldRenderer.render();
        }
    }
    
    @Override
    public void resize(int width, int height) {
        worldRenderer.resize(width, height);
    }
    
    @Override
    public void dispose() {
        worldRenderer.dispose();
    }
}

package net.sleepyviking.gjsb2.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import net.sleepyviking.gjsb2.model.World;

public class WorldRenderer {

    private SpriteBatch spriteBatch;
    private OrthographicCamera camera;
    private Vector2 viewPort;

    private World world;

    //initializes the objects needed
    public WorldRenderer(World world){
        spriteBatch = new SpriteBatch();

        camera = world.getCamera();
        viewPort = new Vector2(world.getViewport());
        camera.setToOrtho(false, viewPort.x,viewPort.y);


        this.world = world;
    }


    //does the rendering
    public void render(){

        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();

        /*renderWhomever functions called here*/

        spriteBatch.end();

    }

}

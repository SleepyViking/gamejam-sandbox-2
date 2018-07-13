package net.sleepyviking.gjsb2.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import net.sleepyviking.gjsb2.model.Entity;
import net.sleepyviking.gjsb2.model.Player;
import net.sleepyviking.gjsb2.model.World;
import net.sleepyviking.gjsb2.model.map.Tile;

public class WorldRenderer {

    private SpriteBatch spriteBatch;
    private PerspectiveCamera camera;
    private Vector2 viewPort;
    private World world;
    
    //initializes the objects needed
    public WorldRenderer(World world){
        this.world = world;
        create();
    }
    
    public void create(){
        spriteBatch = new SpriteBatch();
        camera = world.getCamera();
        viewPort = new Vector2(world.getViewport());
        //camera.setToOrtho(false, viewPort.x, viewPort.y);
        camera.position.set(10f, 10f, 3f);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();
    }

    //does the rendering
    public void render(){
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        
        spriteBatch.setProjectionMatrix(camera.combined);
        
        {spriteBatch.begin();
        
            /*renderWhomever functions called here*/
            renderWorld();
            renderEntities();
            
        spriteBatch.end();}

    }

    public void renderWorld(){

        spriteBatch.setColor(0.8f,0.7f,0.9f,1);

        for (int y = 0; y < world.map.getDimy(); y++) {
            for (int x = 0; x < world.map.getDimx(); x++) {
                for (int z = 0; z < world.map.getNumLayers(); z++) {
                spriteBatch.draw(
                        world.map.getTileAt(x, y, z).getTextureRegion(),
                        x,
                        world.map.getDimy()-y, 1 , 1);
                
                    /*
                     *  TODO: revert when we get map editing working;
                     *  as it is, (x, y, 1, 1) renders the map in the json file upside-down.
                     *  (x, dimy-y, 1, 1) gives a right-side up map and positive values, but
                     *  this is unnecessary if we make a tool that writes the lines of the json in reverse order.
                     */
                
                }
            }
        }
    }
    public void renderEntities(){

        spriteBatch.setColor(1f,1f,1f,1);

        for (Entity e: world.entities) {
            spriteBatch.draw(e.textureRegion,
                    e.getPos().x-e.getSize().x/2f,
                    e.getPos().y-e.getSize().y/2f,
                    e.getSize().x,
                    e.getSize().y);
        }
    }
    
    public void resize(int width, int height){

        //viewPort.set(width/3f, height/3f);
        //camera.setToOrtho(false, viewPort.x, viewPort.y);

    }
    
    public void dispose(){
        spriteBatch.dispose();
    }

}

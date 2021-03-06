package net.sleepyviking.gjsb2.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.decals.CameraGroupStrategy;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.utils.Array;
import net.sleepyviking.gjsb2.model.Entity;
import net.sleepyviking.gjsb2.model.Mob;
import net.sleepyviking.gjsb2.model.Player;
import net.sleepyviking.gjsb2.model.World;
import net.sleepyviking.gjsb2.model.map.Tile;

public class WorldRenderer {

    private SpriteBatch spriteBatch;
    private DecalBatch decalBatch;
    private ShapeRenderer shapeRenderer;
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
        shapeRenderer = new ShapeRenderer();
        camera = world.getCamera();
        viewPort = new Vector2(world.getViewport());
        //camera.setToOrtho(false, viewPort.x, viewPort.y);
        camera.position.set(10f, 10f, 3f);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();
    
        decalBatch = new DecalBatch(new CameraGroupStrategy(camera));
        
    }

    //does the rendering
    public void render(){
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glEnable(GL20.GL_DEPTH_TEST);
        
        
        spriteBatch.setProjectionMatrix(camera.combined);
        shapeRenderer.setProjectionMatrix(camera.combined);
        
            /*renderWhomever functions called here*/
        renderWorld();
        renderEntities();
        renderDebug();

    }
    
    private void renderDebug(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Point);
        shapeRenderer.setColor(Color.WHITE);
        for (Entity e : world.entities){
            shapeRenderer.point(e.getPos().x, e.getPos().y, e.getPos().z);
        }
        
        shapeRenderer.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        
            for(Mob m : world.mobs){
                
                if (m.drawing){
                shapeRenderer.setColor(Color.GREEN);
                shapeRenderer.line(m.getPos().x,
                                   m.getPos().y,
                                   m.getPos().z+1.0f,
                                   m.getPos().x + m.getVel().x*1.0f,
                                   m.getPos().y + m.getVel().y*1.0f,
                                   m.getPos().z+1.0f + m.getVel().z*1.0f
                                   );
                }
    
                shapeRenderer.setColor(Color.RED);
                shapeRenderer.line(m.getPos().x,
                                   m.getPos().y,
                                   m.getPos().z+0.1f,
                                   m.getPos().x + m.getVel().x*1.0f,
                                   m.getPos().y + m.getVel().y*1.0f,
                                   m.getPos().z+0.1f + m.getVel().z*1.0f
                );
                
            }
    
        for (float y = 0; y < world.map.getDimy(); y += 1.0f){
            for (float x = 0; x < world.map.getDimx(); x += 1.0f){
                shapeRenderer.setColor(Color.YELLOW);
                shapeRenderer.line(
                        x, y, 0f,
                        x, y, world.map.getHighestTile(x, y).getHeight()
                );
            }
        }
            
        shapeRenderer.end();
    }
    
    public void renderWorld(){
        spriteBatch.begin();
        spriteBatch.setColor(0.8f,0.7f,0.9f,1);

        for (int y = 0; y < world.map.getDimy(); y++) {
            for (int x = 0; x < world.map.getDimx(); x++) {
                for (int z = 0; z < world.map.getNumLayers(); z++) {
                spriteBatch.draw(
                        world.map.getTileAt(x, y, z).getTextureRegion(),
                        x-0.5f,
                        world.map.getDimy()-(y+1.5f), 1 , 1);
                    //offset by0.5 so that center of tile 0,0 is at origin.
                    
                    /*
                     *  TODO: AAA revert when we get map editing working;
                     *  as it is, (x, y, 1, 1) renders the map in the json file upside-down.
                     *  (x, dimy-y, 1, 1) gives a right-side up map and positive values, but
                     *  this is unnecessary if we make a tool that writes the lines of the json in reverse order.
                     */
                
                }
            }
        }
        spriteBatch.end();
    }
    public void renderEntities(){
        spriteBatch.begin();
        spriteBatch.setColor(1f,1f,1f,1);

        /*for (Entity e: world.entities) {
            spriteBatch.draw(e.textureRegion,
                    e.getPos().x-e.getSize().x/2f,
                    e.getPos().y,
                    e.getSize().x,
                    e.getSize().y);
        }*/
        
        spriteBatch.end();
        
        for (Entity e: world.entities) {
            decalBatch.add(e.getDecal());
        }
        decalBatch.flush();
        
    }
    
    public void resize(int width, int height){

        //viewPort.set(width/3f, height/3f);
        //camera.setToOrtho(false, viewPort.x, viewPort.y);

    }
    
    public void dispose(){
        spriteBatch.dispose();
        decalBatch.dispose();
        shapeRenderer.dispose();
    }

}

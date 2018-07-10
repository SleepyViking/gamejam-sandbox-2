package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import net.sleepyviking.gjsb2.model.Player;
import net.sleepyviking.gjsb2.model.World;


//Class that handles how the camera tracks the player
public class CameraController {

    private OrthographicCamera camera;
    private World world;
    private Player player;

    private float followx = 0f, followy = 0f;
    
    public CameraController(World world){
        camera = world.getCamera();
        this.world = world;
        player = world.getPlayer();
    }

    //Currently only follows player
    public void update(){
        
        
        
        if(player.getPos().x > camera.position.x + followx){
            camera.position.x = player.getPos().x - followx;
        }
        else if(player.getPos().x < camera.position.x - followx){
            camera.position.x = player.getPos().x + followx;
        }
        if(player.getPos().y > camera.position.y + followy){
            camera.position.y = player.getPos().y - followy;
        }
        else if(player.getPos().y < camera.position.y - followy){
            camera.position.y = player.getPos().y + followy;
        }
        
        
        camera.update();
    }


}

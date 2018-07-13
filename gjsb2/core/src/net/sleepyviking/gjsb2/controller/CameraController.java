package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import net.sleepyviking.gjsb2.model.Player;
import net.sleepyviking.gjsb2.model.World;


//Class that handles how the camera tracks the player
public class CameraController {

    private PerspectiveCamera camera;
    private World world;
    private Player player;
    
    private Vector3 offset = new Vector3(0f, -2f, 11f);

    private float followx = 0.2f, followy = 0.2f;
    
    public CameraController(World world){
        camera = world.getCamera();
        this.world = world;
        player = world.getPlayer();
    }

    //Currently only follows player
    public void update(){
        camera.position.z = offset.z;
        
        if(player.getPos().x > camera.position.x + followx - offset.x){
            camera.position.x = player.getPos().x - followx + offset.x;
        }
        else if(player.getPos().x < camera.position.x - followx - offset.x){
            camera.position.x = player.getPos().x + followx + offset.x;
        }
        if(player.getPos().y > camera.position.y + followy - offset.y){
            camera.position.y = player.getPos().y - followy + offset.y;
        }
        else if(player.getPos().y < camera.position.y - followy - offset.y){
            camera.position.y = player.getPos().y + followy + offset.y;
        }
        
        camera.lookAt(player.getPos().x ,player.getPos().y, 0);
        camera.update();
    }


}

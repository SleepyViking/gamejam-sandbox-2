package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.graphics.OrthographicCamera;
import net.sleepyviking.gjsb2.model.Player;
import net.sleepyviking.gjsb2.model.World;


//Class that handles how the camera tracks the player
public class CameraController {

    private OrthographicCamera camera;
    private World world;
    private Player player;

    public CameraController(World world){
        camera = world.getCamera();
        this.world = world;
        player = world.getPlayer();
    }

    //Currently only follows player
    public void update(){
        camera.position.set(player.getPos().x, player.getPos().y,0);
        camera.update();
    }


}

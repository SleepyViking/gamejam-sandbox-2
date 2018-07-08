package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import net.sleepyviking.gjsb2.model.Entity;
import net.sleepyviking.gjsb2.model.Mob;

public class MobController extends EntityController{

    Array<Mob> mobs;
    Mob temp;
    
    public MobController(){
    
    }
    
    @Override
    public void update(float dt) {
    
    
    
    }
    
    public void addMob(Mob m){
        mobs.add(m);
    }
    
    
    
}

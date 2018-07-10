package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import net.sleepyviking.gjsb2.model.Entity;
import net.sleepyviking.gjsb2.model.Mob;

public class MobController{

    Array<Mob> mobs;
    Mob temp;

    public MobController(){
        mobs = new Array<Mob>();
    }


    public void update(float dt) {

    }

    public void addMob(Mob m){
        mobs.add(m);
    }


    
}

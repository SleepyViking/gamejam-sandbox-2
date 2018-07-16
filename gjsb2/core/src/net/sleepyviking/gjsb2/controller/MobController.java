package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import net.sleepyviking.gjsb2.model.Mob;

public class MobController{
    
    
    private float sumdtDraw;
    private float sumdtJump;
    private float sumdtSprint;
    
    Array<Mob> mobs;
    Vector3 aimDir;

    public MobController(){
        mobs = new Array<Mob>();
    }


    public void update(float dt) {
        for (Mob m: mobs){
            if(!m.getEntity().isAirborne()){
                if (m.sprinting) {
                    sumdtSprint += dt;
                    m.getVel().set(
                            m.getMoveDir().x*m.getMoveSpeed()*m.getSprintMultiplier(),
                            m.getMoveDir().y*m.getMoveSpeed()*m.getSprintMultiplier(),
                            m.getVel().z); }
                else{ m.getVel().set(
                        m.getMoveDir().x*m.getMoveSpeed(),
                        m.getMoveDir().y*m.getMoveSpeed(),
                        m.getVel().z);}
            } else {
                m.getVel().x += m.getMoveDir().x*m.getMoveSpeed();
                m.getVel().y += m.getMoveDir().y*m.getMoveSpeed();
            }
            
            if(m.drawing){
                sumdtDraw += dt;
                m.drawStrength = m.drawStrengthMax - 1f/(sumdtDraw);
                if(m.drawStrength < 0) m.drawStrength = 0f;
                System.out.println(m.drawStrength + " / " + m.drawStrengthMax);
            }
    
            if(m.chargingJump){
                sumdtJump += dt;
                m.jumpStrength = m.jumpStrengthMax - 1f/(sumdtJump);
                if(m.jumpStrength < 0) m.jumpStrength = 0f;
                System.out.println(m.jumpStrength + " / " + m.jumpStrengthMax);
            }
            if(m.jumping){
                Vector2 jumpdir = m.getMoveDir().cpy().scl(m.jumpStrength);
    
                m.getVel().add(jumpdir.x, jumpdir.y, m.jumpStrength/m.getWeight());
                this.sumdtJump = 0;
                m.jumpStrength = 0;
                m.jumping = false;
            }
        
            
            
            if(m.attacking){
                int dmg = (int)(m.drawStrength * 2f);
                this.sumdtDraw 		= 0;
                m.drawStrength 	= 0;
                m.attacking = false;
            } else {
            
            }
        }
        
    }

    public void addMob(Mob m){
        mobs.add(m);
    }
    
    
    
    
}

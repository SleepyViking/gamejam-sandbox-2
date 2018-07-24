package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import net.sleepyviking.gjsb2.model.Mob;

public class MobController{
    
    

    
    Array<Mob> mobs;

    public MobController(){
        mobs = new Array<Mob>();
    }


    public void update(float dt) {
        
        for (Mob m: mobs){
            if(m.drawing){
                m.sumdtDraw += dt;
                m.drawStrength = m.drawStrengthMax - 1f/(m.sumdtDraw);
                if(m.drawStrength < 0) m.drawStrength = m.drawStrengthMax*0.725f; //before charging cure
                System.out.println(m.drawStrength + " / " + m.drawStrengthMax);
            }
    
            if(m.chargingJump){
                m.sumdtJump += dt;
                m.jumpStrength = m.jumpStrengthMax - 1f/(m.sumdtJump);
                if(m.jumpStrength < 0) m.jumpStrength =  m.drawStrengthMax*0.725f;
                System.out.println(m.jumpStrength + " / " + m.jumpStrengthMax);
            }
            
            if(m.jumping){
                m.getEntity().setAirborne(true);
                m.getVel().add(
                        new Vector3(
                        m.getMoveDir().x,
                        m.getMoveDir().y,
                        m.jumpStrength).nor().scl(m.jumpStrength)
                );
                m.sumdtJump = 0;
                m.jumpStrength = 0;
                m.jumping = false;
            }
            
            if(m.attacking){
                int dmg = (int)(m.drawStrength * 2f);
                m.sumdtDraw 		= 0;
                m.drawStrength 	= 0;
                m.attacking = false;
            }
            

            if (!m.getEntity().isAirborne()){
                if (m.sprinting){
                    m.sumdtSprint += dt;
                    m.getPos().add(
                            m.getMoveDir().x*m.getMoveSpeed()*m.getSprintMultiplier()*dt,
                            m.getMoveDir().y*m.getMoveSpeed()*m.getSprintMultiplier()*dt,
                            0);
                }
                else{
                    m.getPos().add(
                            m.getMoveDir().x*m.getMoveSpeed()*dt,
                            m.getMoveDir().y*m.getMoveSpeed()*dt,
                            0);
                }
            }
            else{
                m.getPos().x += m.getMoveDir().x*m.getMoveSpeed()*dt;
                m.getPos().y += m.getMoveDir().y*m.getMoveSpeed()*dt;
            }
            
        }
        
    }

    public void addMob(Mob m){
        mobs.add(m);
    }
    
    
    
    
}

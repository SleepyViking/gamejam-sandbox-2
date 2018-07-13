package net.sleepyviking.gjsb2.model;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import net.sleepyviking.gjsb2.controller.PlayerController;

public class Player extends Mob{
	
	public Player(Mob mob){

		this.entity           = mob.entity;               
		this.moveSpeed        = mob.moveSpeed;       
		this.sprintMultiplier = mob.sprintMultiplier;
		this.jumpHeight       = mob.jumpHeight;      
		this.health           = mob.health;          
		this.level            = mob.level;           
		this.STR              = mob.STR;             
		this.CON              = mob.CON;             
		this.DEX              = mob.DEX;             
		this.WIS              = mob.WIS;             
		this.INT              = mob.INT;             
		this.CHA              = mob.CHA;
		
		this.moveDir 			= new Vector2(0,0);
		
	}

}

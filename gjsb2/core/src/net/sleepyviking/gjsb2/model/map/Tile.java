package net.sleepyviking.gjsb2.model.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tile {

	/**
	 *	 Contains information like the textureRegion. In the future, may also be used for EG collision behavior for a tile,
	 *	 such as triggering world events and causing hazards to the player, and be a member of the TileSet class.
	 */

	private float 	height,
					friction;
	
	private boolean
		damage = false,
		floor = true,
		wall = false;
	
	TextureRegion textureRegion;

	public Tile(Texture t, int x, int y, int sizex, int sizey, boolean damage, boolean floor, boolean wall, float height, float friction){
		textureRegion = new TextureRegion(t, x*sizex, y*sizey, sizex, sizey);
		this.damage = damage;
		this.floor = floor;
		this.wall = wall;
		this.height = height;
		this.friction = friction;
	}

	public TextureRegion getTextureRegion() {
		return textureRegion;
	}
	
	public boolean isFloor(){
		return floor;
	}
	
	public float getHeight(){
		return height;
	}
	
	public void setHeight(float height){
		this.height = height;
	}
	
	public boolean isDamage(){
		return damage;
	}
	
	public void setDamage(boolean damage){
		this.damage = damage;
	}
	
	public void setFloor(boolean floor){
		this.floor = floor;
	}
	
	public boolean isWall(){
		return wall;
	}
	
	public void setWall(boolean wall){
		this.wall = wall;
	}
	
	public float getFriction(){
		return friction;
	}
}

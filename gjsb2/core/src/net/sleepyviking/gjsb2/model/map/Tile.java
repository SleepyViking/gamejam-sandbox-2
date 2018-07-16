package net.sleepyviking.gjsb2.model.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tile {

	/**
	 *	 Contains information like the textureRegion. In the future, may also be used for EG collision behavior for a tile,
	 *	 such as triggering world events and causing hazards to the player, and be a member of the TileSet class.
	 */

	private boolean
		damage = false,
		floor = true,
		wall = false;
	
	TextureRegion textureRegion;

	public Tile(Texture t, int x, int y, int sizex, int sizey, boolean damage, boolean floor, boolean wall){
		textureRegion = new TextureRegion(t, x*sizex, y*sizey, sizex, sizey);
		this.damage = damage;
		this.floor = floor;
		this.wall = wall;
	}

	public TextureRegion getTextureRegion() {
		return textureRegion;
	}
	
	public boolean isFloor(){
		return floor;
	}
}

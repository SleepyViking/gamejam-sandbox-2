package net.sleepyviking.gjsb2.model;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class Entity{

	private boolean airborne;
	private boolean living;
	
	private Decal decal;

	String name;

	int spriteDimX = 8, spriteDimY = 8;
	
	float weight;

	Vector3 pos = new Vector3();
	Vector3 vel = new Vector3();
	Vector2 size = new Vector2(1, 1);

	private Texture texture;
	
	public TextureRegion textureRegion;


	public Entity(){

	}

	public Entity(	String name,
					Texture texture,
					Vector3 pos,
					Vector3 vel,
					int spriteDimX,
					int spriteDimY,
					float weight,
					Vector2 size){
		this.name = name;
		this.texture = texture;
		this.setPos(pos);
		this.setVel(vel);
		this.size = size;
		this.spriteDimX = spriteDimX;
		this.spriteDimY = spriteDimY;
		this.textureRegion = new TextureRegion(texture, 0, 0, spriteDimX, spriteDimY);
		this.weight = weight;
		
		this.decal = Decal.newDecal(textureRegion, true);
		this.decal.setDimensions(size.x, size.y);
		
	}


	public Entity(Vector3 pos){
		this.pos = new Vector3();
		this.vel = new Vector3();
		setPos(pos);
	}

	public Entity(Vector3 pos, Vector3 vel){
		this.pos = new Vector3();
		this.vel = new Vector3();
		setPos(pos);
		setVel(vel);
	}
	
	public boolean isAirborne(){
		return airborne;
	}
	public void setAirborne(boolean airborne){
		this.airborne = airborne;
	}
	
	public Vector3 getPos(){
		return pos;
	}

	public Vector3 getVel() {
		return vel;
	}

	public Vector2 getSize(){
		return size;
	}

	public void setVel(Vector3 vel) {
		this.vel.set(vel);
	}

	public void setPos(Vector3 pos){
		this.pos.set(pos);
	}
	//One day, I'll be moving around the game world
	public void setSize(Vector2 size){
		this.size = size;
	}

	public void loadBase(FileHandle playerJson){
		JsonReader jsonReader = new JsonReader();
		JsonValue base;
		base = jsonReader.parse(playerJson);
		this.spriteDimX = base.getInt("spriteDimX");
		this.spriteDimY = base.getInt("spriteDimY");
		this.texture = new Texture(base.getString("spritesheet"));
	}
	
	@Override
	public String toString(){
		return String.format("%18s \tx: %3.2f, y: %3.2f", name, pos.x, pos.y);
	}
	
	public Decal getDecal(){
		return decal;
	}
}

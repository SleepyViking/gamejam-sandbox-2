package net.sleepyviking.gjsb2.model;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class Entity{

	String name;

	int spriteDimX = 8, spriteDimY = 8;

	Vector2 pos = new Vector2();
	Vector2 vel = new Vector2();

	private Texture texture;
	public TextureRegion textureRegion;

	public Entity(){

	}

	public Entity(String name, Texture texture, Vector2 pos, Vector2 vel, int spriteDimX, int spriteDimY){
		this.name = name;
		this.texture = texture;
		this.setPos(pos);
		this.setVel(vel);
		this.spriteDimX = spriteDimX;
		this.spriteDimY = spriteDimY;
		this.textureRegion = new TextureRegion(texture, 0, 0, spriteDimX, spriteDimY);
	}


	public Entity(Vector2 pos){
		this.pos = new Vector2();
		this.vel = new Vector2();
		setPos(pos);
	}

	public Entity(Vector2 pos, Vector2 vel){
		this.pos = new Vector2();
		this.vel = new Vector2();
		setPos(pos);
		setVel(vel);
	}

	public Vector2 getPos(){
		return pos;
	}

	public Vector2 getVel() {
		return vel;
	}

	public void setVel(Vector2 vel) {
		this.vel.set(vel);
	}

	public void setPos(Vector2 pos){
		this.pos.set(pos);
	}
	//One day, I'll be moving around the game world

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

}

package net.sleepyviking.gjsb2.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Entity{

	String name;

	int spriteSizeX = 8, spriteSizeY = 8;

	Vector2 pos;
	Vector2 vel;
	Vector2 size;
	public Texture texture = new Texture("spritesheet1.png");
	public TextureRegion textureRegion = new TextureRegion(texture, 0, 0, spriteSizeX, spriteSizeY);
	public Sprite sprite = new Sprite(texture);

	public Entity(){
		this.pos = new Vector2();
		this.vel = new Vector2();
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

	public Vector2 getSize(){
		return size;
	}

	public void setVel(Vector2 vel) {
		this.vel.set(vel);
	}

	public void setPos(Vector2 pos){
		this.pos.set(pos);
	}
	//One day, I'll be moving around the game world
	public void setSize(Vector2 size){
		this.size = size;
	}


	@Override
	public String toString(){
		return String.format("%18s \tx: %3.2f, y: %3.2f", name, pos.x, pos.y);
	}

}

package net.sleepyviking.gjsb2.model.map;


import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class TileSet {
	Array<Tile> tileSet;
	Texture texture;
	JsonReader jsonReader;
	JsonValue jsonBase;
	JsonValue tiles;
	int dimx, dimy;
	
	public TileSet(String filename){
		JsonValue tmp;
		jsonReader = new JsonReader();
		jsonBase = jsonReader.parse(new FileHandle(filename));
		texture = new Texture(jsonBase.getString("texture"));
		tiles = jsonBase.get("tiles");
		dimx = jsonBase.getInt("dimx");
		dimy = jsonBase.getInt("dimy");
		tileSet = new Array<Tile>(tiles.size);
		
		for (int i = 0; i < tiles.size; i++){
			tmp = tiles.get(i);
			tileSet.add(new Tile(texture, tmp.getInt("x"), tmp.getInt("y"), dimx, dimy));
		}

	}
	

	public int getSize(){
		return tileSet.size;
	}

	public Tile get(int i){
		return tileSet.get(i);
	}
	public int getDimx(){
		return dimx;
	}
	public int getDimy(){
		return dimy;
	}

	public void load(String filename){
	
	}
	

}

package net.sleepyviking.gjsb2.model.map;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import javax.xml.soap.Text;

public class Map {
	//To contain the grid of tiles that make up the ground layer of the game
	//each tile represented by an index which maps to the tileSet array.

	private JsonReader json;
	private JsonValue jsonBase;

	//private Texture mapTextureSheet;
	
	private int mapDimX, mapDimY;
	private int tileDimX, tileDimY;

	private int[] tiles;

	private TileSet tileSet;
	private String tileSetFile;
	
	//TODO: Make a JSON reader/writer for maps
	//public Map(String jsonName){
	//	json = new Json();
	//}

	public Map(FileHandle mapjson){
		json = new JsonReader();
		jsonBase = json.parse(mapjson);
		
		mapDimX = jsonBase.getInt("sizex");
		mapDimY = jsonBase.getInt("sizey");
		
		tiles = new int[jsonBase.get("tiles").size];
		tiles = jsonBase.get("tiles").asIntArray();
		tileSetFile = jsonBase.getString("tileset");
		tileSet = new TileSet(tileSetFile);
		
		tileDimX = tileSet.getDimx();
		tileDimY = tileSet.getDimy();

		//TODO: testing
		//randomize();
		//inOrder();
	}

	public Tile getTileAt(int x, int y){
		return tileSet.get(tiles[mapDimX*y + x]);
	}

	public void inOrder(){
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = i%tileSet.getSize();
		}
	}

	public void randomize(){
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = (int)(Math.random()*tileSet.getSize());
		}
	}

	public boolean checkIntegrity(){
		if(tileSet != null &&  tiles.length > 0){
			for (int i = 0; i < tiles.length; i++) {
				if(tiles[i] < 0 || tiles[i] >= tileSet.getSize()){
					return false;
				}
			}
			return true;
		} else return false;
	}

	public int tileCount(){
		return tiles.length;
	}
	public int getDimx(){return mapDimX;}
	public int getDimy(){return mapDimY;}

	public int getTiley() {
		return tileDimY;
	}
	public int getTilex() {
		return tileDimX;
	}
}

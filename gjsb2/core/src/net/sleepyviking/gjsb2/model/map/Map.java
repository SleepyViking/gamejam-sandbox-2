package net.sleepyviking.gjsb2.model.map;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import net.sleepyviking.gjsb2.model.Entity;
import net.sleepyviking.gjsb2.model.Player;

import javax.xml.soap.Text;
import java.io.File;

public class Map {
	//To contain the grid of tiles that make up the ground layer of the game
	//each tile represented by an index which maps to the tileSet array.

	private JsonReader json;
	private JsonValue jsonBase;
	private FileHandle mapjson;

	Player player;
	
	private int mapDimX, mapDimY;
	
	
	
	private int numLayers;
	private int tileDimX, tileDimY;

	private int[][] tiles; //tiles[0] = a 1dim array of all the tiles on the 0th layer.

	private TileSet tileSet;
	private String tileSetFile;

	public Map(FileHandle mapjson){
		this.mapjson = mapjson;

		json = new JsonReader();
		jsonBase = json.parse(mapjson);

		
		mapDimX = jsonBase.getInt("sizex");
		mapDimY = jsonBase.getInt("sizey");
		
		numLayers = jsonBase.get("tiles").size;
		
		tiles = new int[numLayers][];
		
		for (int i = 0; i < numLayers; i++){
			tiles[i] = new int[jsonBase.get("tiles").get(i).size];
			tiles[i] = jsonBase.get("tiles").get(i).asIntArray();
		}
		
		tileSetFile = jsonBase.getString("tileset");
		tileSet = new TileSet(tileSetFile);
		
		tileDimX = tileSet.getDimx();
		tileDimY = tileSet.getDimy();
	
		//randomize();
	}

	public Tile getTileAt(int x, int y, int z){
		return tileSet.get(tiles[z][mapDimX*y + x]);
	}

	public void randomize(){
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; i++) {
				tiles[i][j] = (int)(Math.random()*tileSet.getSize());
			}
		}
	}

	public boolean checkIntegrity(){
		if(tileSet != null &&  tiles.length > 0){
			for (int i = 0; i < tiles.length; i++) {
				for (int j = 0; j < tiles[i].length; j++) {
					if(tiles[i][j] < 0 || tiles[i][j] >= tileSet.getSize()){
						return false;
					}
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

	public FileHandle getMapjson(){
		return mapjson;
	}

	public void setPlayer(Player player){
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}
	
	public int getNumLayers(){
		return numLayers;
	}
}

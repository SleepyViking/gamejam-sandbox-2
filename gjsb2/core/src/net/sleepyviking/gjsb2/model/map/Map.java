package net.sleepyviking.gjsb2.model.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

import javax.xml.soap.Text;

public class Map {
	//To contain the grid of tiles that make up the ground layer of the game
	//each tile represented by an index which maps to the tileSet array.

	private Json json;

	private Texture mapTextureSheet;

	private int maxTiles;
	private int dimx, dimy;
	private int tilex, tiley;

	private int[] tiles;

	private Array<Tile> tileSet;

	//TODO: Make a JSON reader/writer for maps
	//public Map(String jsonName){
	//	json = new Json();
	//}



	public Map(Texture mapTextureSheet, int dimx, int dimy, int tilex, int tiley){

		this.mapTextureSheet = mapTextureSheet;
		this.dimx = dimx;
		this.dimy = dimy;
		this.tilex = tilex;
		this.tiley = tiley;

		tiles = new int[dimx*dimy];

		tileSet = new Array<Tile>();

		for (int y = 0; y < this.mapTextureSheet.getHeight()/tiley; y++) {
			for (int x = 0; x < this.mapTextureSheet.getWidth()/tilex; x++) {
				tileSet.add(new Tile(this.mapTextureSheet, tilex*x, tiley*y, tilex, tiley));
			}
		}

		//TODO: testing
		randomize();
		//inOrder();
	}

	public Tile getTileAt(int x, int y){
		return tileSet.get(tiles[dimx*y + x]);
	}

	public void inOrder(){
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = i%tileSet.size;
		}
	}

	public void randomize(){
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = (int)(Math.random()*tileSet.size);
		}
	}

	public boolean checkIntegrity(){
		if(tileSet != null &&  tiles.length > 0){
			for (int i = 0; i < tiles.length; i++) {
				if(tiles[i] < 0 || tiles[i] >= tileSet.size){
					return false;
				}
			}
			return true;
		} else return false;
	}

	public int tileCount(){
		return tiles.length;
	}
	public int getDimx(){return dimx;}
	public int getDimy(){return dimy;}

	public int getTiley() {
		return tiley;
	}
	public int getTilex() {
		return tilex;
	}
}

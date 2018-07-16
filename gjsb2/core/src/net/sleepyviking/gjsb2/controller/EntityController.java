package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import net.sleepyviking.gjsb2.model.Entity;
import net.sleepyviking.gjsb2.model.Mob;
import net.sleepyviking.gjsb2.model.Player;
import net.sleepyviking.gjsb2.model.World;
import net.sleepyviking.gjsb2.model.map.Map;
import net.sleepyviking.gjsb2.model.map.Tile;
import net.sleepyviking.gjsb2.model.physical.Constants;

public class EntityController extends Controller {

	World world;
	
	protected Array<Entity> entities;

	public EntityController(){
		entities = new Array<Entity>();
	}

	@Override
	public void update(float dt) {
		Entity e;
		for (int i = 0; i < entities.size; i++) {
			e = entities.get(i);
			
			e.getPos().add(
					e.getVel().x*dt,
					e.getVel().y*dt,
					e.getVel().z*dt
			);
			
			if(!world.map.tileSolid(e.getPos()) || (e.getPos().z > 0f)){
				e.setAirborne(true);
			} else if(world.map.tileSolid(e.getPos()) && (e.getPos().z == 0 || (e.getPos().z + e.getVel().z*dt <= 0))){
				e.setAirborne(false);
			}
			
			if(e.isAirborne()){
				e.getVel().z += Constants.gravity*dt;	//Todo: Make this a variable per map instead of a constant
			} else {
				if (e.getPos().z < 0) e.getPos().z = 0;
				e.getVel().setZero();
			}
			

		}
	}

	public void addEntity(Entity e){
		entities.add(e);
	}

	public void loadEntities(Map map, MobController mobController){
		JsonReader jr = new JsonReader();
		JsonValue 	entities = jr.parse(map.getMapjson()).get("entities");
		FileHandle 	entityBase;
		JsonValue 	defaultJson;
		JsonValue 	entityBaseJson;
		JsonValue 	entityStateJson;
		
		Array<JsonValue> hierarchy = new Array<JsonValue>();
		
		int playerIndex = jr.parse(map.getMapjson()).getInt("playerIndex");

		Mob mob;
		
		float x, y;
		float vx, vy;
		float sizex, sizey;
		float moveSpeed = 0.0f;
		float sprintMultiplier = 1.0f;
		float weight = 0.0f;
		boolean isMob;
		int health=10, level=1, STR=0, CON=0, DEX=0, WIS=0, INT=0, CHA=0;
		
		String name;

		int spriteDimX, spriteDimY;
		Texture texture;
		
		defaultJson = jr.parse(new FileHandle("defaults.json"));
		
		for (int i = 0; i < entities.size; i++) {
			
			//Initialize Entity State
			entityBase = new FileHandle(entities.get(i).getString("base"));
			entityBaseJson = jr.parse(entityBase);
			entityStateJson = entities.get(i);
			
			if(i == 0){
				hierarchy.add(entityStateJson);
				hierarchy.add(entityBaseJson);
				hierarchy.add(defaultJson);
			}
			
			//Draw from state in WORLD.json first; if variable doesn't exist there, draw instead from entityBaseJson,
			// and if THAT fails, pull from defaults.json which contains error values for all available variables.
			
			texture = new Texture(loadString("spritesheet", hierarchy));
			
			spriteDimX = loadInt("spriteDimX", 	hierarchy);
			spriteDimY = loadInt("spriteDimY", 	hierarchy);
			name = 	loadString	("name", 		hierarchy);
			x = 	loadFloat	("x"	, 		hierarchy);
			vx = 	loadFloat	("vx"	, 		hierarchy);
			y = 	loadFloat	("y"	, 		hierarchy);
			vy = 	loadFloat	("vy"	, 		hierarchy);
			sizex = loadFloat	("sizex", 		hierarchy);
			sizey = loadFloat	("sizey", 		hierarchy);
			weight= loadFloat	("weight", 		hierarchy);
			
			Entity e = new Entity(
					name,
					texture,
					new Vector3(x, y, 0),
					new Vector3(vx, vy, 0),
					spriteDimX,
					spriteDimY,
					weight,
					new Vector2(sizex, sizey)
			);
			
			isMob = loadBoolean("isMob", hierarchy);
			if(isMob){
				moveSpeed = 		loadFloat	("moveSpeed"		, hierarchy);
				sprintMultiplier = 	loadFloat	("sprintMultiplier"	, hierarchy);
				health 	= 			loadInt	("health", 	hierarchy);
				level 	= 			loadInt	("level", 	hierarchy);
				STR 	= 			loadInt	("STR"	, 	hierarchy);
				CON 	= 			loadInt	("CON"	, 	hierarchy);
				DEX 	= 			loadInt	("DEX"	, 	hierarchy);
				WIS 	= 			loadInt	("WIS"	, 	hierarchy);
				INT 	= 			loadInt	("INT"	, 	hierarchy);
				CHA 	= 			loadInt	("CHA"	, 	hierarchy);
				
				mob = new Mob(	e,
								moveSpeed,
								sprintMultiplier,
								health,
								level,
								STR,
								CON,
								DEX,
								WIS,
								INT,
								CHA
				);
				
				if(i == playerIndex) {
					Player player = new Player(mob);
					map.setPlayer(player);
					mobController.addMob(player);
				} else{
					mobController.addMob(mob);
				}
			}
			addEntity(e);
		}

	}
	
	public float 	loadFloat(String name, Array<JsonValue> hierarchy){
		for (JsonValue jv: hierarchy){
			if(jv.has(name)){return jv.getFloat(name);}
		}
		return -1.0f;
	}
	
	public int		loadInt(String name, Array<JsonValue> hierarchy){
		for (JsonValue jv: hierarchy){
			if(jv.has(name)){return jv.getInt(name);}
		}
		return -1;
	}
	
	public boolean loadBoolean(String name, Array<JsonValue> hierarchy){
		for (JsonValue jv: hierarchy){
			if(jv.has(name)){return jv.getBoolean(name);}
		}
		return false;
	}
	
	public String	loadString(String name, Array<JsonValue> hierarchy){
		for (JsonValue jv: hierarchy){
			if(jv.has(name)){return jv.getString(name);}
		}
		return "*Missing String*";
	}
	
	
	
	

}

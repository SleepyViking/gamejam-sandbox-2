package net.sleepyviking.gjsb2.controller;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import net.sleepyviking.gjsb2.model.Entity;
import net.sleepyviking.gjsb2.model.Mob;
import net.sleepyviking.gjsb2.model.Player;
import net.sleepyviking.gjsb2.model.map.Map;

public class EntityController extends Controller {

	protected Array<Entity> entities;

	public EntityController(){
		entities = new Array<Entity>();
	}

	@Override
	public void update(float dt) {
		Entity e;
		for (int i = 0; i < entities.size; i++) {
			e = entities.get(i);
			e.getPos().add(e.getVel().scl(dt));

		}
	}

	public void addEntity(Entity e){
		entities.add(e);
	}

	public void loadEntities(Map map, MobController mobController){
		JsonReader jr = new JsonReader();
		JsonValue entities = jr.parse(map.getMapjson()).get("entities");
		int playerIndex = jr.parse(map.getMapjson()).getInt("playerIndex");

		float x, y;
		float vx, vy;
		float sizex, sizey;
		float moveSpeed = 0.0f;
		boolean isMob;
		String name;

		int spriteDimX, spriteDimY;
		Texture texture;
		FileHandle entityBase;
		JsonValue entityBaseJson;


		for (int i = 0; i < entities.size; i++) {
			//Initialize Entity State
			entityBase = new FileHandle(entities.get(i).getString("base"));
			entityBaseJson = jr.parse(entityBase);
			texture = new Texture(entityBaseJson.getString("spritesheet"));
			spriteDimX = entityBaseJson.getInt("spriteDimX");
			spriteDimY = entityBaseJson.getInt("spriteDimY");

			isMob = entities.get(i).getBoolean("isMob");
			if(isMob) moveSpeed = entities.get(i).getFloat("moveSpeed");

			name = entities.get(i).getString("name");
			x = entities.get(i).getFloat("x");
			vx = entities.get(i).getFloat("vx");
			y = entities.get(i).getFloat("y");
			vy = entities.get(i).getFloat("vy");
			sizex = entities.get(i).getFloat("sizex");
			sizey = entities.get(i).getFloat("sizey");
			Entity e = new Entity(
							name,
							texture,
							new Vector2(x, y),
							new Vector2(vx, vy),
							spriteDimX,
							spriteDimY,
							new Vector2(sizex, sizey)
			);


			if(isMob){
				mobController.addMob(new Mob(e, moveSpeed));
			}

			if(i == playerIndex) {
				Player player = new Player(e, moveSpeed, "player");

				map.setPlayer(player);
			}

			addEntity(e);
		}

	}

}

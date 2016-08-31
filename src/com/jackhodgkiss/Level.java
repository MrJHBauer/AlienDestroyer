package com.jackhodgkiss;

import java.util.ArrayList;

import org.jbox2d.dynamics.World;

import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;


public class Level {

	private World world;
	
	private ArrayList<Actor> actors = new ArrayList<>();
	private ArrayList<Actor> actorsToRemove = new ArrayList<>();
	
	private PhysicalAlien alien;
	
	private Background background;
	
	private PApplet parent;
	
	private int blocksToRemove;
	
	public Level(PApplet parent) {
		this.parent = parent;
		background = new Background(parent);
		world = PhysiVals.getWorldInstance();
		world.setContactListener(new ContactListener());
		generateLevel();
	}
	
	private void generateLevel() {
		actors.add(new Floor(parent.width / 2, parent.height + 5, parent.width, 10));
		JSONObject json;
		json = parent.loadJSONObject("data/Level_01.json");
		JSONArray JSONActors = json.getJSONObject("level").getJSONArray("actors");
		for(int i = 0; i < JSONActors.size(); i++) {
			JSONObject current = JSONActors.getJSONObject(i);
			String type = current.getString("type");
			String form = current.getString("form");
			int x = current.getInt("x");
			int y = current.getInt("y");
			if(type.equals("Alien")) {
				alien = new PhysicalAlien(x, y, Alien.valueOf(form), parent);
				actors.add(alien);
			} else {
				actors.add(new PhysicalElement(x, y, Element.valueOf(form), parent));
			}
		}
		blocksToRemove = json.getJSONObject("level").getInt("blocksToRemove");
	}
	
	private void reset() {
		for(Actor a : actors) {
			a.kill();
		}
		actors.clear();
		generateLevel();
	}
	
	public void update() {
		world.step(1.0f / 60.0f, 8, 3);
		for(Actor a : actors) {
			if(a.getBody() != null) {
				a.update();
			} else {
				actorsToRemove.add(a);
			}
		}
		if(alien.isTouchedGround()) {
			reset();
		}
		actors.removeAll(actorsToRemove);
		actorsToRemove.clear();
		if(blocksToRemove == 0) {
			reset();
		}
	}
	
	public void mouseClicked() {
		for(Actor a : actors) {
			if(a instanceof PhysicalElement) {
				if(a.body != null) {
					if(a.getSprite().isMouseOver()) {
						a.kill();
						blocksToRemove--;
					}
				}
			}
		}
	}
	
	public void draw() {
		background.draw();
		parent.text("Blocks To Remove: " + blocksToRemove, parent.width - 200, 50);
		for(Actor a : actors) {
			a.draw();
		}
	}
	
}

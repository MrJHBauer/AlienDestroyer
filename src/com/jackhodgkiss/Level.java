package com.jackhodgkiss;

import java.util.ArrayList;

import org.jbox2d.dynamics.World;

import processing.core.PApplet;

public class Level {

	private World world;
	
	private ArrayList<Actor> actors = new ArrayList<>();
	private ArrayList<Actor> actorsToRemove = new ArrayList<>();
	
	private PhysicalAlien alien;
	
	private Background background;
	
	private PApplet parent;
	
	public Level(PApplet parent) {
		this.parent = parent;
		background = new Background(parent);
		world = PhysiVals.getWorldInstance();
		world.setContactListener(new ContactListener());
		generateLevel();
	}
	
	private void generateLevel() {
		actors.add(new Floor(parent.width / 2, parent.height + 5, parent.width, 10));
		actors.add(new PhysicalElement(parent.width / 2 - (220 / 2) + 35, parent.height - 35, Element.Wood010, parent));
		actors.add(new PhysicalElement(parent.width / 2 + (220 / 2) - 35, parent.height - 35, Element.Wood010, parent));
		actors.add(new PhysicalElement(parent.width / 2, parent.height - 105, Element.Wood012, parent));
		actors.add(new PhysicalElement(parent.width / 2 - (220 / 2) + 35, parent.height - 175, Element.Wood010, parent));
		actors.add(new PhysicalElement(parent.width / 2 + (220 / 2) - 35, parent.height - 175, Element.Wood010, parent));
		actors.add(new PhysicalElement(parent.width / 2, parent.height - 245, Element.Wood012, parent));
		alien = new PhysicalAlien(parent.width / 2, parent.height - 315, Alien.values()[(int) parent.random(0, Alien.values().length)], parent);
		actors.add(alien);
	}
		
	public void update() {
		world.step(1.0f / 60.0f, 8, 3);
		if(parent.mousePressed == true) {
			for(Actor a : actors) {
				if(a instanceof PhysicalElement) {
					if(a.body != null) {
						if(a.getSprite().isMouseOver()) {
							a.kill();
						}
					}
				}
			}
		}
		for(Actor a : actors) {
			if(a.getBody() != null) {
				a.update();
			} else {
				actorsToRemove.add(a);
			}
		}
		if(alien.isTouchedGround()) {
			if(alien.body != null) {
				alien.kill();
				System.out.println("You Failed The Level, Alien Hit The Ground!");
			}
		}
		actors.removeAll(actorsToRemove);
		actorsToRemove.clear();
	}
	
	public void draw() {
		background.draw();
		for(Actor a : actors) {
			a.draw();
		}
	}
	
}

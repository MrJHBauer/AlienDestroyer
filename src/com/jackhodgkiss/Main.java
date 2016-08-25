package com.jackhodgkiss;

import java.util.ArrayList;

import org.jbox2d.dynamics.World;

import processing.core.PApplet;

public class Main extends PApplet {
	
	World world;
	
	ArrayList<Actor> actors = new ArrayList<>();
	ArrayList<Actor> actorsToRemove = new ArrayList<>();
	
	PhysicalAlien alien;
	
	public void settings() {
		size(1280, 720);
	}
	
	public void setup() {
		background(180);
		world = PhysiVals.getWorldInstance();
		world.setContactListener(new ContactListener());
		actors.add(new Floor(width / 2, height + 5, width, 10));
		actors.add(new PhysicalElement(width / 2 - (220 / 2) + 35, height - 35, Element.Wood010, this));
		actors.add(new PhysicalElement(width / 2 + (220 / 2) - 35, height - 35, Element.Wood010, this));
		actors.add(new PhysicalElement(width / 2, height - 105, Element.Wood012, this));
		actors.add(new PhysicalElement(width / 2 - (220 / 2) + 35, height - 175, Element.Wood010, this));
		actors.add(new PhysicalElement(width / 2 + (220 / 2) - 35, height - 175, Element.Wood010, this));
		actors.add(new PhysicalElement(width / 2, height - 245, Element.Wood012, this));
		alien = new PhysicalAlien(width / 2, height - 315, Alien.values()[(int) random(0, Alien.values().length)], this);
		actors.add(alien);
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
			if(alien.body != null) {
				alien.kill();
				System.out.println("You Failed The Level, Alien Hit The Ground!");
			}
		}
		actors.removeAll(actorsToRemove);
		actorsToRemove.clear();
	}
	
	public void mouseClicked() {
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
	
	public void draw() {
		update();
		background(180);
		for(Actor a : actors) {
			a.draw();
		}
	}
	
	public static void main(String[] args) {
		PApplet.main("com.jackhodgkiss.Main");
	}

}

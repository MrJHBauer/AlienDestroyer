package com.jackhodgkiss;

import java.util.ArrayList;

import org.jbox2d.dynamics.World;

import processing.core.PApplet;

public class Main extends PApplet {
	
	World world;
	
	ArrayList<Actor> actors = new ArrayList<>();
	ArrayList<Actor> actorsToRemove = new ArrayList<>();
	
	public void settings() {
		size(1280, 720);
	}
	
	public void setup() {
		background(180);
		world = PhysiVals.getWorldInstance();
		world.setContactListener(new ContactListener());
		actors.add(new Floor(width / 2, height + 5, width, 10));
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
		actors.removeAll(actorsToRemove);
		actorsToRemove.clear();
	}
	
	public void mouseClicked() {
		if(Math.random() <= 0.5) {
			actors.add(new PhysicalElement(mouseX, mouseY, Element.values()[(int) random(0, Element.values().length)], this));
		} else {
			actors.add(new PhysicalAlien(mouseX, mouseY, Alien.values()[(int) random(0, Alien.values().length)], this));
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

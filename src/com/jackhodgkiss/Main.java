package com.jackhodgkiss;

import java.util.ArrayList;

import org.jbox2d.dynamics.World;

import processing.core.PApplet;

public class Main extends PApplet {
	
	World world;
	
	ArrayList<Actor> actors = new ArrayList<>();
	
	public void settings() {
		size(1280, 720);
	}
	
	public void setup() {
		background(180);
		world = PhysiVals.getWorldInstance();
	}
	
	public void update() {
		world.step(1.0f / 60.0f, 8, 3);
		for(Actor a : actors) {
			a.update();
		}
	}
	
	public void mouseClicked() {
		actors.add(new Ball(mouseX, mouseY, "data/Wood/elementWood000.png", this));
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

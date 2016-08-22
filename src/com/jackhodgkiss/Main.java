package com.jackhodgkiss;

import org.jbox2d.dynamics.World;

import processing.core.PApplet;

public class Main extends PApplet {
	
	World world;
	
	public void settings() {
		size(1280, 720);
	}
	
	public void setup() {
		background(180);
		world = PhysiVals.getWorldInstance();
	}
	
	public void update() {
		world.step(1.0f / 60.0f, 8, 3);
	}
	
	public void draw() {
		update();
		background(180);
	}
	
	public static void main(String[] args) {
		PApplet.main("com.jackhodgkiss.Main");
	}

}

package com.jackhodgkiss;

import processing.core.PApplet;

public class Main extends PApplet {
	
	Level level;
	
	public void settings() {
		size(1280, 720);
	}
	
	public void setup() {
		level = new Level(this);
	}
	
	public void update() {
		level.update();
	}
		
	public void draw() {
		update();
		level.draw();		
	}
	
	public static void main(String[] args) {
		PApplet.main("com.jackhodgkiss.Main");
	}

}

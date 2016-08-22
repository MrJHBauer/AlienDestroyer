package com.jackhodgkiss;

import processing.core.PApplet;

public class Main extends PApplet {

	public void settings() {
		size(1280, 720);
	}
	
	public void setup() {
		background(180);
	}
	
	public void update() {
		
	}
	
	public void draw() {
		update();
		background(180);
	}
	
	public static void main(String[] args) {
		PApplet.main("com.jackhodgkiss.Main");
	}

}

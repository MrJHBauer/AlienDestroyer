package com.jackhodgkiss;

import processing.core.PApplet;
import processing.core.PFont;

public class Main extends PApplet {
	
	private Level level;
	private Background background;
	private State state;
	
	public void settings() {
		size(1280, 720);
	}
	
	public void setup() {
		state = State.MENU;
		level = new Level(this);
		background = new Background(this);
	}
	
	public void update() {
		if(state == State.MENU) {
			if(key == ENTER) {
				state = State.PLAYING;
			}
		} else {
			level.update();
		}
		
	}
		
	public void draw() {
		update();
		if(state == State.MENU) {
			background.draw();
			textAlign(CENTER);
			textSize(24);
			fill(0, 0, 0);
			text("Alien Destroyer", width / 2, height / 8);
			text("Press 'Enter' To Continue", width / 2, height - height / 8);
		} else {
			level.draw();
		}
		
	}
	
	public static void main(String[] args) {
		PApplet.main("com.jackhodgkiss.Main");
	}

	public enum State {
		PLAYING,
		MENU;
	}
	
}

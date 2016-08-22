package com.jackhodgkiss;

import processing.core.PApplet;

public class Main extends PApplet {
	
	Sprite sprite;
	
	public void settings() {
		size(1280, 720);
	}
	
	public void setup() {
		background(180);
		sprite = new Sprite(width / 2, height / 2, "data/Wood/elementWood015.png", this);
	}
	
	public void update() {
		sprite.setX(mouseX);
		sprite.setY(mouseY);
		sprite.setAngle((float) (sprite.getAngle() + Math.toRadians(1)));
	}
	
	public void mouseClicked() {
		sprite.setVisible(!sprite.isVisible());
	}
	
	public void draw() {
		update();
		background(180);
		sprite.draw();
	}
	
	public static void main(String[] args) {
		PApplet.main("com.jackhodgkiss.Main");
	}

}

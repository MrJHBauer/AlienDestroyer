package com.jackhodgkiss;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Sprite {

	private float x;
	private float y;
	private float angle;
	
	private PImage texture;
	private boolean isVisible = true;
	private PApplet parent;
	
	
	public Sprite(float x, float y, String URL, PApplet parent) {
		this.x = x;
		this.y = y;
		this.parent = parent;

		texture = parent.loadImage(URL);
	}
	
	public void draw() {
		if(isVisible) {
			parent.imageMode(PConstants.CENTER);
			parent.pushMatrix();
			parent.translate(x, y);
			parent.rotate(angle);
			parent.image(texture, 0, 0);
			parent.popMatrix();
			parent.imageMode(PConstants.CORNER);
		}
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public int getWidth() {
		return texture.width; 
	}
	
	public int getHeight() {
		return texture.height;
	}
	
	public PImage getTexture() {
		return texture;
	}

	public void setTexture(PImage texture) {
		this.texture = texture;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	
}

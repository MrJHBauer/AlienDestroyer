package com.jackhodgkiss;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

import processing.core.PApplet;

public class Ball extends Actor {

	public Ball(float x, float y, String URL, PApplet parent) {
		sprite = new Sprite(x, y, URL, parent);
		body = generateBody();
	}
	
	public Body generateBody() {
		CircleShape cs = new CircleShape();
		cs.setRadius(sprite.getWidth() / 2 * (1 / PhysiVals.RATIO));
		
		FixtureDef fd = new FixtureDef();
		fd.shape = cs;
		fd.density = 1.0f;
		fd.friction = 0.8f;
		fd.restitution = 0.3f;
		
		BodyDef bd = new BodyDef();
		bd.position.set(sprite.getX() / PhysiVals.RATIO, sprite.getY() / PhysiVals.RATIO);
		bd.type = BodyType.DYNAMIC;
			
		Body b = PhysiVals.getWorldInstance().createBody(bd);
		b.createFixture(fd);
		b.setUserData(this);
		return b;
	}
	
}

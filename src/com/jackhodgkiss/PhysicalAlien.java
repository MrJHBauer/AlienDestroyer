package com.jackhodgkiss;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

import processing.core.PApplet;

public class PhysicalAlien extends Actor {

	private PolygonShape polygonShape;
	private CircleShape circleShape;
	private FixtureDef fixtureDefinition;
	private	BodyDef bodyDefinition;
	
	public PhysicalAlien(float x, float y, Alien alien, PApplet parent) {
		setSprite(new Sprite(x, y, alien.getURL(), parent));
		setBody(generateBody(alien.getShape()));
	}
	
	private Body generateBody(Shape shape) {
		if(shape == Shape.CIRCLE) {
			circleShape = new CircleShape();
			circleShape.setRadius(getSprite().getWidth() / 2 * (1 / PhysiVals.RATIO));
		} else {
			polygonShape = new PolygonShape();
			polygonShape.setAsBox(getSprite().getWidth() / 2 * (1 / PhysiVals.RATIO), 
					getSprite().getHeight() / 2 * (1 / PhysiVals.RATIO));
		}
		
		fixtureDefinition = new FixtureDef();
		fixtureDefinition.shape = polygonShape != null ? polygonShape : circleShape;
		fixtureDefinition.density = 1.0f;
		fixtureDefinition.friction = 0.8f;
		fixtureDefinition.restitution = 0.3f;
		
		bodyDefinition = new BodyDef();
		bodyDefinition.type = BodyType.DYNAMIC;
		bodyDefinition.position.set(getSprite().getX() / PhysiVals.RATIO, 
				getSprite().getY() / PhysiVals.RATIO);
		
		body = PhysiVals.getWorldInstance().createBody(bodyDefinition);
		body.createFixture(fixtureDefinition);
		
		return body;
	}
	
}

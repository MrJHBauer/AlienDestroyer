package com.jackhodgkiss;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;


public class Floor extends Actor {

	private PolygonShape polygonShape;
	private FixtureDef fixtureDefinition;
	private	BodyDef bodyDefinition;
	
	public Floor(int x, int y, int width, int height) {
		setBody(generateBody(x, y, width, height));
	}
	
	private Body generateBody(int x, int y, int width, int height) {	
		polygonShape = new PolygonShape();
		polygonShape.setAsBox(width / 2 * (1 / PhysiVals.RATIO), 
				height / 2 * (1 / PhysiVals.RATIO));
		
		fixtureDefinition = new FixtureDef();
		fixtureDefinition.shape = polygonShape;
		fixtureDefinition.density = 1.0f;
		fixtureDefinition.friction = 0.8f;
		fixtureDefinition.restitution = 0.3f;
		
		bodyDefinition = new BodyDef();
		bodyDefinition.type = BodyType.STATIC;
		bodyDefinition.position.set(x / PhysiVals.RATIO, 
				y / PhysiVals.RATIO);
		
		body = PhysiVals.getWorldInstance().createBody(bodyDefinition);
		body.createFixture(fixtureDefinition);
		
		return body;
	}
	
	public void update() { }
	
	public void draw() { }
	
}

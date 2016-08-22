package com.jackhodgkiss;

import org.jbox2d.dynamics.Body;

public class Actor {

	protected Sprite sprite;
	protected Body body;
	
	public void update() {
		if(body != null) {
			sprite.setX(body.getPosition().x * PhysiVals.RATIO);
			sprite.setY(body.getPosition().y * PhysiVals.RATIO);
			sprite.setAngle(body.getAngle());
		}		
	}
	
	public void draw() {
		sprite.draw();
	}
	
	protected Sprite getSprite() {
		return sprite;
	}

	protected void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	protected Body getBody() {
		return body;
	}

	protected void setBody(Body body) {
		this.body = body;
		body.setUserData(this);
	}
	
	protected void destroyBody() {
		PhysiVals.getWorldInstance().destroyBody(body);
		setBody(null);
	}
	
}

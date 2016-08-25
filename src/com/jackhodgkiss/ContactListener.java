package com.jackhodgkiss;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.collision.Manifold;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.contacts.Contact;

public class ContactListener implements org.jbox2d.callbacks.ContactListener {

	@Override
	public void beginContact(Contact contact) {
		Body bodyA = contact.getFixtureA().getBody();
		Body bodyB = contact.getFixtureB().getBody();
		if(bodyA.getUserData() instanceof PhysicalAlien && bodyB.getUserData() instanceof Floor) {
			PhysicalAlien alien = (PhysicalAlien) bodyA.getUserData();
			alien.setTouchedGround(true);
		} else if(bodyA.getUserData() instanceof Floor && bodyB.getUserData() instanceof PhysicalAlien) {
			PhysicalAlien alien = (PhysicalAlien) bodyB.getUserData();
			alien.setTouchedGround(true);
		}
	}
	
	@Override
	public void endContact(Contact arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postSolve(Contact arg0, ContactImpulse arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preSolve(Contact arg0, Manifold arg1) {
		// TODO Auto-generated method stub

	}	
}

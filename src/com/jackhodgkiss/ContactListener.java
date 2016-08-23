package com.jackhodgkiss;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.collision.Manifold;
import org.jbox2d.dynamics.contacts.Contact;

public class ContactListener implements org.jbox2d.callbacks.ContactListener {

	@Override
	public void beginContact(Contact contact) {
		if(contact.getFixtureA().getBody().getUserData() instanceof PhysicalAlien && 
				contact.getFixtureB().getBody().getUserData() instanceof Floor) {
			System.out.println("Alien has come into contact with the floor");
		} else if(contact.getFixtureA().getBody().getUserData() instanceof Floor && 
				contact.getFixtureB().getBody().getUserData() instanceof PhysicalAlien) {
			System.out.println("Alien has come into contact with the floor");
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

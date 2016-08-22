package com.jackhodgkiss;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

public class PhysiVals {

	public static float RATIO = 30.0f;
	
	private static World world;
	
	public static World getWorldInstance() {
		if(world == null) {
			world = new World(new Vec2(0.0f, 9.81f));
		}
		return world;
	}
}

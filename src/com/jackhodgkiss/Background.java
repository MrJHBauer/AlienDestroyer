package com.jackhodgkiss;

import processing.core.PApplet;
import processing.core.PConstants;

public class Background {

	private Sprite background;
	
	public Background(PApplet parent) {
		background = new Sprite(0, 0, URL.GRASS.getURL(), parent);
		background.setImageMode(PConstants.CORNER);
		background.getTexture().resize(parent.width, parent.height);
	}
	
	public void draw() {
		background.draw();
	}
	
	private enum URL {
		DESERT("colored_desert.png"),
		GRASS("colored_grass.png"),
		LAND("colored_land.png"),
		SHROOM("colored_shroom.png");
		
		private String URL;
		
		URL(String URL) {
			this.URL = URL;
		}
		
		public String getURL() {
			return "data/Backgrounds/" + URL;
		}
		
	}
	
}

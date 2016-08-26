package com.jackhodgkiss;

import processing.core.PApplet;
import processing.core.PConstants;

public class Background {

	private Sprite[] backgroundMap;
	
	public Background(PApplet parent) {
		backgroundMap = new Sprite[(int) Math.ceil((double)parent.width / 1024)];
		for(int i = 0; i < backgroundMap.length; i++) {
			backgroundMap[i] = new Sprite(i * 1024, 0, URL.GRASS.getURL(), parent);
			backgroundMap[i].setImageMode(PConstants.CORNER);
			backgroundMap[i].getTexture().resize(backgroundMap[i].getTexture().width, 
					parent.height > backgroundMap[i].getTexture().height ? parent.height : backgroundMap[i].getTexture().height);
		}
	}
	
	public void draw() {
		for(Sprite s : backgroundMap) {
			s.draw();
		}
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

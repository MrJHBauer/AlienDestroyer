package com.jackhodgkiss;

public enum Element {
	Wood000("elementWood000.png", Shape.CIRCLE),
	Wood001("elementWood001.png", Shape.TRIANGLE),
	Wood002("elementWood002.png", Shape.TRIANGLE),
	Wood003("elementWood003.png", Shape.CIRCLE),
	Wood004("elementWood004.png", Shape.TRIANGLE),
	Wood005("elementWood005.png", Shape.TRIANGLE),
	Wood006("elementWood006.png", Shape.CIRCLE),
	Wood007("elementWood007.png", Shape.TRIANGLE),
	Wood008("elementWood008.png", Shape.TRIANGLE),
	Wood009("elementWood009.png", Shape.CIRCLE),
	Wood010("elementWood010.png", Shape.SQUARE),
	Wood011("elementWood011.png", Shape.SQUARE),
	Wood012("elementWood012.png", Shape.SQUARE),
	Wood013("elementWood013.png", Shape.SQUARE),
	Wood014("elementWood014.png", Shape.SQUARE),
	Wood015("elementWood015.png", Shape.SQUARE),
	Wood016("elementWood016.png", Shape.SQUARE),
	Wood017("elementWood017.png", Shape.SQUARE),
	Wood018("elementWood018.png", Shape.SQUARE),
	Wood019("elementWood019.png", Shape.SQUARE),
	Wood020("elementWood020.png", Shape.SQUARE),
	Wood021("elementWood021.png", Shape.SQUARE),
	Wood022("elementWood022.png", Shape.SQUARE),
	Wood023("elementWood023.png", Shape.SQUARE),
	Wood024("elementWood024.png", Shape.SQUARE),
	Wood025("elementWood025.png", Shape.SQUARE),
	Wood026("elementWood026.png", Shape.SQUARE),
	Wood027("elementWood027.png", Shape.SQUARE),
	Wood028("elementWood028.png", Shape.SQUARE),
	Wood029("elementWood029.png", Shape.SQUARE),
	Wood030("elementWood030.png", Shape.SQUARE),
	Wood031("elementWood031.png", Shape.SQUARE),
	Wood032("elementWood032.png", Shape.SQUARE),
	Wood033("elementWood033.png", Shape.SQUARE),
	Wood034("elementWood034.png", Shape.SQUARE),
	Wood035("elementWood035.png", Shape.SQUARE),
	Wood036("elementWood036.png", Shape.SQUARE),
	Wood037("elementWood037.png", Shape.SQUARE),
	Wood038("elementWood038.png", Shape.SQUARE),
	Wood039("elementWood039.png", Shape.SQUARE),
	Wood040("elementWood040.png", Shape.SQUARE),
	Wood041("elementWood041.png", Shape.SQUARE),
	Wood042("elementWood042.png", Shape.TRIANGLE),
	Wood043("elementWood043.png", Shape.TRIANGLE),
	Wood044("elementWood044.png", Shape.CIRCLE),
	Wood045("elementWood045.png", Shape.SQUARE),
	Wood046("elementWood046.png", Shape.SQUARE),
	Wood047("elementWood047.png", Shape.SQUARE),
	Wood048("elementWood048.png", Shape.SQUARE),
	Wood049("elementWood049.png", Shape.SQUARE),
	Wood050("elementWood050.png", Shape.SQUARE),
	Wood051("elementWood051.png", Shape.SQUARE),
	Wood052("elementWood052.png", Shape.SQUARE),
	Wood053("elementWood053.png", Shape.TRIANGLE),
	Wood054("elementWood054.png", Shape.TRIANGLE);
	
	private String URL;
	
	private Shape shape;
	
	Element(String URL, Shape shape) {
		this.URL = URL;
		this.shape = shape;
	}
	
	public String getURL() {
		return "data/Wood/" + URL;
	}
	
	public Shape getShape() {
		return shape;
	}
	
}

package com.jackhodgkiss;

public enum Alien {
	BeigeRound("alienBeige_round.png", Shape.CIRCLE),
	BeigeSquare("alienBeige_square.png", Shape.SQUARE),
	BeigeSuit("alienBeige_suit.png", Shape.SQUARE),
	BlueRound("alienBlue_round.png", Shape.CIRCLE),
	BlueSquare("alienBlue_square.png", Shape.SQUARE),
	BlueSuit("alienBlue_suit.png", Shape.SQUARE),
	GreenRound("alienGreen_round.png", Shape.CIRCLE),
	GreenSquare("alienGreen_square.png", Shape.SQUARE),
	GreenSuit("alienGreen_suit.png", Shape.SQUARE),
	PinkRound("alienPink_round.png", Shape.CIRCLE),
	PinkSquare("alienPink_square.png", Shape.SQUARE),
	PinkSuit("alienPink_suit.png", Shape.SQUARE),
	YellowRound("alienYellow_round.png", Shape.CIRCLE),
	YellowSquare("alienYellow_square.png", Shape.SQUARE),
	YellowSuit("alienYellow_suit.png", Shape.SQUARE);
	
	private String URL;
	
	private Shape shape;
	
	Alien(String URL, Shape shape) {
		this.URL = URL;
		this.shape = shape;
	}
	
	public String getURL() {
		return "data/Aliens/" + URL;
	}
	
	public Shape getShape() {
		return shape;
	}
	
}

package com.prog32758;

import java.util.ArrayList;

public class Coordinates {
	private int x, y;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void storeCoordinates(Coordinates coord) {
		ArrayList<Coordinates> coordinates = new ArrayList<>();
		coordinates.add(coord);
	}
	
	// possible moves from coordinates
	// p1: R 2 up 1
	// p2: R 1 up 2
	// p3: L 1 up 2
	// p4: L 2 up 1
	// p5: L 2 down 1
	// p6: L 1 down 2
	// p7: R 1 down 2
	// p8: R 2 down 1
	
	

}

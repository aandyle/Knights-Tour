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

	@Override
	public String toString() {
		return "Coordinates [y=" + x + ", x=" + y + "]";
	}
	
	
	
//	public void storeCoordinates(Coordinates coord) {
//		ArrayList<Coordinates> coordinates = new ArrayList<>();
//		coordinates.add(coord);
//	}

}

package com.prog32758;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Intelligent extends Board{

	public Intelligent(int x, int y) {
		super(x, y);
	}
	
	//hard-code heuristics map into 2d array
	//match available coordinates with heuristics map values 
	//use HashMap to store custom class Coordinate(Key) with heuristic map(value)
	//determine lowest heuristic values, discard the rest of HashMap
	//randomly select one from the Map
	
	public Coordinates moves() {			//returns coordinates for a random move
		moves.clear();
		moves = new ArrayList<>();
		
		Coordinates move1 = new Coordinates(xPos+2, yPos+1);
		Coordinates move2 = new Coordinates(xPos+1, yPos+2);
		Coordinates move3 = new Coordinates(xPos-1, yPos+2);
		Coordinates move4 = new Coordinates(xPos-2, yPos+1);
		Coordinates move5 = new Coordinates(xPos-2, yPos-1);
		Coordinates move6 = new Coordinates(xPos-1, yPos-2);
		Coordinates move7 = new Coordinates(xPos+1, yPos-2);
		Coordinates move8 = new Coordinates(xPos+2, yPos-1);
		
		moves.addAll(Arrays.asList(move1,move2,move3,move4,move5,move6,move7,move8));
		
		Iterator<Coordinates> i = moves.iterator();
		while (i.hasNext()) {
			Coordinates moves = i.next();
			System.out.print("" + moves.getX() + " " + moves.getY() + "   "); 
			if (moves.getX() < 0 | moves.getY() < 0 | moves.getX() > 7 | moves.getY() > 7) {
				i.remove();
				System.out.println("Removed");
			}
		}
		
		Iterator<Coordinates> z = moves.iterator();
		while (z.hasNext()) {
			Coordinates moves = z.next();
			if (!isAvailable(moves.getX(), moves.getY())) {
				System.out.println(moves + "Unavailable");
				z.remove();
			}
		}
		
		System.out.println(moves.toString());					//show all possible moves;debug
		
		Coordinates selected = moves.get(r.nextInt(moves.size()));
		System.out.println(selected);
		return selected;
	}
	
}
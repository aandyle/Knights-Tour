package com.prog32758;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dumb {
	// p1: R 2 up 1
	// p2: R 1 up 2
	// p3: L 1 up 2
	// p4: L 2 up 1
	// p5: L 2 down 1
	// p6: L 1 down 2
	// p7: R 1 down 2
	// p8: R 2 down 1

	public static void main(String[] args) {

		int x, y;
		Scanner k = new Scanner(System.in);

		System.out.print("Enter starting x coordinate: ");
		x = k.nextInt();
		System.out.print("Enter starting y coordinate: ");
		y = k.nextInt();

		Coordinates start = new Coordinates(x, y); // starting position
		Board b1 = new Board(x,y);
		
		
		
		b1.printBoard();
		

		// if moves.hasnext then keep moving
		// else end and print array


	}
	
	public static void calculateMoves(Coordinates position) {
		
		ArrayList<Coordinates> moves = new ArrayList<>();
		
		Coordinates move1 = new Coordinates(position.getX()+2,position.getY()+1);
		Coordinates move2 = new Coordinates(position.getX()+1,position.getY()+2);
		Coordinates move3 = new Coordinates(position.getX()-1,position.getY()+2);
		Coordinates move4 = new Coordinates(position.getX()-2,position.getY()+1);
		Coordinates move5 = new Coordinates(position.getX()-2,position.getY()-1);
		Coordinates move6 = new Coordinates(position.getX()-1,position.getY()-2);
		Coordinates move7 = new Coordinates(position.getX()+1,position.getY()-2);
		Coordinates move8 = new Coordinates(position.getX()+2,position.getY()-1);
		
		moves.addAll(Arrays.asList(move1,move2,move3,move4,move5,move6,move7,move8));
		
		for (Coordinates i : moves) {
			if(i.getX() < 0 | i.getY() < 0) {	//remove negative coordinates
				moves.remove(i);
			}
			
			if(b1.isAvailable(i.getX(),i.getY())) {		//check if move is available
				
			}
		}
		
	}

}

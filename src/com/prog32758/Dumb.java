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

		Board b1 = new Board(x,y);	//itr1 & itr2
		
		
		
		for (int i = 0; i < 64; i ++) {
			b1.recordMove(b1.moves());
			b1.printBoard();
			System.out.println("Iternation number: " + i);	//need to add two
		}
		
//		while(b1.moves() != ) {
//			
//		}
		
		

		// if moves.hasnext then keep moving
		// else end and print array


	}

}

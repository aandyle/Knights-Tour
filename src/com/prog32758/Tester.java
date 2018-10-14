package com.prog32758;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {

		int x, y;
		Scanner k = new Scanner(System.in);

		System.out.print("Enter starting x coordinate: ");
		x = k.nextInt();
		System.out.print("Enter starting y coordinate: ");
		y = k.nextInt();

		System.out.print("Select n for non intelligent, or anything else for intelligent: ");
		if (k.next().equals("n")) {
			Board b1 = new Board(x, y); // itr1 & itr2

			for (int i = 0; i < 63; i++) {
				b1.recordMove(b1.moves());
				b1.printBoard();
				System.out.println("Iternation number: " + i); // need to add two
			}
		} else {
			BoardIntelligent bi1 = new BoardIntelligent(x, y); // itr1 & itr2

			for (int i = 0; i < 63; i++) {
				bi1.recordMove(bi1.moves());
				bi1.printBoard();
				System.out.println("Iternation number: " + i); // need to add two
			}
		}
		
		//TODO
		//-write to a text file
		//-display output in browser
		//-use redirect/requestdispatcher
		
	}

}

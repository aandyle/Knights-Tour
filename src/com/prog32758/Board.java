package com.prog32758;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Board {
	private int[][] board;
	private int moveCount;
	private int xPos, yPos;
	private ArrayList<Coordinates> moves = new ArrayList<>();
	Random r = new Random();
	
	public Board(int x, int y) {	//constructor; custom board start x,y
		board = new int[8][8];
		startBoard();
		moveCount = 1;
		board[x][y] = moveCount++;
		xPos = x;
		yPos = y;
	}
	
	public Board() {				//constructor; default board start 0,0
		board = new int[8][8];
		startBoard();
		moveCount = 1;
		board[0][0] = moveCount++;
		xPos = 0;
		yPos = 0;
	}
	
	public void startBoard(){				//initialize board values to zero
		for (int i = 0; i < 8; i++) {
			for (int x = 0; x < 8; x++) {
				board[i][x] = 0;
			}
		}
		
	}
	
	
	//getter setters
	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	
	public void recordMove(int x, int y){	//record a move; used by constructor
		board[x][y] = moveCount++;
		setxPos(x);
		setyPos(y);
	}
	
												//overloaded; used by moves()
	public void recordMove(Coordinates move) {
		board[move.getX()][move.getY()] = moveCount++;
		setxPos(move.getX());
		setyPos(move.getY());
	}
	
	
	public void printBoard() {							//basically a toString
		for (int i = 0; i < 8; i++) {
			for (int z = 0; z < 8; z++) {
//				System.out.print(board[i][z] + " ");
				System.out.print(String.format("%-4s", board[i][z]));
			}
			System.out.println();
		}
	}
	
	public boolean isAvailable(int x, int y) {			//is board position available?
		if (board[x][y] > 0)
			return false;
		else
			return true;
	}
	
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
		
		Iterator<Coordinates> i = moves.iterator();				//remove outofbounds coordinates
		while (i.hasNext()) {
			Coordinates moves = i.next();
			System.out.print("" + moves.getX() + " " + moves.getY() + "   "); 
			if (moves.getX() < 0 | moves.getY() < 0 | moves.getX() > 7 | moves.getY() > 7) {
				i.remove();
				System.out.println("Removed");
			}
		}
		
		Iterator<Coordinates> z = moves.iterator();				//verify availability
		while (z.hasNext()) {
			Coordinates moves = z.next();
			if (!isAvailable(moves.getX(), moves.getY())) {
				System.out.println(moves + "Unavailable");
				z.remove();
			}
		}
		
		System.out.println(moves.toString());					//show all possible moves(debug)
		
		Coordinates selected = moves.get(r.nextInt(moves.size()));	//choose random coordinate
		System.out.println(selected);
		return selected;
	}

}

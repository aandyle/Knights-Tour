package com.prog32758;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Board {
	private int[][] board;				// store board/move history
	private int moveCount;				// counts moves made
	private int xPos, yPos;				// coordinates
	private boolean canMove = true;		// moves available?
	private ArrayList<Coordinates> moves = new ArrayList<>();	// store potential coordinates
	Random r = new Random();
	
	// constructor; custom board start x,y
	public Board(int x, int y) {	
		board = new int[8][8];
		startBoard();
		moveCount = 1;
		board[x][y] = moveCount++;
		xPos = x;
		yPos = y;
	}

	public boolean isCanMove() {
		return canMove;
	}

	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
	}

	// initialize board values to zero
	public void startBoard(){				
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
	
	public int getMoveCount() {
		return moveCount;
	}

	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}
	
	// used by moves(); record move to board, update coordinates
	public void recordMove(Coordinates move) {
		if(canMove) {
			board[move.getX()][move.getY()] = moveCount++;
			setxPos(move.getX());
			setyPos(move.getY());
		}
	}
	
	//can disregard; basically a toString, prints to console for debugging purposes
	public void printBoard() {							
		for (int i = 0; i < 8; i++) {
			for (int z = 0; z < 8; z++) {
				System.out.print(String.format("%-4s", board[i][z]));
			}
			System.out.println();
		}
	}
	
	//overloaded of above; write to file
	public void printBoard(int iter, String mode) {		
		if("dumb".equals(mode)) {	// check if non-intelligent or intelligent to determine file name
			String path = "c:/temp/andyleNonIntelligentMethod.txt";
			try {
				FileWriter fw = new FileWriter(path,true);	// 'true' = append
			    fw.write("Trial " + iter + " : " + "The Knight was able to successfully touch " + (getMoveCount()-1) + " squares.\n");
			    fw.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {
			String path = "c:/temp/andyleIntelligentMethod.txt";
			try {
				FileWriter fw = new FileWriter(path,true);
			    fw.write("Trial " + iter + " : " + "The Knight was able to successfully touch " + (getMoveCount()-1) + " squares.\n");
			    fw.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	//returns the move# at a coordinate, used for jsp
	public int printMove(int x, int y) {				
		return board[x][y];
	}
	
	//is board position already moved to/available?
	public boolean isAvailable(int x, int y) {			
		if (board[x][y] > 0)
			return false;
		else
			return true;
	}

	// returns coordinates for a random move
	public Coordinates moves() {			
		moves.clear();
		moves = new ArrayList<>();
		
		Coordinates move1 = new Coordinates(xPos+2, yPos+1);	// calculated moves relative to position
		Coordinates move2 = new Coordinates(xPos+1, yPos+2);
		Coordinates move3 = new Coordinates(xPos-1, yPos+2);
		Coordinates move4 = new Coordinates(xPos-2, yPos+1);
		Coordinates move5 = new Coordinates(xPos-2, yPos-1);
		Coordinates move6 = new Coordinates(xPos-1, yPos-2);
		Coordinates move7 = new Coordinates(xPos+1, yPos-2);
		Coordinates move8 = new Coordinates(xPos+2, yPos-1);
		
		moves.addAll(Arrays.asList(move1,move2,move3,move4,move5,move6,move7,move8));	// add all moves to ArrayList
		
		Iterator<Coordinates> i = moves.iterator();				//remove outofbounds coordinates from ArrayList
		while (i.hasNext()) {
			Coordinates moves = i.next();
			if (moves.getX() < 0 | moves.getY() < 0 | moves.getX() > 7 | moves.getY() > 7) {
				i.remove();
			}
		}
		
		Iterator<Coordinates> z = moves.iterator();				//verify availability of coords inside ArrayList
		while (z.hasNext()) {
			Coordinates moves = z.next();
			if (!isAvailable(moves.getX(), moves.getY())) {
				z.remove();
			}
		}
		
		if (!moves.isEmpty()) {			// if there are moves to choose from...
			Coordinates selected = moves.get(r.nextInt(moves.size()));	//choose a random coordinate
			return selected;
		} else {
			setCanMove(false);
			return null;
		}
		
	}

}

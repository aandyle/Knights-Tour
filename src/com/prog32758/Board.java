package com.prog32758;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Board {
	private int[][] board;
	private int moveCount;
	private int xPos, yPos;
	private boolean canMove = true;
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
	
	// constructor; default board start 0,0
	public Board() {				
		board = new int[8][8];
		startBoard();
		moveCount = 1;
		board[0][0] = moveCount++;
		xPos = 0;
		yPos = 0;
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
	
	// overloaded; used by moves()
	public void recordMove(Coordinates move) {
		if(canMove) {
			board[move.getX()][move.getY()] = moveCount++;
			setxPos(move.getX());
			setyPos(move.getY());
		}
	}
	
	
	public void printBoard() {							//basically a toString
		for (int i = 0; i < 8; i++) {
			for (int z = 0; z < 8; z++) {
				System.out.print(String.format("%-4s", board[i][z]));
			}
			System.out.println();
		}
		
				
	}
	
	//write to file and output to console for debugging
	public void printBoard(int iter, String mode) {
		File f;
		for (int i = 0; i < 8; i++) {
			for (int z = 0; z < 8; z++) {
				System.out.print(String.format("%-4s", board[i][z]));
			}
			System.out.println();
		}
		
		if("dumb".equals(mode)) {
			String path = "c:/temp/andyleNonIntelligentMethod.txt";
			try {
				FileWriter fw = new FileWriter(path,true);
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
	
	public int printMove(int x, int y) {				//returns the move# at a coordinate, used for jsp
		return board[x][y];
	}
	
	public boolean isAvailable(int x, int y) {			//is board position available?
		if (board[x][y] > 0)
			return false;
		else
			return true;
	}

	// returns coordinates for a random move
	public Coordinates moves() {			
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
		
		Iterator<Coordinates> z = moves.iterator();				//verify availability of coord
		while (z.hasNext()) {
			Coordinates moves = z.next();
			if (!isAvailable(moves.getX(), moves.getY())) {
				System.out.println(moves + "Unavailable");
				z.remove();
			}
		}
		
		if (!moves.isEmpty()) {
			Coordinates selected = moves.get(r.nextInt(moves.size()));	//choose random coordinate
			System.out.println(selected);
			return selected;
		} else {
			setCanMove(false);
			return null;
		}
		
	}

}

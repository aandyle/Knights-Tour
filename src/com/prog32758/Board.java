package com.prog32758;

import java.util.Arrays;

public class Board {
	int[][] board;
	int moveCount;
	
	public Board(int x, int y) {	//custom board start x,y
		board = new int[8][8];
		startBoard();
		moveCount = 1;
		board[x][y] = moveCount++;
	}
	
	public Board() {				//default board start 0,0
		board = new int[8][8];
		startBoard();
		moveCount = 1;
		board[0][0] = moveCount++;
	}
	
	
	
	public void startBoard(){				//set board values to zero
		for (int i = 0; i < 8; i++) {
			for (int x = 0; x < 8; x++) {
				board[i][x] = 0;
			}
		}
	}
	
	public void recordMove(int x, int y){
		board[x][y] = moveCount++;
	}
	
	public void printBoard() {
		for (int i = 0; i < 8; i++) {
			for (int z = 0; z < 8; z++) {
				System.out.print(board[i][z] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean isAvailable(int x, int y) {
		if (board[x][y] > 0)
			return false;
		else
			return true;
	}
	
	
	
}

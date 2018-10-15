package com.prog32758;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

public class BoardIntelligent extends Board {
	private ArrayList<Coordinates> moves = new ArrayList<>();
	Random r = new Random();

	public BoardIntelligent(int x, int y) {
		super(x, y);
	}

	public BoardIntelligent() {
		super();
	}

	// heuristics board initialization
	private int[] r1 = new int[] { // row 0,7
			2, 3, 4, 4, 4, 4, 3, 2 };

	private int[] r2 = new int[] { // row 1,6
			3, 4, 6, 6, 6, 6, 4, 3 };

	private int[] r3 = new int[] { // row 2,3,4,5
			4, 6, 8, 8, 8, 8, 6, 4 };

	private int[][] heuristicBoard = new int[][] { r1, r2, r3, r3, r3, r3, r2, r1 };

	// match coordinates to respective heuristic values
	public void setHeuristic(Coordinates coord) {
		coord.setHeuristicRank(heuristicBoard[coord.getX()][coord.getY()]);
	}

	// check for best coordinates to move to
	public Coordinates bestCoordinate(ArrayList<Coordinates> coords) {
		Coordinates best = coords.get(0);
		
		ArrayList<Coordinates> bestMoves = new ArrayList<>();
		
		ListIterator<Coordinates> j = coords.listIterator();	//finds strongest heuristic rank
		while (j.hasNext()) {
			Coordinates coord = j.next();			
			if(j.hasPrevious()) {
				if(coord.getHeuristicRank() < best.getHeuristicRank()) {
					best = coord;
				}
			}
		}
				
		Iterator<Coordinates> e = coords.iterator();		//get all coords that match strongest Heuristic rank
		while (e.hasNext()) {								//	and add to ArrayList bestMoves
			Coordinates coord = e.next();
			if (coord.getHeuristicRank() == best.getHeuristicRank()) {
				bestMoves.add(coord);
				System.out.println(coord);
			}
		}		
		
		return bestMoves.get(r.nextInt(bestMoves.size()));	//select random coordinate from ArrayList bestMoves
	}

	@Override // instead of random moves, checks heuristics via bestCoordinate method
	public Coordinates moves() { // returns coordinates for a random move
		moves.clear();
		moves = new ArrayList<>();	// Store all possible moves

		Coordinates move1 = new Coordinates(getxPos() + 2, getyPos() + 1);
		Coordinates move2 = new Coordinates(getxPos() + 1, getyPos() + 2);
		Coordinates move3 = new Coordinates(getxPos() - 1, getyPos() + 2);
		Coordinates move4 = new Coordinates(getxPos() - 2, getyPos() + 1);
		Coordinates move5 = new Coordinates(getxPos() - 2, getyPos() - 1);
		Coordinates move6 = new Coordinates(getxPos() - 1, getyPos() - 2);
		Coordinates move7 = new Coordinates(getxPos() + 1, getyPos() - 2);
		Coordinates move8 = new Coordinates(getxPos() + 2, getyPos() - 1);

		moves.addAll(Arrays.asList(move1, move2, move3, move4, move5, move6, move7, move8));

		Iterator<Coordinates> i = moves.iterator();		//eliminate any coordinates that are out of bounds
		while (i.hasNext()) {
			Coordinates moves = i.next();
			System.out.print("" + moves.getX() + " " + moves.getY() + "   ");
			if (moves.getX() < 0 | moves.getY() < 0 | moves.getX() > 7 | moves.getY() > 7) {
				i.remove();
			}
		}

		Iterator<Coordinates> z = moves.iterator();		//eliminate any coordinates that have already been landed on
		while (z.hasNext()) {
			Coordinates moves = z.next();
			if (!isAvailable(moves.getX(), moves.getY())) {
				System.out.println(moves + " REMOVED");		//DEBUG
				z.remove();
			}
		}
		
		System.out.println("CANDIDATE MOVES");
		//DEBUG
		Iterator<Coordinates> l = moves.iterator();	
		while (l.hasNext()) {
			Coordinates moves = l.next();
			System.out.println(moves);
		}
		

		Iterator<Coordinates> j = moves.iterator();		//determine heuristic values for each coordinate
		while (j.hasNext()) {
			Coordinates moves = j.next();
			setHeuristic(moves);
		}
		
		if (!moves.isEmpty()) {
			return bestCoordinate(moves);	//return the next best coordinate to go to via bestCoordinate method
		} else {
			setCanMove(false);
			return null;
		}
	}
}

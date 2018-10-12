package com.prog32758;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class BoardIntelligent extends Board {
//	private int[][] board;
//	private int moveCount;
//	private int getxPos(), getyPos();
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

	// hard-code heuristics map into 2d array ------------------------------ DONE
	// match available coordinates with heuristics map values ------------------
	// use HashMap to store custom class Coordinate(Key) with heuristic map(value)
	// determine lowest heuristic values, discard the rest of HashMap
	// randomly select one from the Map

	public void setHeuristic(Coordinates coord) {
//		System.out.println("Set heuristic: " + );
		coord.setHeuristicRank(heuristicBoard[coord.getX()][coord.getY()]);
	}

	// check for best move
	public Coordinates bestCoordinate(ArrayList<Coordinates> coords) {
		Coordinates prev = coords.get(0);
		Coordinates best = coords.get(0);
		ArrayList<Coordinates> bestMoves = new ArrayList<>();
		
		//find strongest heuristic rank
		Iterator<Coordinates> j = moves.iterator();
		while (j.hasNext()) {
			Coordinates moves = j.next();
			System.out.println("Heuristic value of " + moves + " is " + moves.getHeuristicRank());
			if (moves.getHeuristicRank() < prev.getHeuristicRank()) {
				prev = best;
				best = moves;
			}
		}
		System.out.println("Best heuristic rank is: " + best.getHeuristicRank());
		
		//get all coords that match best Heuristic rank
		Iterator<Coordinates> e = moves.iterator();
		while (e.hasNext()) {
			Coordinates moves = e.next();
			if (moves.getHeuristicRank() == best.getHeuristicRank()) {
				bestMoves.add(moves);
				System.out.print(moves.getHeuristicRank());
			}
		}
		
		//DEBUG candidate coords
		System.out.print("Candidate coords: ");
		Iterator<Coordinates> ee = bestMoves.iterator();
		while (ee.hasNext()) {
			Coordinates moves = ee.next();
			System.out.print(moves + " ");
		}
		
		//select random move
		best = bestMoves.get(r.nextInt(bestMoves.size()));
		System.out.println("Next best move is: " + best);
		return best;
	}

	@Override // instead of random, checks heuristics
	public Coordinates moves() { // returns coordinates for a random move
		moves.clear();
		moves = new ArrayList<>();

		Coordinates move1 = new Coordinates(getxPos() + 2, getyPos() + 1);
		Coordinates move2 = new Coordinates(getxPos() + 1, getyPos() + 2);
		Coordinates move3 = new Coordinates(getxPos() - 1, getyPos() + 2);
		Coordinates move4 = new Coordinates(getxPos() - 2, getyPos() + 1);
		Coordinates move5 = new Coordinates(getxPos() - 2, getyPos() - 1);
		Coordinates move6 = new Coordinates(getxPos() - 1, getyPos() - 2);
		Coordinates move7 = new Coordinates(getxPos() + 1, getyPos() - 2);
		Coordinates move8 = new Coordinates(getxPos() + 2, getyPos() - 1);

		moves.addAll(Arrays.asList(move1, move2, move3, move4, move5, move6, move7, move8));

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

		System.out.println(moves.toString()); // show all possible moves;debug

		// determine heuristic values for each coordinate
		Iterator<Coordinates> j = moves.iterator();
		while (j.hasNext()) {
			Coordinates moves = j.next();
			setHeuristic(moves);
		}

		return bestCoordinate(moves);
	}

}

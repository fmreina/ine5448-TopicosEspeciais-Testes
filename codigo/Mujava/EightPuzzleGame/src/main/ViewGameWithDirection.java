package main;

import java.io.*;

import domain.ShufflePuzzleLevelHard;
import domain.ShufflePuzzleLevelEasy;
import domain.ShufflePuzzleLevelMedium;
import domain.Puzzle;
import domain.PuzzleGame;
import domain.Puzzle.Direction;

public class ViewGameWithDirection {

	public static void main(String[] args){
	try{
		System.out.println("Enter the difficulty of the level game (1-easy 2-medium 3-hard): ");
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		String entry = input.readLine();
		Puzzle game;
		if (entry.equals("1"))
			game = new PuzzleGame(3, new ShufflePuzzleLevelEasy());
		else 
			if (entry.equals("2"))
				game = new PuzzleGame(3, new ShufflePuzzleLevelMedium());
			else 
				game = new PuzzleGame(3, new ShufflePuzzleLevelHard());
		System.out.println(game);
		System.out.println();
		entry = "";
		while (!game.endOfTheGame() && !entry.equals("end")) {
			System.out.println("Enter the letter of the direction (w-up a-left s-down d-right): ");
			entry = input.readLine();
			System.out.println();
			if (!entry.equals("end")){
				if (entry.equals("w"))
					game.moveEmptyCell(Direction.UP);
				if (entry.equals("a"))
					game.moveEmptyCell(Direction.LEFT);
				if (entry.equals("s"))
					game.moveEmptyCell(Direction.DOWN);
				if (entry.equals("d"))
					game.moveEmptyCell(Direction.RIGHT);
				System.out.println(game);
				System.out.println();
			}
		}
		System.out.println("The end.");
	}
	catch 
		(Exception e) { e.printStackTrace();}

	}
	
	
}

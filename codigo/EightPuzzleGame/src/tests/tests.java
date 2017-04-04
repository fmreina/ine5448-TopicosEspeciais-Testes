package tests;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;

import domain.Puzzle;
import domain.PuzzleGame;
import domain.ShufflePuzzleLevelEasy;
import domain.ShufflePuzzleLevelHard;
import domain.ShufflePuzzleLevelMedium;
import domain.Puzzle.Direction;

public class tests {

	
	@Test
	public void putTilesTest(){
		int dimension = 3;
		ShufflePuzzleLevelTest shuffler = new ShufflePuzzleLevelTest();
		
		PuzzleGame game = new PuzzleGame(dimension, shuffler);
		
	}
	
	@Test
	public void moveEmptyCellTest(){
		
	}
	
//	public static void main(String[] args){
//		Puzzle game = new PuzzleGame(3, new ShufflePuzzleLevelTest());
//		System.out.println(game);
//	}
}


/*
 * Testar:
 * 
 * putTilesInTheBoard()
 * moveEmptyCell()
 * */


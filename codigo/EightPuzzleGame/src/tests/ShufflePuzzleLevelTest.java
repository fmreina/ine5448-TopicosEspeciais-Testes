package tests;

import java.util.Random;

import domain.Puzzle;
import domain.StrategyShufflePuzzle;
import domain.Puzzle.Direction;

public class ShufflePuzzleLevelTest implements StrategyShufflePuzzle {

	public ShufflePuzzleLevelTest(){
		
	}
	
	@Override
	public void shuffle(Puzzle game) {
		game.moveEmptyCell(Direction.UP);
		game.moveEmptyCell(Direction.LEFT);
	}

}

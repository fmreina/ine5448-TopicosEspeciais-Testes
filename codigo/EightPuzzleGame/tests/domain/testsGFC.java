package domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import domain.Position;
import domain.PuzzleGame;
import domain.SquareBoard;
import domain.Tile;
import domain.Puzzle.Direction;

public class testsGFC {

	@Test
	public void moveUpTest(){
		int dimension = 3;
		PuzzleGame game = new PuzzleGame(3, new ShufflePuzzleLevelTest());
		
		SquareBoard board = game.getBoard();
		
//		Tile tile = new Tile(number)

		
		//
		//Position startPosition = game.readEmptyCellPosition();
		//game.moveEmptyCell(Direction.UP);
		//Position endPosition = game.readEmptyCellPosition();
		//
		//assertEquals(endPosition.getLine(),startPosition.getLine()-1);
	}
}


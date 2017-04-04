package tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import domain.Position;
import domain.SquareBoard;
import domain.Tile;
import domain.Puzzle.Direction;
import domain.PuzzleGame;

public class tests {

	@Test
	public void putTilesInTheBoardTest(){
//		int dimension = 3;
//		SquareBoard board = new SquareBoard(dimension);
//		List<Tile> listOfTiles = this.generateListOfTiles (dimension*dimension-1);
//		board.putTilesInTheBoard (board, listOfTiles);
		
//		int dimension = 3;
//		ShufflePuzzleLevelTest shuffler = new ShufflePuzzleLevelTest();
//		
//		PuzzleGame game = new PuzzleGame(dimension, shuffler);
//		game.
		
	}
	
	@Test
	public void moveUpEmptyCellTest(){
		PuzzleGame game = new PuzzleGame(3, new ShufflePuzzleLevelTest());
		
		Position startPosition = game.readEmptyCellPosition();
		game.moveEmptyCell(Direction.UP);
		Position endPosition = game.readEmptyCellPosition();
		
		assertEquals(endPosition.getLine(),startPosition.getLine()-1);
	}
	
	@Test
	public void moveDownEmptyCellTest(){
		PuzzleGame game = new PuzzleGame(3, new ShufflePuzzleLevelTest());
		
		Position startPosition = game.readEmptyCellPosition();
		game.moveEmptyCell(Direction.DOWN);
		Position endPosition = game.readEmptyCellPosition();
		
		assertEquals(endPosition.getLine(),startPosition.getLine()+1);
	}

	@Test
	public void moveLeftEmptyCellTest(){
		PuzzleGame game = new PuzzleGame(3, new ShufflePuzzleLevelTest());
		
		Position startPosition = game.readEmptyCellPosition();
		game.moveEmptyCell(Direction.LEFT);
		Position endPosition = game.readEmptyCellPosition();
		
		assertEquals(endPosition.getColumn(),startPosition.getColumn()-1);
	}
	
	@Test
	public void moveRightEmptyCellTest(){
		PuzzleGame game = new PuzzleGame(3, new ShufflePuzzleLevelTest());
		
		Position startPosition = game.readEmptyCellPosition();
		game.moveEmptyCell(Direction.RIGHT);
		Position endPosition = game.readEmptyCellPosition();
		
		assertEquals(endPosition.getColumn(),startPosition.getColumn()+1);
	}
}

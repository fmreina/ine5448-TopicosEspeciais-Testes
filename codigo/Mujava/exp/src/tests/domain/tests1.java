package domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import domain.Puzzle.Direction;

public class tests1 {

	@Test
	public void putTilesInTheBoardTest(){
		int dimension = 3;
		ShufflePuzzleLevelTest shuffler = new ShufflePuzzleLevelTest();
		PuzzleGame game = new PuzzleGame(dimension, shuffler);

		SquareBoard board = new SquareBoard(2);
		
		List<Tile> listOfTiles = new ArrayList<Tile>();
		listOfTiles.add(new Tile(1));
		listOfTiles.add(new Tile(2));
		listOfTiles.add(new Tile(3));
		// last Tile is always empty
		
		game.putTilesInTheBoard(board, listOfTiles);

		assertEquals(listOfTiles.get(0), board.getTile(new Position(1, 1)));
		assertEquals(listOfTiles.get(1), board.getTile(new Position(1, 2)));
		assertEquals(listOfTiles.get(2), board.getTile(new Position(2, 1)));
		
		game.putTilesInTheBoard(board, listOfTiles);
		
	}
	
	@Test
	public void moveUpEmptyCellTest(){
		PuzzleGame game = new PuzzleGame(3, new ShufflePuzzleLevelTest());
		
		Position startPosition = game.emptyCell;
		game.moveEmptyCell(Direction.UP);
		Position endPosition = game.emptyCell;
		
		assertEquals(endPosition.getLine(),startPosition.getLine()-1);
	}
	
	@Test
	public void moveDownEmptyCellTest(){
		PuzzleGame game = new PuzzleGame(3, new ShufflePuzzleLevelTest());
		
		Position startPosition = game.emptyCell;
		game.moveEmptyCell(Direction.DOWN);
		Position endPosition = game.emptyCell;
		
		assertEquals(endPosition.getLine(),startPosition.getLine()+1);
	}

	@Test
	public void moveLeftEmptyCellTest(){
		PuzzleGame game = new PuzzleGame(3, new ShufflePuzzleLevelTest());
		
		Position startPosition = game.emptyCell;
		game.moveEmptyCell(Direction.LEFT);
		Position endPosition = game.emptyCell;
		
		assertEquals(endPosition.getColumn(),startPosition.getColumn()-1);
	}
	
	@Test
	public void moveRightEmptyCellTest(){
		PuzzleGame game = new PuzzleGame(3, new ShufflePuzzleLevelTest());
		
		Position startPosition = game.emptyCell;
		game.moveEmptyCell(Direction.RIGHT);
		Position endPosition = game.emptyCell;
		
		assertEquals(endPosition.getColumn(),startPosition.getColumn()+1);
	}
}

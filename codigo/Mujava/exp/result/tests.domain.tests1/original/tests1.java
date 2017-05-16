// This is a mutant program.
// Author : ysma

package domain;


import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import domain.Puzzle.Direction;


public class tests1
{

    public  void putTilesInTheBoardTest()
    {
        int dimension = 3;
        domain.ShufflePuzzleLevelTest shuffler = new domain.ShufflePuzzleLevelTest();
        domain.PuzzleGame game = new domain.PuzzleGame( dimension, shuffler );
        domain.SquareBoard board = new domain.SquareBoard( 2 );
        java.util.List<Tile> listOfTiles = new java.util.ArrayList<Tile>();
        listOfTiles.add( new domain.Tile( 1 ) );
        listOfTiles.add( new domain.Tile( 2 ) );
        listOfTiles.add( new domain.Tile( 3 ) );
        game.putTilesInTheBoard( board, listOfTiles );
        assertEquals( listOfTiles.get( 0 ), board.getTile( new domain.Position( 1, 1 ) ) );
        assertEquals( listOfTiles.get( 1 ), board.getTile( new domain.Position( 1, 2 ) ) );
        assertEquals( listOfTiles.get( 2 ), board.getTile( new domain.Position( 2, 1 ) ) );
        game.putTilesInTheBoard( board, listOfTiles );
    }

    public  void moveUpEmptyCellTest()
    {
        domain.PuzzleGame game = new domain.PuzzleGame( 3, new domain.ShufflePuzzleLevelTest() );
        domain.Position startPosition = game.emptyCell;
        game.moveEmptyCell( Direction.UP );
        domain.Position endPosition = game.emptyCell;
        assertEquals( endPosition.getLine(), startPosition.getLine() - 1 );
    }

    public  void moveDownEmptyCellTest()
    {
        domain.PuzzleGame game = new domain.PuzzleGame( 3, new domain.ShufflePuzzleLevelTest() );
        domain.Position startPosition = game.emptyCell;
        game.moveEmptyCell( Direction.DOWN );
        domain.Position endPosition = game.emptyCell;
        assertEquals( endPosition.getLine(), startPosition.getLine() + 1 );
    }

    public  void moveLeftEmptyCellTest()
    {
        domain.PuzzleGame game = new domain.PuzzleGame( 3, new domain.ShufflePuzzleLevelTest() );
        domain.Position startPosition = game.emptyCell;
        game.moveEmptyCell( Direction.LEFT );
        domain.Position endPosition = game.emptyCell;
        assertEquals( endPosition.getColumn(), startPosition.getColumn() - 1 );
    }

    public  void moveRightEmptyCellTest()
    {
        domain.PuzzleGame game = new domain.PuzzleGame( 3, new domain.ShufflePuzzleLevelTest() );
        domain.Position startPosition = game.emptyCell;
        game.moveEmptyCell( Direction.RIGHT );
        domain.Position endPosition = game.emptyCell;
        assertEquals( endPosition.getColumn(), startPosition.getColumn() + 1 );
    }

}

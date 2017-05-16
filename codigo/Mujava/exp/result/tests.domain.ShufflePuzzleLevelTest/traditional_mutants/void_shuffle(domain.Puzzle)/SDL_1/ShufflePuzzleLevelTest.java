// This is a mutant program.
// Author : ysma

package domain;


import java.util.Random;
import domain.Puzzle;
import domain.StrategyShufflePuzzle;
import domain.Puzzle.Direction;


public class ShufflePuzzleLevelTest implements domain.StrategyShufflePuzzle
{

    public ShufflePuzzleLevelTest()
    {
    }

    public  void shuffle( domain.Puzzle game )
    {
        game.moveEmptyCell( Direction.LEFT );
    }

}

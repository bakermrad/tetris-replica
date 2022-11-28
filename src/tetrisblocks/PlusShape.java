package tetrisblocks;
import static java.awt.Color.red;
import tetris.TetrisBlock;
public class PlusShape extends TetrisBlock  {
    public PlusShape(){
    // a unique shape that only spawns when the queue is bugging out with duplicate
    //blocks, thus turning a bug into a feature
        super( new int [][]{{0,1,0},{1,1,1},{0,1,0}} );
        super.color = red;
    }
}
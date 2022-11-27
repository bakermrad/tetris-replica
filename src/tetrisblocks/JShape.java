package tetrisblocks;
import static java.awt.Color.MAGENTA;
import tetris.TetrisBlock;
public class JShape extends TetrisBlock {
//    building a simple block using 2d array for a Grid System and using  0's and 1's to specify if the cell is colored or not
    public JShape(){
    super( new int [][]{{0,1},{0,1},{1,1}} );
    super.color = MAGENTA;
    }
    
}

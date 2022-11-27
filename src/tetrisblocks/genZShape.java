package tetrisblocks;
import static java.awt.Color.red;
import tetris.TetrisBlock;
public class genZShape extends TetrisBlock  {
    public genZShape(){
        super( new int [][]{{1,1,1},{0,1,0},{1,1,1}} );
        super.color = red;
    }
}



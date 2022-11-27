package tetrisblocks;
import static java.awt.Color.yellow;
import tetris.TetrisBlock;
public class OShape extends TetrisBlock {
    public OShape(){
    super( new int [][]{{1,1},
                        {1,1}} );
    super.color = yellow;
    }
}


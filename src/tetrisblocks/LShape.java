package tetrisblocks;
import static java.awt.Color.CYAN;
import tetris.TetrisBlock;
public class LShape extends TetrisBlock {
    public LShape(){
        super( new int [][]{{1,0},
                            {1,0},
                            {1,1}} );
        super.color = CYAN;
    }
}

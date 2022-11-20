
package tetrisblocks;

import static java.awt.Color.*;
import tetris.TetrisBlock;


public class TShape extends  TetrisBlock {
    
    public TShape(){
        super( new int [][]{{1,1,1},
                             {0,1,0}} );
        super.color = green;
    }
}
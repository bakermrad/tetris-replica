package tetris;
import java.util.*;
import javax.swing.*;
import tetrisblocks.*;


/**
 *
 * @author baker
 */
public class SwapBlocks{
        private TetrisBlock[] blocks = new TetrisBlock[]{new IShape(),
        new JShape(),
        new OShape(),
        new SShape(),
        new ZShape(),
        new LShape(),
        new TShape()
        
        };
    
        Queue<TetrisBlock> queue = new LinkedList<TetrisBlock>();

    
    
    public SwapBlocks(){
        Random r = new Random();
        TetrisBlock block = blocks[r.nextInt(blocks.length) ];
        queue.add(block);

    }
    public void insertBlock(){
        Random r = new Random();
        TetrisBlock block = blocks[r.nextInt(blocks.length) ];
        queue.add(block);
    }
    
    public TetrisBlock returnblock(){
    return queue.remove();
    }
    
    

    
}

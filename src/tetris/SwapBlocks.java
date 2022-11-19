package tetris;
import java.util.*;
import javax.swing.*;
import tetrisblocks.*;
import bst.Tree;

/**
 *
 * @author baker
 */
public class SwapBlocks{
        private Tree blocks;
    
        Queue<TetrisBlock> queue = new LinkedList<TetrisBlock>();
        

    
    
    public SwapBlocks(){
        blocks = new Tree();
        blocks.insertAll();
        TetrisBlock block = blocks.getRandomBlock();
        TetrisBlock block2 = blocks.getRandomBlock();
        queue.add(block);
        queue.add(block2);
    }
    public void insertBlock(){
        //blocks = new Tree();
        //blocks.insertAll();
        TetrisBlock block = blocks.getRandomBlock();
        queue.add(block);
        System.out.println(queue.size());
    }
    
    public void insertBlock(TetrisBlock b){
        queue.add(b);
    }
    
    
    public TetrisBlock returnblock(){
    return queue.remove();
    }
    
    

    
}

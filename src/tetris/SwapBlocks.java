package tetris;

import bst.Tree;
import queue.*;

/**
 *
 * @author baker
 */
public class SwapBlocks {

    private final Tree blocks = new Tree();
    private final queue blocksqueue = new queue();

    public SwapBlocks() {
        TetrisBlock block = blocks.getRandomBlock();
        TetrisBlock block2 = blocks.getRandomBlock();
        blocksqueue.insert(block);
        blocksqueue.insert(block2);
        blocksqueue.removeduplicate();
    }

    public TetrisBlock insertBlockSwap() {
        TetrisBlock block = blocks.getRandomBlock();
        blocksqueue.insert(block);
        return block;
    }

    public void insertBlock() {
        TetrisBlock block = blocks.getRandomBlock();
        blocksqueue.insert(block);
    }

    public void insertBlock(TetrisBlock b) {
        blocksqueue.insert(b);
    }

    public TetrisBlock returnblock() {
        return blocksqueue.remove();
    }

}

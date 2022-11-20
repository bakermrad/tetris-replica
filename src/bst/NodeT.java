package bst;

import tetris.TetrisBlock;

public class NodeT{
    int index;
    TetrisBlock data;
    NodeT left;
    NodeT right;
    public NodeT(int i,TetrisBlock a){
        data=a;
        index = i;
    }
}


package bst;

import tetris.TetrisBlock;

public class Node{
    int index;
    TetrisBlock data;
    Node left;
    Node right;
    public Node(int i,TetrisBlock a){
        data=a;
        index = i;
    }
}


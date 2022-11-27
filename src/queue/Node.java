package queue;
import tetris.TetrisBlock;
public class Node {
    TetrisBlock data;
    Node next;
    public Node(TetrisBlock a){
        this.data = a;
        next = null;
    }
}

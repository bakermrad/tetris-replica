package bst;
import tetris.TetrisBlock;
import stack.Stack;
import tetrisblocks.*;
public class Tree {
  protected NodeT root;
  protected Stack randomPool;
  public Tree(){
      root=null;
      randomPool=new Stack();
      insertAll();
      //randomPool.shuffle();
  }
  public void insertNode(int key, TetrisBlock a) {
    root = insertNode(key, a, root);
  }
  NodeT insertNode(int key, TetrisBlock a, NodeT node) {
    if (node == null) {
      node = new NodeT(key,a);
    }
    else if (key <= node.index) {
      node.left = insertNode(key, a, node.left);
    } else if (key > node.index) {
      node.right = insertNode(key, a, node.right);
    }
    return node;
  }
  public NodeT searchNode(int key) {
    return searchNode(key, root);
  }

  private NodeT searchNode(int key, NodeT node) {
    if (node == null) {
      return new NodeT(3,new TShape()); //frequency test for shuffle not working
    }
    if (key == node.index) {
      return node;
    } else if (key < node.index) {
      return searchNode(key, node.left);
    } else {
      return searchNode(key, node.right);
    }
  }
  public final void insertAll(){
      insertNode(3,new TShape());
      insertNode(5,new ZShape());
      insertNode(1,new SShape());
      insertNode(6,new LShape());
      insertNode(2,new IShape());
      insertNode(4,new OShape());
      insertNode(0,new JShape());
      insertNode(7,new JShape());
      randomPool.pushAll();
      //inserting shapes in a specific order to make
      // a balanced binary search tree (optimal)
  }
  public TetrisBlock getRandomBlock(){
      randomPool.shuffle();
      int l = randomPool.pop();
      NodeT found = searchNode(l);
      randomPool.push(l);
      return found.data;
    }
}

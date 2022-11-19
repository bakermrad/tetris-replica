package bst;
import tetris.TetrisBlock;
import tetrisblocks.*;
import java.util.Random;
public class Tree {
  protected Node root;
  public Tree(){
      root=null;
  }
  public void insertNode(int key, TetrisBlock a) {
    root = insertNode(key, a, root);
  }
  Node insertNode(int key, TetrisBlock a, Node node) {
    if (node == null) {
      node = new Node(key,a);
    }
    else if (key <= node.index) {
      node.left = insertNode(key, a, node.left);
    } else if (key > node.index) {
      node.right = insertNode(key, a, node.right);
    }
    return node;
  }
  public Node searchNode(int key) {
    return searchNode(key, root);
  }

  private Node searchNode(int key, Node node) {
    if (node == null) {
      return null;
    }

    if (key == node.index) {
      return node;
    } else if (key < node.index) {
      return searchNode(key, node.left);
    } else {
      return searchNode(key, node.right);
    }
  }
  public void insertAll(){
      insertNode(5,new ZShape());
      insertNode(3,new TShape());
      insertNode(6,new LShape());
      insertNode(2,new IShape());
      insertNode(4,new OShape());
      insertNode(1,new SShape());
      insertNode(0,new JShape());
  }
  public TetrisBlock getRandomBlock(){
      Random block = new Random();
      int i = block.nextInt(7);
      Node found = searchNode(i);
      if(found!=null){
          return found.data;
      }
      return new TShape();//frequency test for search function returning null
  }
}

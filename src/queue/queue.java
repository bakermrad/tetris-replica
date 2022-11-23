/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue;

import tetris.TetrisBlock;
import tetrisblocks.*;

/**
 *
 * @author baker mrad
 */
public class queue {
    Node first;
    public queue(){
        first=null;
    }
    public boolean isEmpty(){
        return (first==null);
    }
    public void insert(TetrisBlock a){
        if(isEmpty()){
            first = new Node(a);
            return;
        }
        Node b = first;
        while(b.next!=null){
            b=b.next;
        }
        b.next = new Node(a);
    }
    public TetrisBlock remove(){
        if(isEmpty()){
            return new genZShape();
        }
        Node a = first;
        first=a.next;
        return a.data;
    }
    
//    public void insert(TetrisBlock t){
//        Node n = new Node(t);
//        if(isEmpty()){
//            bottom = n;
//        }else{
//            Node temp = bottom;
//            while(temp.prev!= null){
//                temp = temp.prev;
//            }
//            top = n;
//            temp.prev= n;
//        }
//    }
//    
//    public TetrisBlock remove(){
//        if(!isEmpty()){
//            TetrisBlock toReturn = top.data;
//            Node temp = bottom;
//            while(temp.prev!=top){
//                temp = temp.prev;
//            }
//            top = temp;
//            return toReturn;
//        }
//        TetrisBlock a = new genZShape();
//        return a;
//    }
    //public TetrisBlock peek(){
      //  return top.data;
    //}
    
    
    
}

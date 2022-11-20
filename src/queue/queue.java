/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue;

import tetris.TetrisBlock;

/**
 *
 * @author baker mrad
 */
public class queue {
    Node top,bottom;
    public queue(){
        top = null;
    }
    
       
    public boolean isEmpty(){
        return top==null;
    }
    
    public void insert(TetrisBlock t){
        Node n = new Node(t);
        if(isEmpty()){
            top=n;
        }else{
            Node temp = top;
            while(temp.next!= null){
                temp = temp.next;
                n.next = top;
                top = n;
            }
            temp.next = n;
        }
    }
    
    public TetrisBlock remove(){
        if(!isEmpty()){
            Node temp = top;
            top = top.next;
            return temp.data;
        }
        return null;
    }
    public TetrisBlock peek(){
        return top.data;
    }
    
    
    
}

package stack;
import java.util.Random;
public class Stack {
    NodeS top;
    int size;
    public Stack(){
        top = null;
        size=0;
    }
    public boolean isEmpty(){
        return(top==null);
    }
    public int getSize(){
        return size;
    }
    public void push(int a){
        NodeS b = new NodeS(a);
        if(isEmpty()){
            top = b;
            size++;
            return;
        }
        NodeS iterate = top;
        while(iterate.next!=null){
            iterate = iterate.next;
        }
        iterate.next = b;
        size++;
    }
    public int pop(){
        if(!isEmpty()){
            NodeS l = top;
            top = top.next;
            size--;
            return l.data;
        }
        return -1;
    }
    public void pushAll(){
        for(int i=0;i<7;i++){
            push(i);
        }
    }
    public void shuffle(){
        //a method that will somewhat randomize the order of numbers in the stack
        if(!isEmpty()){
            Stack recover = new Stack();
            Random rng = new Random();
            int hold = pop();
            int r = rng.nextInt(1,6);
            for(int j = 0; j < r; j++){
                recover.push(pop());
            }
            push(hold);
            for(int j = 0; j < r; j++){
                push(recover.pop());
            }
        }
    }
}

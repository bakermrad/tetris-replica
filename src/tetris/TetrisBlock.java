
package tetris;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author baker
 */
public class TetrisBlock {
//    every block well have a 2d array as it's shape
    private int[][] shape;
//    Then we are giving it a color using the Color class
    private Color color;
    private int x,y;
    private int currentRotation;
    private int[][][] shapes;
    private Color[] availableColors = {Color.CYAN,Color.blue, Color.red, Color.green};
    
    public TetrisBlock(int [] [] shape)
    {
        this.shape=shape;
        initShapes();
    }
    
    
//    All the setter's and getter's
    public int getHeight(){
        //This will return the length of the block
        return shape.length;
    }
    public int getWidth(){
        //This will return the width of the block
        return shape[0].length;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public void setX(int newX){ x = newX;}
    public void setY(int newY){ y = newY;}
    
    
    
    private void initShapes()
    {
        shapes = new int[4][][];
        for (int i = 0; i < 4; i++) {
            
            int r = shape[0].length;
            int c = shape.length; 
            shapes[i]=new int[r][c];
            
            
            for (int y = 0; y < r; y++) {
                for (int x = 0; x < c; x++) {
                    shapes[i][y][x] = shape[c - x - 1][y];
                }
            }
            shape = shapes[i];
        }
    }
    public void spawn(int gridWidth){
        Random r = new Random(); 
        currentRotation = r.nextInt(shapes.length);
        shape = shapes[currentRotation];
        //The Block has to start always at the top
        y= -getHeight();
        //making the block spawn in a random x position
        x= r.nextInt(gridWidth - getWidth());
        color = availableColors[ r.nextInt(shapes.length)];
    }
     public int[][] getShape(){return shape;}
     public Color getColor()
     {
             return color;
     } 
    public void moveDown()
    {
        y++;
    }
    public void moveleft()
    {
        x--;
    }
    public void moveRight()
    {
        x++;
    }
    
    public void rotate()
    {
        currentRotation++;
        if(currentRotation > 3){currentRotation=0;}
        shape = shapes[currentRotation];
    }
    
    
    
    public int getBottomEdge(){
    return y+getHeight();
    }
    
    public int getLeftEdge(){
    return x;
    }
     public int getRightEdge(){
    return x + getWidth();
    }
    
}

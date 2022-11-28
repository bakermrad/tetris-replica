 package tetris;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import bst.Tree;
public class GameArea extends JPanel {
    
        private final int gridRows;
        private final int gridColumns;
        private final int gridCellSize;
        private Color[][] background;
        TetrisBlock block ;
        private final Tree blocks ;
        private final SwapBlocks sc ;
        
        public GameArea(JPanel placeholder , int columns,SwapBlocks sc)
    {
        this.sc =sc;
//        Size and looks

        //we are setting the size accourding to the place holder we created in the GameForm and using its getBounds() to get the size.
        this.setBounds(placeholder.getBounds());
        //Then we are using its background color so it's easier to change from the place horlder
        this.setBackground(placeholder.getBackground());
        //Then we setting its border color to the same one in the place holder
        this.setBorder(placeholder.getBorder());
        
//      The Grid System

        //The size of each grid Cell is equal to (size of each side = Gamearea.width / number of colomns)
        //and (number of cells = Gamearea.height / size of each side )
        gridColumns = columns;
        gridCellSize = this.getBounds().width/ gridColumns;
        gridRows = this.getBounds().height  / gridCellSize;
        
        blocks = new Tree();
        blocks.insertAll();
    }
        
//      Painting our Srid System anf The Blocks
        @Override
        protected void paintComponent(Graphics g)
        {
           super.paintComponent(g);
           drawBackground(g);
           drawBlock(g);
           //Painted the Grid System based on the grid cell size.
            for (int i = 0; i < gridRows; i++) {
                for (int j = 0; j < gridColumns; j++) {
                    g.drawRect(j* gridCellSize, i*gridCellSize, gridCellSize, gridCellSize);
                }
                
            }

        }
        
        public void swapBlock(){
         TetrisBlock tc = sc.returnblock();
         sc.insertBlock(tc);   
        }
//      Spawing a new random Block
        public void spawnBlock(){
            
        TetrisBlock tc = sc.returnblock();
        block = tc;
        sc.insertBlock();
        block.spawn(gridColumns);

        }
        
        
//      Drawing our blocks
        private void drawGridSquare(Graphics g, Color color, int x, int y){
            g.setColor(color);
            g.fillRect(x,y, gridCellSize, gridCellSize);
            g.setColor(Color.BLACK);
            g.drawRect(x,y, gridCellSize, gridCellSize);
        }
        private void drawBlock(Graphics g)
        {
            
            int h = block.getHeight();
            int w =  block.getWidth();
            Color c = block.getColor();
            int [][] shape = block.getShape();
            for (int row = 0; row < h; row++) {
                for (int col = 0; col <w; col++) {
                   //Check if we have to draw the cell
                    if (shape[row][col] == 1) 
                    {
                        //Calculating the X and Y positions
                        int x = (block.getX() + col) * gridCellSize;
                        int y = (block.getY() + row) * gridCellSize;
                        //Calling the drawGridSquare method to draw the Block 
                        drawGridSquare( g,  c,  x,  y);
                    }
                }
            }
        }
        public void initBackgroundArray()
        {
            background = new Color[gridRows][gridColumns];

        }
        

        
        public boolean isBlockPutOfBounds()
        {
            if(block.getY() <0){
                block = null;
            return true;
            }
            return false;
        }
        
//      Moving the block Down 
        public boolean moveBlockDown()
        {
            if ( checkBottom()==false) {
             
                return false;
            }
            block.moveDown();
            repaint();
            return true;
        }
          
//      Checking if the block is touching the bottom of the grid         
        private boolean checkBottom(){
                if(block.getBottomEdge() == gridRows){
                return false;
                }
                int[][]shape = block.getShape();
                int w = block.getWidth();
                int h = block.getHeight();
                
                for (int col = 0; col < w; col++) {
                    
                    for (int row = h-1; row >= 0; row--) {
                        if (shape[row][col] != 0) {
                            int x =col + block.getX();
                            int y = row + block.getY()+1;
                            if(y<0) break;
                            if(background[y][x] != null) return false;
                            break;
                        }
                    }
            }
                      
                
                return true; 
        }
                private boolean checkLeft()
                {
                    if(block.getLeftEdge() == 0) return false;
                    
                            
                int[][]shape = block.getShape();
                int w = block.getWidth();
                int h = block.getHeight();
                
                for (int row = 0; row < h; row++) {
                    
                    for (int col = 0; col < w; col++ ) { 
                        if (shape[row][col] != 0) {
                            int x =col + block.getX() -1 ;
                            int y = row + block.getY();
                            if(y<0) break;
                            if(background[y][x] != null) return false;
                            break;
                        }
                    }
            }
                    
                    return true;
                }
                  private boolean checkRight(){
                              if(block.getRightEdge() == gridColumns) return false;
                                int[][]shape = block.getShape();
                int w = block.getWidth();
                int h = block.getHeight();
                
                for (int row = 0; row < h; row++) {
                    
                    for (int col = w-1; col >= 0 ; col--) { 
                        if (shape[row][col] != 0) {
                            int x =col + block.getX() +1 ;
                            int y = row + block.getY();
                            if(y<0) break;
                            if(background[y][x] != null) return false;
                            break;
                        }
                    }
            }
                              
                              
                    return true;
                }
        public void moveBlockRight()
        { 
            if (block == null ) return;

            if(!checkRight())return;
        block.moveRight();
        repaint();
        }
        public void moveBlockLeft()
        {
                        if (block == null ) return;

                        if(!checkLeft())return;

           block.moveleft();
           repaint();
        }
          public void dropBlock()
        {
                        if (block == null ) return;

            while(checkBottom()){
        block.moveDown();
        }
                      repaint();

        }
        public void rotateBlock()
        {
                        if (block == null ) return;

        block.rotate();
        if(block.getLeftEdge()<0 )block.setX(0);
        if(block.getRightEdge()>= gridColumns )block.setX(gridColumns - block.getWidth());
        if(block.getRightEdge()>= gridRows )block.setY(gridRows - block.getHeight());
        repaint();
        }
        public int clearLines()
        {
            boolean lineFilled;
            int linesCleared =0;
            
            for (int r = gridRows -1 ; r >= 0; r--) {
                lineFilled = true;
                for (int c = 0; c < gridColumns; c++) {
                    if(background [r][c] == null){
                       lineFilled = false;
                    break;
                    }
                } 
                if(lineFilled)
                {
                    linesCleared++;
                    clearLine(r);
                    shiftDown(r);
                    clearLine(0);
                    r++;
                    repaint();
                }
            }
            if(linesCleared > 0){
            Tetris.playClear();
            }
            return linesCleared;
        }
        private void clearLine(int r){
             for (int i = 0; i < gridColumns; i++) {
                        background [r][i]=null;
                    }
        }
                private void shiftDown(int r){
                    for (int row = r; row > 0; row--) {
                        System.arraycopy(background [row-1], 0, background[row], 0, gridColumns);
                    }
                }

       public void  moveBlockToBackground(){
        int [][] shape = block.getShape();
        int h = block.getHeight();
        int w = block.getWidth();
        
        int xPos = block.getX();
        int yPos = block.getY();
        
        Color color = block.getColor();
           for (int r = 0; r < h; r++) {
               for (int c = 0; c < w; c++) {
                   if(shape[r][c]==1){
                   background[r + yPos][c+ xPos] = color;
                   }
               }
           }
        
       }
        
public void drawBackground(Graphics g){
    Color color;
    for (int r = 0; r < gridRows; r++) {
        for (int c = 0; c < gridColumns; c++) {
        color = background[r][c]; 
        
        if (color != null) {
            int x = c  *gridCellSize;
            int y = r *gridCellSize;
          drawGridSquare( g,  color,  x,  y);
                
        }
        }
        
    }
}
}
 
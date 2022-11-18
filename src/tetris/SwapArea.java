package tetris;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Random;
import javax.swing.JPanel;
import tetrisblocks.*;

public class SwapArea extends JPanel {
    
    SwapBlocks sc;
    TetrisBlock block, block2;
    public SwapArea(JPanel placeholder,SwapBlocks sc)
    {
        this.sc =sc;
        placeholder.setVisible(false);
        this.setBounds(placeholder.getBounds());
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());
    
    }
        @Override
        protected void paintComponent(Graphics g)
        {
           super.paintComponent(g); 
            drawblock(g);
            if(block!=null)
            repaint();

        }
        
        private void drawblock(Graphics g){
            
            int gridCellSize = this.getBounds().width/10;
            this.block = sc.returnblock();
            sc.insertBlock(block);
            this.block2 = sc.returnblock();
            sc.insertBlock(block2);
            
            
            int h = block.getHeight();
            int w =  block.getWidth();
            Color c = block.getColor();
            int [][] shape = block.getShape();
            for (int row = 0; row < h; row++) {
                for (int col = 0; col <w; col++) {
                   //Check if we have to draw the cell
                    if (shape[row][col] == 1) 
                    {
                        g.fillRect(col*gridCellSize+20, row*gridCellSize+20, gridCellSize, gridCellSize);
                    }
                }
            }
            int h2 = block2.getHeight();
            int w2 =  block2.getWidth();
            int [][] shape2 = block2.getShape();
            for (int row = 0; row < h2; row++) {
                for (int col = 0; col <w2; col++) {
                   //Check if we have to draw the cell
                    if (shape2[row][col] == 1) 
                    {
                        g.fillRect(col*gridCellSize+20, row*gridCellSize+150, gridCellSize, gridCellSize);
                    }
                }
            }
        }

    
}
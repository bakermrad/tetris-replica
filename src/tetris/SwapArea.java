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
    
    
    public SwapArea(JPanel placeholder)
    {
        this.setBounds(placeholder.getBounds());
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());
    
    }
    //      Painting our Srid System anf The Blocks
        @Override
        protected void paintComponent(Graphics g)
        {
           super.paintComponent(g);
            g.drawString("Hello",40,40);  
            setBackground(Color.black);  
            g.fillRect(130, 30,100, 80);  
            g.drawOval(30,130,50, 60);  
            setForeground(Color.RED);  
            g.fillOval(130,130,50, 60);  
            g.drawArc(30, 200, 40,50,90,60);  
            g.fillArc(30, 130, 40,50,180,40);  
           


        }

    
}

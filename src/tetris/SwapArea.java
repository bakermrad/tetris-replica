package tetris;

import java.awt.Graphics;
import javax.swing.JPanel;

public class SwapArea extends JPanel {

    SwapBlocks sc;
    TetrisBlock block, block2;
    int gridCellSize;

    public SwapArea(JPanel placeholder, SwapBlocks sc) {
        this.sc = sc;
        placeholder.setVisible(false);
        this.setBounds(placeholder.getBounds());
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());
        gridCellSize = this.getBounds().width / 8;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawblock(g);
        repaint();

    }

    private void drawblock(Graphics g) {
        try {
            this.block = sc.returnblock();
            sc.insertBlock(block);
            this.block2 = sc.returnblock();
            sc.insertBlock(block2);

            int h = block.getHeight();
            int w = block.getWidth();

            g.setColor(block.getColor());
            int[][] shape = block.getShape();
            for (int row = 0; row < h; row++) {
                for (int col = 0; col < w; col++) {
                    if (shape[row][col] == 1) {

                        g.fillRect(col * gridCellSize + 20, row * gridCellSize + 20, gridCellSize, gridCellSize);
                    }
                }
            }
            g.setColor(block2.getColor());

            int h2 = block2.getHeight();
            int w2 = block2.getWidth();
            int[][] shape2 = block2.getShape();
            for (int row = 0; row < h2; row++) {
                for (int col = 0; col < w2; col++) {
                    if (shape2[row][col] == 1) {
                        g.fillRect(col * gridCellSize + 20, row * gridCellSize + 150, gridCellSize, gridCellSize);
                    }
                }
            }
        } catch (NullPointerException e) {
            throw e;
        }

    }

}

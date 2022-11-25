/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetrisblocks;

import static java.awt.Color.*;
import tetris.TetrisBlock;

/**
 *
 * @author baker
 */
public class ZShape extends TetrisBlock {
        public ZShape(){
        super( new int [][]{{1,1,0},
                             {0,1,1}} );
        super.color = blue;
    }
}
    


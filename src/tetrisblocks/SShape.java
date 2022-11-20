/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetrisblocks;

import static java.awt.Color.pink;
import static java.awt.Color.red;
import tetris.TetrisBlock;

/**
 *
 * @author baker
 */
public class SShape extends TetrisBlock {
    public SShape(){
        super( new int [][]{{0,1,1},
                             {1,1,0}} );
        super.color = pink;
    }
}
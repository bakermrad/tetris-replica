
package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baker
 */
public class GameThread extends Thread{
    private GameArea ga;
    private int score;
    private int level = 1;
    private int scorePerLevel = 1;
    private int pause = 1000;
    private int speedupPerLevel = 100;
    
    private GameForm gf;
    
    
    public GameThread(GameArea ga , GameForm gf){
        this.ga=ga;
        this.gf=gf;
        
        gf.updateScore(score);
        gf.updatelevel(level);
    }
    @Override
    public void run()
    {
        while(true){
            ga.spawnBlock ();
            while(  ga.moveBlockDown() ){

                try {

                    Thread.sleep(pause);
                } catch (InterruptedException ex) {
                    return;                }
    }
            if(ga.isBlockPutOfBounds()){
                Tetris.gameOver(score);
            break;
            }
               ga.moveBlockToBackground();
               score += ga.clearLines();
               gf.updateScore(score);
               
               int lvl = score / scorePerLevel +1;
               if(lvl > level  ){
                
                   level = lvl;
                   gf.updatelevel(level);
                   pause -= speedupPerLevel; 
               }
        }
    }
}
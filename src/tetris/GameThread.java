
package tetris;
/**
 *
 * @author baker
 */
public class GameThread extends Thread{
    
    private final GameArea ga;
    private final GameForm gf;
    private final SwapArea sa;
    private int score;
    private int level = 1;
    private final int scorePerLevel = 1;
    private int pause = 1000;
    private final int speedupPerLevel = 100;
    
    
    
    
    public GameThread(GameArea ga ,SwapArea sa, GameForm gf){
        this.ga=ga;
        this.sa=sa;
        this.gf=gf;
        gf.updateScore(score);
        gf.updatelevel(level);
    }
    
//  
    @Override
    public void run()
    {
//      This is our Main Game loop 
        while(true){
            ga.spawnBlock ();
            //we make the block move down, wait , then check if we are Bounded it stops else it keep moving down
            while(ga.moveBlockDown()){
                try {
                    Thread.sleep(pause);
                }
                catch (InterruptedException ex)
                {
                    return;                
                }
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
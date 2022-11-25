
package tetris;

import javax.swing.JOptionPane;

public class Tetris {
    public static Signup su;
    private static GameForm gf;
    private static StartupForm sf;
    private static LeaderboardForm lf;


    private static AudioPlayer audio = new AudioPlayer();

    public static void start(){
        
        gf.setVisible(true);
        gf.startGame();

    }
    public static void showLeaderboard(){
    lf.setVisible(true);

    }
    public static void showStartup()
    {
//        su.setVisible(true);
        sf.setVisible(true);
    }
    public static void gameOver(int score){
        playGameover();
        String playerName = JOptionPane.showInputDialog("GameOver");
        gf.setVisible(false);
        lf.addPlayer(playerName, score);
    }

    public static void playClear()
     {
         audio.playClearLine();
    }
     public static void playGameover ()
     {
         audio.playGameover();
    }


    public static void main(String[] args) {
        // TODO code application logic here
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            
            gf = new GameForm();
            su = new Signup();
            sf = new StartupForm();
            lf = new LeaderboardForm();
            su.setVisible(true);
//            sf.setVisible(true);
            }
        });

    }

    
    

}

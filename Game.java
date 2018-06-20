/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
/**
 *
 * By: Nishant Chintala
 */
/*
The Game class contains many of the methods needed to play the game. It handles
KeyEvents, it checks to see if the game is over, and updates the visuals of the 
game.
*/
public class Game extends JFrame implements KeyListener{
    static Tile[][] board = new Tile[4][4];
    static JFrame jf = new JFrame();
    public Date d1;
    private boolean newGame = true;
    Clock clock  = new Clock(400,0,jf,0.0);
    Score score = new Score(0,0,jf,0);
    
    public static void main(String[] args){
        Game game = new Game();
        jf.setTitle("2048");
        jf.setSize(1200,1000);
        jf.addKeyListener(game);
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        game.play();
    }
    /*
    The play() method sets the board initially. Then, it checks if the game is 
    over, with the user either winning or losing. If the game is not over, the
    frame is repainted along with the clock. If the user loses, another JFrame 
    pops up saying that the game is over and that the user lost. It also includes
    the final score and the final time.
    */
    public void play(){
        setBoard();
        while(!isOverWin() && !isOverLose()){
            clock.seconds = timePlayed();
            clock.repaint();
            this.repaint();
        }
        if(isOverLose()){
            JFrame frame = new JFrame("Game Over: You Lose");
            JLabel label = new JLabel("You lose! You finished with a score of " + 
                    score.score + " in a time of " + clock.seconds + " seconds");
            Font f = new Font("Verdana", 1, 30);
            label.setFont(f);
            frame.setSize(1500,1000);
            frame.add(label);
            frame.setVisible(true);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(isOverWin()){
            JFrame frame = new JFrame("Game Over: You Win!");
            JLabel label = new JLabel("You win! You finished with a score of " + 
                    score.score + " in a time of " + clock.seconds + " seconds");
            Font f = new Font("Verdana", 1, 30);
            label.setFont(f);
            frame.setSize(1500,1000);
            frame.add(label);
            frame.setVisible(true);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    /*
    setBoard() is called to initially set up the board. setBoard() makes 15 out 
    of the 16 Tiles in the board blank and randomly sets one of the 16 Tiles to 
    be a "2" Tile. 
    */
    public static void setBoard(){
        int indexOfTile = 0;
        int x = (int)(Math.random()*4);
        int y = (int)(Math.random()*4);
        
        for(int i =0; i < board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                if(i== x&& j == y){
                    board[i][j] = new Tile((j+1)*200, i*200 + 100, 2, Color.lightGray,indexOfTile, jf);
                    indexOfTile++;
                }
                else{
                    board[i][j] = new Tile((j+1)*200, i*200 + 100, 0, Color.WHITE,indexOfTile, jf);
                    indexOfTile++;
                }
            }
        }
    }
    /*
    newTile() randomly selects a place in the board to put a new Tile. The new 
    Tile either has a 2 or a 4 value. 
    */
    public void newTile(){
        int x = (int)(Math.random()*4);
        int y = (int)(Math.random()*4);
        
        while(board[x][y].number != 0){
            x = (int)(Math.random()*4);
            y = (int)(Math.random()*4);
        }
        Color c;
        int num;
        num = ((int)(Math.random()*2) + 1) * 2;
        if(num == 2)
            c = Color.lightGray;
        else
            c = Color.DARK_GRAY;
        
        board[x][y].changeColorAndNumber(c, num) ;
        this.repaint();
    }
    @Override
    public void keyTyped(KeyEvent e){
    }
    /*
    keyPressed takes a KeyEvent e. Once a KeyEvent is taken, the timer starts. 
    If the KeyEvent has a KeyCode equal to VK_UP, then the moveUp method is 
    called from the GamePlay class. If the KeyCode is equal to VK_DOWN, then the 
    moveDown method is called from the GamePlay class. If the KeyCode is equal to
    VK_RIGHT, then the moveRight method is called from the GamePlay class. If the 
    KeyCode is equal to VK_LEFT, then the moveLeft method is called from the 
    GamePlay class. At the end, if the board is not filled with Tiles, then a new
    Tile is generated. Otherwise, a new Tile is not generated. JFrame is repainted
    at the end of the KeyPressed method. score is also increased at the end.
    */
    @Override
    public void keyPressed(KeyEvent e){
        GamePlay g = new GamePlay(board);
        if(newGame)
            madeFirstMove();
        if(e.getKeyCode() == KeyEvent.VK_UP)
            g.moveUp();
        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
            g.moveDown();
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            g.moveRight();
        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
            g.moveLeft();
        if(!isFull())
            this.newTile();
        this.repaint();
        score.increaseScore(highestTile());
        score.repaint();
    }
    @Override
    public void keyReleased(KeyEvent e){
    }
    /*
    isOverWin() returns true if the game is over and the user wins. The user wins
    if they reach the 2048 tile. If the game is not over, the method returns false.
    */
    public boolean isOverWin(){
        int max = 0;
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j].number > max)
                    max = board[i][j].number;
                if(max == 2048)
                    return true;
            }
        }
        return false;
    }
    /*
    isOverLose() checks to see if the game is over and the user lost. The user 
    loses if the entire board is full and no other possible moves can be made.
    isOverLose() returns true if the user has lost and the game is over. If not,
    it returns false.
    */
    public boolean isOverLose(){
        if(!isFull())
            return false;
        int count = 0;
        for(int i = 1; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                if(board[j][i].number != board[j][i-1].number){
                    count++;
                }
            }
        }
        for(int i = 1; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                if(board[i][j].number != board[i-1][j].number){
                    count++;
                }
            }
        }
        if(count == 24){
            return true;
        }
        return false;
     }
    private void madeFirstMove(){
        d1 = new Date();
        newGame = false;
    }
    /*
    timePlayed() returns the number of seconds played so far. In essence, it 
    keeps track of time.
    */
    public double timePlayed(){
       // If no move has been made yet
       if(d1 == null)
           return 0;

       Date d2 = new Date();
       double seconds = ((d2.getTime() - d1.getTime()) / 1000.0);
       return seconds;
    }
    /*
    highestTile() returns the highest Tile that is currently on the board.
    */
    public static int highestTile(){
        int max = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j].number > max){
                    max = board[i][j].number;
                }
            }
        }
        return max;
    }
    /*
    isFull() returns true if the board is full with Tiles that are not blank.
    It returns false if the board has at least one blank Tile.
    */
    public boolean isFull(){
        int count = 0;
        for(int i = 0; i<board.length;i++){
            for(int j = 0; j<board.length; j++){
                if(board[i][j].number !=0){
                    count++;
                }
            }
        }
        if(count == 16){
            return true;
        }
        return false;
    }
    
}

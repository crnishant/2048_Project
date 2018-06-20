/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.KeyEvent;

/**
 *
 * By: Ben Conrad and Nishant Chintala
 */
/*
The GamePlay class contains moving methods for the tiles as well as the reActivate
method to reactivate the Tiles and allow them to move in the future.
*/
public class GamePlay{
    static Tile[][] board;
    KeyEvent key;
    static int score;
    
    public GamePlay(Tile[][] gameBoard){
        board = gameBoard;
        score = 0;
    }
    /*moveUp() is called when the up arrow key is pressed. it moves all the tiles
    up in the board*/
    public void moveUp(){
        for(int i = 1; i <board.length; i++){
            for(int j = 0; j<board.length; j++){
                int x = i;
                while(x > 0 && board[x-1][j].number == 0){
                    board[x][j].combineWithEmpty(board[x-1][j]);
                    x--;
                }
                if(board[i][j].number == board[i-1][j].number){
                    board[i][j].combine(board[i-1][j]);
                }
            }
        }
        
        reActivate();
    }
    /*moveDown() is called when the down arrow key is pressed. it moves all the tiles
    down in the board*/
    public void moveDown(){
        for(int i = 2; i >= 0; i--){
            for(int j = 0; j < board.length; j++){
                int x = i;
                while(x < 3 && board[x+1][j].number == 0){
                    board[x][j].combineWithEmpty(board[x+1][j]);
                    x++;
                }
                if(board[i][j].number == board[i+1][j].number){
                    board[i][j].combine(board[i+1][j]);
                }
            }
        }
        reActivate();
    }
    /*moveRight() is called when the right arrow key is pressed. it moves all the tiles
    right in the board*/
    public void moveRight(){
        for(int i = 0; i < board.length; i++){
            for(int j = 2; j>=0; j--){
                int x = j;
                while(x < 3 && board[i][x+1].number == 0){
                    board[i][x].combineWithEmpty(board[i][x+1]);
                    x++;
                }
                if(board[i][j].number == board[i][j+1].number && board[i][j].number !=0){
                    board[i][j].combine(board[i][j+1]);
                }
            }
        } 
        reActivate();
    }
    /*moveLeft() is called when the left arrow key is pressed. it moves all the tiles
    left in the board*/
    public void moveLeft(){
        for(int i = 0; i < board.length; i++){
            for(int j = 1; j<board.length; j++){
                int x = j;
                while(x > 0 && board[i][x-1].number==0){
                    board[i][x].combineWithEmpty(board[i][x-1]);
                    x--;
                }
                if(board[i][j].number == board[i][j-1].number){
                    board[i][j].combine(board[i][j-1]);
                }
            }
        }
        reActivate();
    }
    /*reActivate() sets the isActive attribute of each tile to true so that the 
    tile can recombine with other tiles in the future.*/
    public static void reActivate(){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                board[i][j].isActive = true;
            }
        }
    }
}



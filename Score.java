/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

/**
* Created by Ben and Nish
*/
//The Score Class is a JPanel Object that draws the score number on a JFrame.
public class Score extends JPanel {
   JFrame jf;
   public int score;
   public Score(int x, int y, JFrame frame, int aScore){
       this.setSize(400, 25);
       this.setLocation(x,y);
       score = aScore;
       jf = frame;
       jf.add(this);
   }
   //Paints the current Score object on the JFrame.
   protected void paintComponent(Graphics t) {
       super.paintComponent(t);
       Font f = new Font("Verdana", Font.BOLD, 25);
       t.setFont(f);
       t.drawString("Score: " + Integer.toString(score), 0, 25);
   }
   //Accepts an int and adds that numbe to the current score and returns the new score number as an int.
   public int increaseScore(int num){
       score += num;
       return score;
   }
}





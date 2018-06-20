/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
/**
* Created by Nishant Chintala
*/
// The Clock Class makes a JPanel object that displays the current play time on a JFrame.
public class Clock extends JPanel{
   JFrame jf;
   JLabel jl;
   public Double seconds;
   public Clock(int x, int y, JFrame frame,double seconds){
       this.setSize(400,25);
       this.setLocation(x,y);
       this.seconds = seconds;
       jf = frame;
       jf.add(this);
   }
   //Paints the Clock component on the JFrame.
   protected void paintComponent(Graphics t){
       super.paintComponent(t);
       Font f = new Font("Verdana", Font.BOLD, 25);
       t.setFont(f);
       t.drawString("Time: "+ Double.toString(seconds) + " Seconds", 0, 25);

   }
}




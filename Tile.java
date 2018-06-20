/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
*
* By: Nishant Chintala
*/
//The Tile Class creates a tile object that has a color, number, index, x and y position, and an active boolean. The tile is intended to be drawn on a JFrame and appear as a colored square with a number in the middle.
public class Tile extends JPanel{
   Tile t;
   JFrame jf;
   JLabel label;
   int number;
   Color color;
   int xposn;
   int yposn;
   int index;
   Random rand;
   Boolean isActive;

   public Tile(int xposition, int yposition, int num, Color color1,int ind, JFrame frame){
       //t = new Tile(xposn,yposn,number, color);
       this.setSize(200,200);
       this.setLocation(xposition, yposition);
       xposn = xposition;
       yposn = yposition;
       number = num;
       color = color1;
       index = ind;
       jf = frame;

       jf.add(this);
       isActive = true;
   }
   //Paints the tile components on screen.
   protected void paintComponent(Graphics g){
       super.paintComponent(g);
       g.setColor(Color.BLACK);
       g.drawRect(0, 0, 200, 200);
       g.setColor(color);
       g.fillRect(1, 1, 199,199);
       this.setBorder(new EmptyBorder(10,10,10,10));
       Font f = new Font("Verdana", Font.BOLD, 50);
       if(number != 0){
           g.setColor(Color.BLACK);
           g.setFont(f);
           g.drawString(Integer.toString(number), 70, 130);
       }
   }
   //determines whether two tiles are equal to each other and returns a boolean value.
   public boolean equals(Tile t1){
       if(this.number == t1.number)
           return true;
       return false;
   }
   //Effectively moves a tile one space over by taking up the tile space that was occupied by an empty tile.
   public void combineWithEmpty(Tile t){
       //Tile t is empty; "this" will take its position
       t.changeColorAndNumber(this.color, this.number);
       this.blank();
       t.repaint();
   }
   //Makes the specified tile combine with the tile next to it, taking the place of t2. This also updates the color and number to that of the new tile.
   public void combine(Tile t2){
       //establish that "this" takes t2 position
       //4 Tile
       if(this.number == 2 && (this.isActive && t2.isActive)){
           this.blank();
           t2.changeColorAndNumber(Color.DARK_GRAY, t2.number*2);
           t2.isActive = false;
           this.isActive = false;
           t2.repaint();
       }
       //8 Tile
       else if(this.number == 4 && (this.isActive && t2.isActive)){
           this.blank();
           t2.changeColorAndNumber(Color.RED, t2.number*2);
           t2.isActive = false;
           this.isActive = false;
           t2.repaint();
       }
       //16 Tile
       else if(this.number == 8 && (this.isActive && t2.isActive)){
           this.blank();
           t2.changeColorAndNumber(Color.GREEN, t2.number*2);
           t2.isActive = false;
           this.isActive = false;
           t2.repaint();
       }
       //32 Tile
       else if(this.number == 16 && (this.isActive && t2.isActive)){
           this.blank();
           t2.changeColorAndNumber(Color.CYAN, t2.number*2);
           t2.isActive = false;
           this.isActive = false;
           t2.repaint();
       }
       //64 Tile
       else if(this.number == 32 && (this.isActive && t2.isActive)){
           this.blank();
           t2.changeColorAndNumber(Color.BLUE, t2.number*2);
           t2.isActive = false;
           this.isActive = false;
           t2.repaint();
       }
       //128 Tile
       else if(this.number == 64 && (this.isActive && t2.isActive)){
           this.blank();
           t2.changeColorAndNumber(Color.MAGENTA, t2.number*2);
           t2.isActive = false;
           this.isActive = false;
           t2.repaint();
       }
       //256 Tile
       else if(this.number == 128 && (this.isActive && t2.isActive)){
           this.blank();
           t2.changeColorAndNumber(Color.PINK, t2.number*2);
           t2.isActive = false;
           this.isActive = false;
           t2.repaint();
       }
       //512 Tile
       else if(this.number == 256 && (this.isActive && t2.isActive)){
           this.blank();
           t2.changeColorAndNumber(Color.YELLOW, t2.number*2);
           t2.isActive = false;
           this.isActive = false;
           t2.repaint();
       }
       //1024 Tile
       else if(this.number == 512 && (this.isActive && t2.isActive)){
           this.blank();
           t2.changeColorAndNumber(Color.ORANGE, t2.number*2);
           t2.isActive = false;
           this.isActive = false;
           t2.repaint();
       }
       //2048 Tile
       else if(this.number == 1024 && (this.isActive && t2.isActive)){
           Color c = new Color(255,225,0);
           this.blank();
           t2.changeColorAndNumber(c, t2.number*2);
           t2.isActive = false;
           this.isActive = false;
           t2.repaint();
       }
       //4096 Tile
       else if(this.number == 2048 && (this.isActive && t2.isActive)){
           Color c = new Color(146,205,11);
           this.blank();
           t2.changeColorAndNumber(c, t2.number*2);
           t2.isActive = false;
           this.isActive = false;
           t2.repaint();
       }
       //8192 Tile
       else if(this.number == 4096 && (this.isActive && t2.isActive)){
           Color c = new Color(165,255,19);
           this.blank();
           t2.changeColorAndNumber(c, t2.number*2);
           t2.isActive = false;
           this.isActive = false;
           t2.repaint();
       }
       //16384 Tile
       else if(this.number == 8192 && (this.isActive && t2.isActive)){
           Color c = new Color(255,225,0);
           this.blank();
           t2.changeColorAndNumber(c, t2.number*2);
           t2.isActive = false;
           this.isActive = false;
           t2.repaint();
       }
       //32768 Tile
       else if(this.number == 16384 && (this.isActive && t2.isActive)){
           Color c = new Color(145,211,255);
           this.blank();
           t2.changeColorAndNumber(c, t2.number*2);
           t2.isActive = false;
           this.isActive = false;
           t2.repaint();
       }
       //all other Tiles
       else {
           Color c = new Color(255,255,255);
           this.blank();
           t2.changeColorAndNumber(c, t2.number*2);
           t2.isActive = false;
           this.isActive = false;
           t2.repaint();
       }
       this.repaint();
   }
   //Changes the specified tile to an empty tile by making the color white and the number 0.
   public void blank(){
       this.color = Color.WHITE;
       this.number = 0;
   }
   //Changes the Color and Number displayed for the Tile.
   public void changeColorAndNumber(Color c, int num){
       this.color = c;
       this.number = num;
   }


}




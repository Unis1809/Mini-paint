/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapss;

import Shapss.shapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;



/**
 *
 * @author king
 */
public class REct extends shapes {

int w;

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }
int h;
 Color color;
 Color fcolor;
 Point p1;
public static  int rc;
public static  int sc;

    public REct(Point p1, int w, int h) {
        this.p1=p1;
        this.w = w;
        this.h = h;
        this.setColor(Color.BLACK);
        this.setFillColor(Color.GRAY);
      
    }
    
    
  

public void draw(Graphics canvas) {
    int x = 0;
 int y = 0;
 x=this.p1.x;
 y=this.p1.y;
 color=this.getColor();
 fcolor=this.getFillColor();
   Graphics2D g=(Graphics2D)canvas;
      g.setColor(color);
      g.drawRect(x, y, w, h);
      g.setColor(fcolor);
      g.fillRect(x, y, w,h);
      
}

public boolean contains(Point position){
   int x, y;
    x=position.x-this.p1.x;
    y=position.y-this.p1.y;
    
    if(x<=this.w&&y<=this.h && x>=0 && y>=0)
        return true;
    else
        return false;  
}


public void moveTo(Point position){
    
    
    
    
   
    
    
    
}
 public int getnode(Point position)
 {
   Point p1=new Point(this.p1.x-4,this.p1.y-4);
   Point p2=new Point(this.p1.x+this.w-4,this.p1.y-4);
   Point p3=new Point(this.p1.x-4,this. p1.y+this.h-4);
   Point p4=new Point(this.p1.x+this.w-4, this.p1.y+this.h-4);
   int [] x={p1.x,p2.x,p3.x,p4.x};
   int [] y={p1.y,p2.y,p3.y,p4.y};
      int i;
   for (i=0; i<4; i++)
   {
       if (position.x >=x[i] && position.x <= x[i]+8 && position.y >=y[i] && position.y <= y[i]+8  )
       {
         return i;
          
       }          

          
   }
     
     return -1;
 }
   
    public void addShape(Shape shape) {
       this.shape.add(shape);  
    }

    
    
    
    public void dborder(Graphics2D canvas,int i)
    {
    
      
          REct c=(REct)shapes.shape.get(i);
           Rectangle2D s = new Rectangle2D.Double();
      Rectangle2D[] points = { new Rectangle2D.Double(c.p1.x-4, c.p1.y-4,8, 8), new Rectangle2D.Double(c.p1.x+c.w-4,c.p1.y-4,8, 8),new Rectangle2D.Double(c.p1.x-4,c.p1.y+c.h-4,8, 8),new Rectangle2D.Double(c.p1.x+c.w-4, c.p1.y+c.h-4,8, 8) };
    
           for (int z = 0; z < points.length; z++) {
                canvas.setColor(Color.BLACK);
      canvas.fill(points[z]);
      }
        
        
        
        
      
    }
    
    
    
    
    
    
    
    
    
    
    
}

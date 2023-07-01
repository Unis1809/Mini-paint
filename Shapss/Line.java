/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapss;

import Shapss.Shape;
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
public class Line extends shapes  {

Point p1;
Point p2;        
private Color color;
public static int lc;

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

   

    public Line(Point p1, Point p2){
        this.p1=p1;
        this.p2=p2;
        this.setColor(Color.BLACK);
        
    }

    
   
   

@Override
public boolean contains(Point position){
    
  int minx,maxx,miny,maxy;
   minx=Math.min(this.p1.x, this.p2.x);
   maxx=Math.max(this.p1.x, this.p2.x); 
     miny=Math.min(this.p1.y, this.p2.y);
   maxy=Math.max(this.p1.y, this.p2.y); 
    if(position.x>=minx&&position.x<=maxx&&position.y>=miny&&position.y<=maxy)
        return true;
    else
        return false;  
}


@Override
public void moveTo(Point position){
    
    
    
    
   
    
    
} 
public int getnode(Point position)
 {
   Point p1=new Point(this.p1.x-4,this.p1.y-4);
   Point p2=new Point(this.p2.x-4,this.p2.y-4);
   int [] x={p1.x,p2.x};
   int [] y={p1.y,p2.y};
      int i;
   for (i=0; i<2; i++)
   {
       if (position.x >=x[i] && position.x <= x[i]+8 && position.y >=y[i] && position.y <= y[i]+8  )
       {
         return i;
          
       }          

          
   }
     
     return -1;
 }

public void draw(Graphics canvas) {
    int x1 = 0,x2 = 0,y1 = 0,y2 = 0;
    x1=this.p1.x;
    y1=this.p1.y;
    x2=this.p2.x;
    y2=this.p2.y;
    color=this.getColor();
      Graphics2D g=(Graphics2D)canvas;
      g.setColor(color);
      g.drawLine(x1, y1, x2, y2);
     
    
    
  
}

   
    public void addShape(Shape shape) {
      this.shape.add(shape);
    }

   
   


  public void dborder(Graphics2D canvas,int i)
    {
    
     
          Line c=(Line)shapes.shape.get(i);
           Rectangle2D s = new Rectangle2D.Double();
      Rectangle2D[] points = { new Rectangle2D.Double(c.p1.x-4, c.p1.y-4,8, 8), new Rectangle2D.Double(c.p2.x-4,c.p2.y-4,8, 8)};
           for (int z = 0; z < points.length; z++) {
                canvas.setColor(Color.BLACK);
      canvas.fill(points[z]);
      }
        
        
        
        
      
    }
}
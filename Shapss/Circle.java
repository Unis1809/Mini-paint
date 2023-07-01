/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapss;

import Paint.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.lang.Math;

/**
 *
 * @author king
 */
public class Circle extends shapes {
int w,h;
  
 Color color;
 Color fcolor;
 Point p1;

public static int circ=0;
    public Circle(Point p1, int w, int h) {
        this.p1=p1;
        this.w = w;
        this.h = h;
        this.setColor(Color.BLACK);
        this.setFillColor(Color.GRAY);
    }

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

@Override
  public boolean contains(Point position){
    Point p = new Point(0,0);
    //p.x=position.x-(this.p1.x+w/2);
    //p.y=position.y-(this.p1.y+w/2);
  //  double x=Math.pow(p.x, 2);
   // double y=Math.pow(p.y, 2);
   // double z=Math.pow(x+y, 0.5);
    //if(z<=w/2)
        //return true;
  //  else
  int x,y;
   x=position.x-this.p1.x;
    y=position.y-this.p1.y;
    
    if(x<=this.w&&y<=this.h && x>=0 && y>=0)
        return true;
    else
        return false;  
    
    
    
   
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
  
  
  
  
  
  
  
  
  
  
 public void dborder(Graphics2D canvas,int i)
    {
    
     
          Circle c=(Circle)shapes.shape.get(i);
           Rectangle2D s = new Rectangle2D.Double();
      Rectangle2D[] points = { new Rectangle2D.Double(c.p1.x-4, c.p1.y-4,8, 8), new Rectangle2D.Double(c.p1.x+c.w-4,c.p1.y-4,8, 8),new Rectangle2D.Double(c.p1.x-4,c. p1.y+c.h-4,8, 8),new Rectangle2D.Double(c.p1.x+c.w-4, c.p1.y+c.h-4,8, 8) };
    
           for (int z = 0; z < points.length; z++) {
                canvas.setColor(Color.BLACK);
      canvas.fill(points[z]);
      }
        
        
        
        
      }
    
        
          
  
  
  
  
  
  
  
  

 
    
    
    
   
    
    
  
@Override
public void draw(Graphics canvas) {
int x ,y ;
x=this.p1.x;
y=this.p1.y;
color=this.getColor();
fcolor=this.getFillColor();
      Graphics2D g=(Graphics2D)canvas;
      g.setColor(color);
      g.drawOval(x, y, w, h);
      g.setColor(fcolor);
      g.fillOval(x, y, w,h);
    
      

      
    
    
}

    
    public void addShape(Shape shape) {
       
      this.shape.add(shape);  
  
    }

    @Override
    public void moveTo(Point position) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 //   @Override
  //  public Object toJson() {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}

       
        
    }
    

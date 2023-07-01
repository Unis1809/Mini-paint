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
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author king
 */
public class Triangle extends shapes {
 Point p1;
Point p2;  
Point p3;
Polygon p;
Color color;
 Color fcolor;
 public static int tri=0;
    public Triangle(Point p1, Point p2,Point p3) {
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
        this.setColor(Color.BLACK);
        this.setFillColor(Color.GRAY);
    }
@Override
    public void draw(Graphics canvas) {
  int[] x={0,0,0};
 int[]y={0,0,0};
x[0]=this.p1.x;
x[1]=this.p2.x;
x[2]=this.p3.x;
y[0]=this.p1.y;
y[1]=this.p2.y;
y[2]=this.p3.y;
color=this.getColor();
fcolor=this.getFillColor();
      Graphics2D g=(Graphics2D)canvas;
      g.setColor(color);
      g.drawPolygon(x, y, 3);
     g.setColor(fcolor);
     g.fillPolygon(x, y, 3);
    }   
@Override
 public boolean contains(Point position){
   int minx,miny,maxx,maxy;
   minx=Math.min(this.p1.x, this.p2.x);
   minx=Math.min(minx, this.p3.x); 
     miny=Math.min(this.p1.y, this.p2.y);
   miny=Math.min(miny, this.p3.y); 
    maxx=Math.max(this.p1.x, this.p2.x);
   maxx=Math.max(maxx, this.p3.x); 
    maxy=Math.max(this.p1.y, this.p2.y);
   maxy=Math.max(maxy, this.p3.y);
    System.out.println("maxmin"+ maxx + "," + minx + "," + maxy + "," + miny);
   if(position.x>=minx&&position.x<=maxx&position.y>=miny&&position.y<=maxy)
       return true;
   else
  return false;  
}


public void moveTo(Point position){
    
    
    
    
   
    
    
    
}

public int getnode(Point position)
 {
   Point p1=new Point(this.p1.x-4,this.p1.y-4);
   Point p2=new Point(this.p2.x-4,this.p2.y-4);
   Point p3=new Point(this.p3.x-4,this. p3.y-4);
   int [] x={p1.x,p2.x,p3.x};
   int [] y={p1.y,p2.y,p3.y};
      int i;
   for (i=0; i<3; i++)
   {
       if (position.x >=x[i] && position.x <= x[i]+8 && position.y >=y[i] && position.y <= y[i]+8  )
       {
         return i;
          
       }          

          
   }
     
     return -1;
 }
  












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

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }
   
    public void addShape(Shape shape) {
       this.shape.add(shape);  
    }
    
    
    public void dborder(Graphics2D canvas,int i)
    {
    
     
          Triangle c=(Triangle)shapes.shape.get(i);
           Rectangle2D s = new Rectangle2D.Double();
      Rectangle2D[] points = { new Rectangle2D.Double(c.p1.x-4, c.p1.y-4,8, 8), new Rectangle2D.Double(c.p2.x-4,c.p2.y-4,8, 8),new Rectangle2D.Double(c.p3.x-4,c. p3.y-4,8, 8) };
    
           for (int z = 0; z < points.length; z++) {
               canvas.setColor(Color.BLACK);
      canvas.fill(points[z]);
      
      }
        
        
        
        
      
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
}

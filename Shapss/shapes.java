/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapss;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 *
 * @author king
 */
 public abstract class shapes implements Shape , Moveable  {
     public static ArrayList <Shape> shape= new ArrayList<Shape>();
     
     Color bcolor;
     Color fcolor;
   public static Point p;
    public static Point dragpoint;
     ArrayList <Shape> shapese= new ArrayList<Shape>();
   
    
  //   public abstract JsonObject toJson();
     
     public   Shape[] getShapes() {
      int i;
      
     Shape [] s1=new Shape [shape.size()];
      for(i=0;i<shape.size();i++)
      {
         s1[i]=(Shape)shape.get(i);
     
      }
      return s1;   
    }

    
    public  void refresh(Graphics canvas) {
        int i;
      
      Shape[] s ;
      s=this.getShapes();
       
         
        for(i=0;i<s.length;i++)
        {
            
           
            if(s[i] instanceof Circle){
              Circle c = (Circle) s[i];
              c.draw(canvas);
                System.out.println("cir");
            }
                if(s[i] instanceof Line){
              Line c = (Line) s[i];
              c.draw(canvas);
            }
               if(s[i] instanceof REct){
              REct c = (REct) s[i];
              c.draw(canvas);
            }
               if(s[i] instanceof Triangle){
              Triangle c = (Triangle) s[i];
              c.draw(canvas);
            }
                 
            
            
            
        }
     
     
     
     
}
    
    
    
    public void removeShape(Shape shapese) {
        
        int i ;
      for(i=0;i<shape.size();i++)
      {    
      if(shape.get(i)==shapese)
         this.shape.remove(i);
     
      }
     }
    public void setColor(Color color , Color fcolor , int i) {
  
    
    
            
           
            if(shapes.shape.get(i) instanceof Circle){
              Circle c = (Circle) shapes.shape.get(i);
              c.setColor(color);
              c.setFillColor(fcolor);
                System.out.println("cir");
            }
                if(shapes.shape.get(i) instanceof Line){
              Line c = (Line) shapes.shape.get(i);;
              c.setColor(color);
            }
               if(shapes.shape.get(i) instanceof REct){
              REct c = (REct) shapes.shape.get(i);
              c.setColor(color);
              c.setFillColor(fcolor);
            }
               if(shapes.shape.get(i) instanceof Triangle){
              Triangle c = (Triangle) shapes.shape.get(i);
              c.setColor(color);
              c.setFillColor(fcolor);
            }
               
               
                 
    }
   public void moveTo(Point position ,int z){
 Point p2 = new Point(0,0);

 
 
  if(shapes.shape.get(z) instanceof Circle){
              Circle c = (Circle) shapes.shape.get(z);
              if(paint.Drawingapp.nodei>-1){
                if(paint.Drawingapp.nodei==0){
                   p2.x=c.p1.x+position.x;
                   p2.y=c.p1.y+position.y;
                   c.w=c.w-position.x;
                   c.h=c.h-position.y;
                }  
                if(paint.Drawingapp.nodei==1){
                    p2.x=c.p1.x;
                   p2.y=c.p1.y+position.y;
                   c.w=c.w+position.x;
                   c.h=c.h-position.y;
                }
                if(paint.Drawingapp.nodei==2){
                   p2.x=c.p1.x+position.x;
                   p2.y=c.p1.y;
                   c.w=c.w-position.x;
                   c.h=c.h+position.y;
                }  
                if(paint.Drawingapp.nodei==3){
                  p2.x=c.p1.x;
                   p2.y=c.p1.y;
                   c.w=c.w+position.x;
                   c.h=c.h+position.y;
                }  
               
                c.p1.x=p2.x;
                c.p1.y=p2.y;
                //  System.out.println(c.p1.x + "," + c.w  + "," + c.h);
              if (c.w<0)
                {
                    c.p1.x = c.p1.x +c.w;
                    c.w = -c.w;
                  paint.Drawingapp.nodei=(paint.Drawingapp.nodei+1)%4;
                }   
                if (c.h<0)
                {
                    c.p1.y = c.p1.y +c.h;
                    c.h = -c.h;
                    paint.Drawingapp.nodei=(paint.Drawingapp.nodei+1)%4;
                }   

              }
              else{
                p2.x=c.p1.x+position.x;
                p2.y=c.p1.y+position.y;
                c.p1.x=p2.x;
                c.p1.y=p2.y;}
            
                System.out.println("cir");
            }
               if(shapes.shape.get(z) instanceof Line){
              Line c = (Line) shapes.shape.get(z);
               if(paint.Drawingapp.nodei>-1){
                if(paint.Drawingapp.nodei==0){
                   p2.x=c.p1.x+position.x;
                   p2.y=c.p1.y+position.y;
                   c.p1.x=p2.x;
                    c.p1.y=p2.y;
                  // c.w=c.w-position.x;
                  // c.h=c.h-position.y;
                }  
                if(paint.Drawingapp.nodei==1){
                    p2.x=c.p2.x+position.x;
                   p2.y=c.p2.y+position.y;
                  // c.w=c.w+position.x;
                  // c.h=c.h-position.y;
                  c.p2.x=p2.x;
                  c.p2.y=p2.y;
                
                  
                }
               }
              else{
               c.p1.x=c.p1.x+position.x;
              c.p1.y=c.p1.y+position.y;
             // c.p1.x=p2.x;
              //c.p1.y=p2.y;
              
              c.p2.x=c.p2.x+position.x;
              c.p2.y=c.p2.y+position.y;}
              //c.p2.x=p2.x;
              //c.p2.y=p2.y;
            }
               
               if(shapes.shape.get(z) instanceof REct){
              REct c = (REct) shapes.shape.get(z);
               if(paint.Drawingapp.nodei>-1){
                if(paint.Drawingapp.nodei==0){
                   p2.x=c.p1.x+position.x;
                   p2.y=c.p1.y+position.y;
                   c.w=c.w-position.x;
                   c.h=c.h-position.y;
                }  
                if(paint.Drawingapp.nodei==1){
                    p2.x=c.p1.x;
                   p2.y=c.p1.y+position.y;
                   c.w=c.w+position.x;
                   c.h=c.h-position.y;
                }
                if(paint.Drawingapp.nodei==2){
                   p2.x=c.p1.x+position.x;
                   p2.y=c.p1.y;
                   c.w=c.w-position.x;
                   c.h=c.h+position.y;
                }  
                if(paint.Drawingapp.nodei==3){
                  p2.x=c.p1.x;
                   p2.y=c.p1.y;
                   c.w=c.w+position.x;
                   c.h=c.h+position.y;
                }  
                c.p1.x=p2.x;
                c.p1.y=p2.y;
                  if (c.w<0)
                {
                    c.p1.x = c.p1.x +c.w;
                    c.w = -c.w;
                  paint.Drawingapp.nodei=(paint.Drawingapp.nodei+1)%4;
                }   
                if (c.h<0)
                {
                    c.p1.y = c.p1.y +c.h;
                    c.h = -c.h;
                    paint.Drawingapp.nodei=(paint.Drawingapp.nodei+1)%4;
                }   
              }
              else{
                p2.x=c.p1.x+position.x;
                p2.y=c.p1.y+position.y;
                c.p1.x=p2.x;
                c.p1.y=p2.y;}
            
               }
                if(shapes.shape.get(z) instanceof Triangle){
                    
              Triangle c = (Triangle) shapes.shape.get(z);
               if(paint.Drawingapp.nodei>-1){
                if(paint.Drawingapp.nodei==0){
                   p2.x=c.p1.x+position.x;
                   p2.y=c.p1.y+position.y;
                   c.p1.x=p2.x;
                    c.p1.y=p2.y;
                  // c.w=c.w-position.x;
                  // c.h=c.h-position.y;
                }  
                if(paint.Drawingapp.nodei==1){
                    p2.x=c.p2.x+position.x;
                   p2.y=c.p2.y+position.y;
                  // c.w=c.w+position.x;
                  // c.h=c.h-position.y;
                  c.p2.x=p2.x;
                  c.p2.y=p2.y;
                }
                if(paint.Drawingapp.nodei==2){
                   p2.x=c.p3.x+position.x;
                   p2.y=c.p3.y+position.y;
                 //  c.w=c.w-position.x;
                  // c.h=c.h+position.y;
                  c.p3.x=p2.x;
                  c.p3.y=p2.y;
                }  
                
                //c.p1.x=p2.x;
                //c.p1.y=p2.y;
              }
               
              else{ 
               c.p1.x=c.p1.x+position.x;
              c.p1.y=c.p1.y+position.y;
             
              
              c.p2.x=c.p2.x+position.x;
              c.p2.y=c.p2.y+position.y;
               c.p3.x=c.p3.x+position.x;
              c.p3.y=c.p3.y+position.y;}
                }   
               
               
 
  }
   
   public Shape copy(int i)
   {
     if(shapes.shape.get(i) instanceof Circle){
              Circle c = (Circle) shapes.shape.get(i);
              Point p1=new Point(c.p1.x,c.p1.y);
              
             int w=c.getW();
             int h=c.getH();
             Circle d=new Circle(p1,w,h);
//             d.setColor(c.getColor(), c.getFillColor(), i);
             d.setColor(c.getColor());
             d.setFillColor(c.getFillColor());
             
              d.addShape(d);
              return d;
            
                
            }
               if(shapes.shape.get(i) instanceof Line){
              Line c = (Line) shapes.shape.get(i);;
              Point p1=new Point(c.p1.x,c.p1.y);
              Point p2=new Point(c.p2.x,c.p2.y);
              Line d=new Line(p1,p2);
            //  d.setColor(c.getColor(),c.getFillColor(), i);
              d.setColor(c.getColor());
              d.setFillColor(c.getFillColor());
              //c.p2.x=p2.x;
              //c.p2.y=p2.y;
              d.addShape(d);
              return d;
            }
               if(shapes.shape.get(i) instanceof REct){
              REct c = (REct) shapes.shape.get(i);
              Point p1=new Point(c.p1.x,c.p1.y);
               REct d=new REct(p1,c.w,c.h);
//              d.setColor(c.getColor(),c.getFillColor(), i);
              d.setColor(c.getColor());
              d.setFillColor(c.getFillColor());
              
              d.addShape(d);
              return d;
            }
                if(shapes.shape.get(i) instanceof Triangle){
              Triangle c = (Triangle) shapes.shape.get(i);
              Point p1=new Point(c.p1.x,c.p1.y);
              Point p2=new Point(c.p2.x,c.p2.y);
              Point p3=new Point(c.p3.x,c.p3.y);
              Triangle d=new Triangle(p1,p2,p3);
//              d.setColor(c.getColor(),c.getFillColor(), i);
              d.setColor(c.getColor());
              d.setFillColor(c.getFillColor());

              d.addShape(d);
return d;
                }   
               
                 
       
       
       
       
       
       
       
       
       return null;
   }
   
     @Override
    public  void setPosition(Point position) {
       p=position;
               }
    @Override
    public Point getPosition() {
        return p;
    }

    @Override
    public void setColor(Color color) {
        bcolor=color;
    }

    @Override
    public Color getColor() {
      return bcolor;  
    }

    @Override
    public void setFillColor(Color color) {
     fcolor=color;   
    }
    @Override
    public Color getFillColor() {
        return fcolor;
    }

    @Override
    public void setDraggingPoint(Point position) {
        dragpoint=position;
    }

    @Override
    public Point getDraggingPoint() {
       return dragpoint;
    }

   
                 
   
    
    }
    
    
    
    
    
    
    


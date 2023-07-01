/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paint;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author king
 */
public class Paint {
   

   public void save(String filename)
   {
       int i;
        JSONArray list=new JSONArray();
     
     for(i=0;i<Shapss.shapes.shape.size();i++)
     {
         JSONObject obj=new JSONObject(); 
      Shapss.Shape s=Shapss.shapes.shape.get(i);
      if (s instanceof Shapss.Circle){
           obj.put("sName", "Circle");
        Shapss.Circle c=(Shapss.Circle)s;
       
        Point p1=new Point(0,0);
        p1=c.getP1();
        int x=p1.x;
        int y=p1.y;
        obj.put("xpoint", Integer.toString(x));
        obj.put("ypoint", Integer.toString(y));
        int aa=c.getW();
        obj.put("w",Integer.toString(aa) );
        aa=c.getH();
        obj.put("h", Integer.toString(aa));
        Color co=c.getColor();
        int rgb=co.getRGB();
        obj.put("color", Integer.toString(rgb));
        co=c.getFillColor();
        rgb=co.getRGB();
        obj.put("fcolor", Integer.toString(rgb));
        //list.add(obj);
      }
       if (s instanceof Shapss.REct){
           obj.put("sName", "Rect");
        Shapss.REct c=(Shapss.REct)s;
        
       Point p1=new Point(0,0);
        p1=c.getP1();
        int x=p1.x;
        int y=p1.y;
        obj.put("xpoint", Integer.toString(x));
        obj.put("ypoint", Integer.toString(y));
        int aa=c.getW();
        obj.put("w",Integer.toString(aa) );
        aa=c.getH();
        obj.put("h", Integer.toString(aa));
        Color co=c.getColor();
        int rgb=co.getRGB();
        obj.put("color", Integer.toString(rgb));
        co=c.getFillColor();
        rgb=co.getRGB();
        obj.put("fcolor", Integer.toString(rgb));
        //list.add(obj);
       }
       if(s instanceof Shapss.Line)
       {
           obj.put("sName", "Line");
           Shapss.Line c=(Shapss.Line)s;
           
         Point p1=new Point(0,0);
        p1=c.getP1();
        int x=p1.x;
        int y=p1.y;
        obj.put("xpoint1", Integer.toString(x));
        obj.put("ypoint1", Integer.toString(y));
         p1=c.getP2();
         x=p1.x;
        y=p1.y;
        obj.put("xpoint2",Integer.toString(x) );
        obj.put("ypoint2",Integer.toString(y) );
        Color co=c.getColor();
        int rgb=co.getRGB();
        obj.put("color",Integer.toString(rgb));
  //      co=c.getFillColor();
//        obj.put("fcolor", co.toString());
        //list.add(obj);           
       }
       if(s instanceof Shapss.Triangle)
       {
              obj.put("sName", "Tri");
            Shapss.Triangle c=(Shapss.Triangle)s;
         
         Point p1=new Point(0,0);
        p1=c.getP1();
        int x=p1.x;
        int y=p1.y;
        obj.put("xpoint1",Integer.toString(x) );
        obj.put("ypoint1", Integer.toString(y));
         p1=c.getP2();
          x=p1.x;
         y=p1.y;
        obj.put("xpoint2",Integer.toString(x));
        obj.put("ypoint2",Integer.toString(y) );
        p1=c.getP3();
        x=p1.x;
         y=p1.y;
        obj.put("xpoint3",Integer.toString(x) );
        obj.put("ypoint3",Integer.toString(y) );
        Color co=c.getColor();
        int rgb=co.getRGB();
        obj.put("color", Integer.toString(rgb));
        co=c.getFillColor();
        rgb=co.getRGB();
        obj.put("fcolor", Integer.toString(rgb));
      //  list.add(obj);           
          
       }
         //System.out.println(obj.toString());
         
        
       list.add(obj);
      
     }
      // obj.put("Shapes", list);
       try(FileWriter g=new FileWriter(filename)){
           g.write(list.toString());
           g.flush();
           
           
       } catch (IOException ex) {
          ex.getStackTrace();
       }
       
   }
   public void read(String filename){
       JSONParser p=new JSONParser();
       try
       {
           Object ob=p.parse(new FileReader(filename));
          // JSONObject g=(JSONObject)ob;
           
           JSONArray a=(JSONArray)ob;
          // Iterator<Shapss.shapes> iterator=a.iterator();
           a.forEach( sh -> parseshape( (JSONObject) sh ) );
               
               
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException | ParseException ex) {
           Logger.getLogger(Paint.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       
       
       
       
       
       
   }
   public void parseshape(JSONObject s)
   {
    String shname = (String) s.get("sName");
         //System.out.println(shname);
         if(shname.equals("Circle"))
         {
            // System.out.println("Circle");
             String xp = (String) s.get("xpoint");   
             int x=Integer.parseInt(xp);
             String yp = (String) s.get("ypoint");
             int y=Integer.parseInt(yp);
             Point p=new Point(x,y);
        
         
            String w = (String) s.get("w");  
            int wi=Integer.parseInt(w);
             String h = (String) s.get("h");  
            int he=Integer.parseInt(h);
            
            String c=(String)s.get("color");
            int co= Integer.parseInt(c);
            Color col=new Color(co);
            String fc=(String)s.get("fcolor");
            int cd=Integer.parseInt(fc);
            Color cn=new Color(cd);
            Shapss.Circle cir=new Shapss.Circle(p, wi, he);
            cir.setColor(col);
            cir.setFillColor(cn);
            Graphics canvas;
            canvas=Drawingapp.g;
            cir.draw(canvas);
            cir.addShape(cir);
            
           
         }
        if(shname.equals("Rect")){
        
         String xp = (String) s.get("xpoint");    
        int x=Integer.parseInt(xp);
         String yp = (String) s.get("ypoint");
         int y=Integer.parseInt(yp);
         Point p=new Point(x,y);
         
         
        //Get employee last name
       String w = (String) s.get("w");  
        int wi=Integer.parseInt(w);
         String h = (String) s.get("h");  
        int he=Integer.parseInt(h);
        
        String c=(String)s.get("color");
        int co=Integer.parseInt(c);
          Color col=new Color(co);
        String fc=(String)s.get("fcolor");
        int cd=Integer.parseInt(fc);
        Color cn=new Color(cd);
        Shapss.REct re=new Shapss.REct(p, wi, he);
        re.setColor(col);
        re.setFillColor(cn);
        Graphics canvas;
            canvas=Drawingapp.g;
            re.draw(canvas);
            re.addShape(re);
        
        }
        if(shname.equals("Line")){
            String xp1 = (String) s.get("xpoint1");    
       int x1=Integer.parseInt(xp1);
       String yp1 = (String) s.get("ypoint1");
       int y1=Integer.parseInt(yp1);
       Point p1=new Point(x1,y1);
       String xp2 = (String) s.get("xpoint2");
       int x2=Integer.parseInt(xp2);
       String yp2 = (String) s.get("ypoint2");
       int y2=Integer.parseInt(yp2);
       Point p2=new Point(x2,y2);

        String c=(String)s.get("color");
       int col=Integer.parseInt(c);
       Color colo=new Color(col);
       Shapss.Line le=new Shapss.Line(p1, p2);
       le.setColor(colo);
             Graphics canvas;
            canvas=Drawingapp.g;
            le.draw(canvas);
            le.addShape(le);
            
        }
        if(shname.equals("Tri")){
                 String xp1 = (String) s.get("xpoint1");    
       int x1=Integer.parseInt(xp1);
       String yp1 = (String) s.get("ypoint1");
       int y1=Integer.parseInt(yp1);
       Point p1=new Point(x1,y1);
       String xp2 = (String) s.get("xpoint2");
       int x2=Integer.parseInt(xp2);
       String yp2 = (String) s.get("ypoint2");
       int y2=Integer.parseInt(yp2);
       Point p2=new Point(x2,y2);
        String xp3 = (String) s.get("xpoint3");
       int x3=Integer.parseInt(xp3);
       String yp3 = (String) s.get("ypoint3");
       int y3=Integer.parseInt(yp3);
       Point p3=new Point(x3,y3);
        String c=(String)s.get("color");
        int Col=Integer.parseInt(c);
        Color cooo=new Color(Col);
        String fc=(String)s.get("fcolor");   
        int colo=Integer.parseInt(fc);
        Color cololo=new Color(colo);
        Shapss.Triangle ti=new Shapss.Triangle(p1, p2, p3);
        ti.setColor(cooo);
         ti.setFillColor(cololo);
         Graphics canvas;
            canvas=Drawingapp.g;
            ti.draw(canvas);
            ti.addShape(ti);
         
        }
       
       
       
       
       
       
       
   }
}

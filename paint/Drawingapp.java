/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package paint;

import Shapss.Line;
import Shapss.Shape;
import Shapss.REct;
import Shapss.shapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author king
 */
public class Drawingapp extends javax.swing.JFrame implements Node {

    /**
     * Creates new form Drawingapp
     */
     
  public static Graphics g;
 public static  int shapei,nodei;
   String shapename;

    public Drawingapp() {
      initComponents();
      g=jPanel1.getGraphics();
      jPanel1.paintComponents(g);
      
      jPanel1.addMouseListener(new MouseAdapter()
      // addMouseListener(new MouseAdapter()
       {
         
          public void mousePressed(MouseEvent m)
          {
             Shapss.Circle c=new Shapss.Circle(null,0,0);
             
              int x1,y1;
              Point p=new Point(0,0);
              
              x1 = m.getX();
                y1 = m.getY();
                p.x=x1;
                p.y=y1;
                
                
              // Shapss.Shape.s.setPosition(p);
               c.setPosition(p);
               //repaint();
                System.out.println( "a" + x1  + "+" + y1);
                // repaint();
               c.setDraggingPoint(p);
              /*-------------
              if shapei > 0 then
                nodei=-1;
                Shapss.Circle c=(Shapss.Circle)shapes.shape.get(i) ;
                nodei=c.getnode(p);
......               
             
              ---------------------------*/
              
              shapei=0;
              jComboBox1.setSelectedIndex(shapei);
               
               
               Drawingapp.moveshape();
               
               
             
               jComboBox1.setSelectedIndex(shapei);
                
     
          }
          public void mouseReleased(MouseEvent m)
          {
               
            // xx g=jPanel1.getGraphics();
             // xxjPanel1.paintComponents(g);
             
               Shapss.Circle c=new Shapss.Circle(null,0,0);
         //      Drawingapp a = new Drawingapp();
               Point p = new Point(0,0);
               int   x2 = m.getX();
              int y2 = m.getY();
                 p.x=x2;
                 p.y=y2;
                 c.setDraggingPoint(p);
                // jPanel1.repaint();
      g.drawRect(0, 0, 1000, 1000);
      g.setColor(Color.white);
      g.fillRect(0, 0, 1000, 1000);
      //g=jPanel1.getGraphics();
    //  jPanel1.paintComponents(g);
     // jPanel1.repaint();
             Drawingapp.moveshape();
          //    c.setPosition(p);  
               //JOptionPane.showMessageDialog(null,"mouserrelease" + x2  + "+" + y2);
          }
        });

     jPanel1.addMouseMotionListener(new MouseMotionAdapter()
        {
          public void mouseDragged(MouseEvent m)
              {
                Shapss.Circle c=new Shapss.Circle(null,0,0);
         //     Drawingapp a = new Drawingapp();
               Point p = new Point(0,0);
               int   x2 = m.getX();
               int y2 = m.getY();
                 p.x=x2;
                 p.y=y2;
                c.setDraggingPoint(p);
                
                g.drawRect(0, 0, 1000, 1000);
                g.setColor(Color.white);
                g.fillRect(0, 0, 1000, 1000);
              Drawingapp.moveshape();
             c.setPosition(p);     
              }
          });
    }
          
 public static void moveshape(){
     Point p= new Point(0,0);
     Point p2=new Point(0,0);
     Point p3=new Point(0,0);
    Shapss.Circle d=new Shapss.Circle(null,0,0);
     p=d.getPosition();
     p2=d.getDraggingPoint();
     p3.x=p2.x-p.x;
     p3.y=p2.y-p.y;
     int i =0;
      
      Shapss.shapes s;
      //
      if( shapei == 0)
         {
             nodei=-1;
        for(i=shapes.shape.size()-1;i>=0;i--)
        {
            if(shapes.shape.get(i) instanceof Shapss.Circle)
            {
               Shapss.Circle c=(Shapss.Circle)shapes.shape.get(i) ;
              if( c.contains(p)==true)
              {  
                 nodei=c.getnode(p);
              // JOptionPane.showMessageDialog(null,"move" + p3);    
               c.moveTo(p3,i);
               shapei = i+1;
               
               break;
              }
                
            }
            if(shapes.shape.get(i) instanceof REct)
            {
               REct c=(REct)shapes.shape.get(i) ;
              if( c.contains(p)==true)
              {
                 nodei=c.getnode(p);
              // JOptionPane.showMessageDialog(null,"move" + p3);    
               c.moveTo(p3,i);
               shapei = i+1;
               break;
            
              
            }
            }
            
            
            if(shapes.shape.get(i) instanceof Line)
            {
               Line c=(Line)shapes.shape.get(i) ;
              if( c.contains(p)==true)
              {
                  nodei=c.getnode(p);
              // JOptionPane.showMessageDialog(null,"move" + p3);    
               c.moveTo(p3,i);
               shapei = i+1;
               break;
        }
            }
            if(shapes.shape.get(i) instanceof Shapss.Triangle)
            {
               Shapss.Triangle c=(Shapss.Triangle)shapes.shape.get(i) ;
              if( c.contains(p)==true)
              {
                  nodei=c.getnode(p);
              // JOptionPane.showMessageDialog(null,"move" + p3);    
               c.moveTo(p3,i);
               shapei = i+1;
               break;
              }
                
            }
        }
         }
        else
        {
        i=shapei-1;
        shapes c;
        c=(Shapss.shapes)shapes.shape.get(i);
             c.moveTo(p3, i);
                
                
                
                
                
                
                }
 
        //jPanel1.repaint();
        
      //g=jPanel1.getGraphics();
      //jPanel1.paintComponents(g);
      
       
      
        s= (shapes) Shapss.shapes.shape.get(0);
        
       s.refresh(g);
       if(shapei>0){
            s= (shapes) Shapss.shapes.shape.get(shapei-1);
           if(s instanceof Shapss.Circle){
     Shapss.Circle c=(Shapss.Circle)s;
     c.dborder((Graphics2D)g, shapei-1);
           }
            if(s instanceof Shapss.Line){
     Shapss.Line c=(Shapss.Line)s;
     c.dborder((Graphics2D)g, shapei-1);
           }
            if(s instanceof Shapss.REct){
     Shapss.REct c=(Shapss.REct)s;
     c.dborder((Graphics2D)g, shapei-1);
           }
            if(s instanceof Shapss.Triangle){
     Shapss.Triangle c=(Shapss.Triangle)s;
     c.dborder((Graphics2D)g, shapei-1);
           }
           
           
           
           
           
           
           
           
 }  
 }
            
  // public void setindex(int i)
   //{
       
     //  jComboBox1.setSelectedIndex(i);
       
       
   //}    
 
     
     
     
     

    
     
     
     
 
    
  public  Color getColor(String col) {
       Color color=null;
    switch (col.toLowerCase()) {
    case "black":
        color = Color.BLACK;
        break;
    case "blue":
        color = Color.BLUE;
        break;
    case "cyan":
        color = Color.CYAN;
        break;
    case "darkgray":
        color = Color.DARK_GRAY;
        break;
    case "gray":
        color = Color.GRAY;
        break;
    case "green":
        color = Color.GREEN;
        break;

    case "yellow":
        color = Color.YELLOW;
        break;
    case "lightgray":
        color = Color.LIGHT_GRAY;
        break;
    case "magneta":
        color = Color.MAGENTA;
        break;
    case "orange":
        color = Color.ORANGE;
        break;
    case "pink":
        color = Color.PINK;
        break;
    case "red":
        color = Color.RED;
        break;
    case "white":
        color = Color.WHITE;
        break;
        }
    return color;
    }
 
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vector Drawing Application");
        setBackground(new java.awt.Color(153, 153, 153));
        setName("frame"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );

        jButton1.setText("CIrcle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Line Segment");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Square");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Rectangle");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Colorize");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Shape");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Shape" }));
        jComboBox1.setToolTipText("Choose Shape");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton7.setText("Triangle");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Copy");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Save");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Load");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 15, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addGap(58, 58, 58)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jButton3)
                        .addGap(75, 75, 75)
                        .addComponent(jButton4))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)
                        .addGap(114, 114, 114))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here
        
       // jComboBox1.setSelectedIndex(shapei+1);
        
        
        
       shapei=jComboBox1.getSelectedIndex();
       shapename= (String) jComboBox1.getSelectedItem();
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        Circlea frame = new Circlea();
        frame.setVisible(true);
        
       
      frame.setparentNode(this);
      
      
     
  
     
        Shapss.Circle.circ++;
        String ce=Integer.toString(Shapss.Circle.circ);
        jComboBox1.addItem("Circle " + ce );   
         
         
       
        
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Linea frame = new Linea();
        frame.setVisible(true);
        
       
      frame.setparentNode(this);   
      Line.lc++;
        String ce=Integer.toString(Line.lc);
        jComboBox1.addItem("Line " + ce );
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
       Recta frame = new Recta();
        frame.setVisible(true);
        
       
      frame.setparentNode(this);        
        REct.rc++;
        String ce=Integer.toString(REct.rc);
        jComboBox1.addItem("Rect " + ce );
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         Squarea frame = new Squarea();
        frame.setVisible(true);
        
       
      frame.setparentNode(this);     
        REct.sc++;
        String ce=Integer.toString(REct.sc);
        jComboBox1.addItem("Square " + ce );
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        Color color;
        Color fcolor = null;
   // String cen=JOptionPane.showInputDialog(null, "Enter color (color)");
  //  ColorChooserExample ch=new ColorChooserExample();    
  //  ch.setSize(400,400);    
  //  ch.setVisible(true);    
  //  ch.setDefaultCloseOperation(EXIT_ON_CLOSE);    
  Colora frame=new Colora();
  frame.setVisible(true);
  frame.setparentNode(this);  
       
       shapes c = null;
       //JOptionPane.showMessageDialog(null,shapename + shapei);
      // if(shapei>0)
      // {
         // c= (shapes) shapes.shape.get(shapei-1);
         // JOptionPane.showMessageDialog(null,"10"+shapename + shapei);
         //while(true){
         // String cen=JOptionPane.showInputDialog(null, "Enter color (color,fcolor)");
          //String[] cir=cen.split(",");
          //color=this.getColor(cir[0]);
          //fcolor=this.getColor(cir[1]);
           //if((color instanceof Color)&&(fcolor instanceof Color))
           //break;
           //else
            //JOptionPane.showMessageDialog(null,"Entr again ");
           
         //}
         
         // c.setColor(Colora.color, Colora.fcolor, shapei-1 );
          
       // }
         
     //  Shapss.shapes s = null;
       jPanel1.repaint();
      // Drawingapp a=new Drawingapp();
       g=jPanel1.getGraphics();
       jPanel1.paintComponents(g);
       //JOptionPane.showMessageDialog(null,"Set Color & Refresh "+shapename);
     // if(Shapss.shapes.shape.size()>0)
     // {
         // s=(Shapss.shapes) shapes.shape.get(0);
          //s.refresh(g);
          //JOptionPane.showMessageDialog(null, "Enter point2 (x2,y2)");
     // } 
       
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       //TODO add your handling code here:
       shapes c = null;
       //JOptionPane.showMessageDialog(null,shapename + shapei);
       if(shapei>0)
       {
          c= (shapes) shapes.shape.get(shapei-1);
          //JOptionPane.showMessageDialog(null,"10"+shapename + shapei);
          c.removeShape((Shape) c);
          //JOptionPane.showMessageDialog(null,"20"+shapename + shapei);
         // c.removeShape(shapes.shape.get(shapei-1)); 
          jComboBox1.removeItem(shapename);
          //JOptionPane.showMessageDialog(null,"30"+shapename + shapei);
          
        }
         
      shapes s = null;
       jPanel1.repaint();
      // Drawingapp a=new Drawingapp();
       g=jPanel1.getGraphics();
       jPanel1.paintComponents(g);
      JOptionPane.showMessageDialog(null,"Delete & Refresh " );
      if(shapes.shape.size()>0){
         s=(shapes) shapes.shape.get(0);
          s.refresh(g);
          
          //JOptionPane.showMessageDialog(null, "deleted");
      } 
        
        
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
     Trianglea frame = new Trianglea();
        frame.setVisible(true);
        
      // int [] x = {50,100,0};
      //  int [] y = {0,100,100};
        //g.drawPolygon(x, y, 3);

      frame.setparentNode(this);     
        Shapss.Triangle.tri++;
        String ce=Integer.toString(Shapss.Triangle.tri);
        jComboBox1.addItem("Triangle " + ce );   
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Shape s;
        int i=0;
        
        if(shapei>0)
        {
          i=shapei-1;
          
        
            if(shapes.shape.get(i) instanceof Shapss.Circle){
              Shapss.Circle c = (Shapss.Circle) shapes.shape.get(i);
             Shapss.Circle d;
             d=(Shapss.Circle)c.copy(i);
             d.draw(g);
               //d.addShape(d);
                Shapss.Circle.circ++;
        String ce=Integer.toString(Shapss.Circle.circ);
        jComboBox1.addItem("Circle " + ce );
               
                
            }
            if(shapes.shape.get(i) instanceof REct)
            {
                
                REct c=(REct)shapes.shape.get(i) ;
                REct d;
                d=(REct)c.copy(i);
               d.draw(g);
              // d.addShape(d);
                 String h= jComboBox1.getItemAt(shapei);
                System.out.println(h);
                if(h.startsWith("Square"))
                {
                    REct.sc++;
                    String ce=Integer.toString(REct.sc);
        jComboBox1.addItem("Square " + ce );}
                else   { 
                REct.rc++;
        String ce=Integer.toString(REct.rc);
        jComboBox1.addItem("Rect " + ce );}
            }
            
            
            if(shapes.shape.get(i) instanceof Line)
            {
                
                Line c=(Line)shapes.shape.get(i) ;
                Line d;
               d=(Line)c.copy(i);
               d.draw(g);
             //  d.addShape(d);
                Line.lc++;
        String ce=Integer.toString(Line.lc);
        jComboBox1.addItem("Line " + ce );
            }
            if(shapes.shape.get(i) instanceof Shapss.Triangle)
            {
                
                Shapss.Triangle c=(Shapss.Triangle)shapes.shape.get(i) ;
               Shapss.Triangle d;
               d=(Shapss.Triangle)c.copy(i);
               d.draw(g);
             //  d.addShape(d);
                 Shapss.Triangle.tri++;
        String ce=Integer.toString(Shapss.Triangle.tri);
        jComboBox1.addItem("Triangle " + ce );
            }  
            
        }            
    }//GEN-LAST:event_jButton8ActionPerformed
  
 
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Paint s = new Paint();
        JFileChooser a=new JFileChooser();
        FileNameExtensionFilter e=new FileNameExtensionFilter("only.json files", "json");
        a.addChoosableFileFilter(e);
        int f=a.showSaveDialog(null);
        
        if(f==JFileChooser.APPROVE_OPTION)
        s.save(a.getSelectedFile().getAbsolutePath());
        else
            JOptionPane.showMessageDialog(null,"Save Camcelled" );
            
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int i;
        Shapss.shapes.shape.clear();
        Shapss.Circle.circ=0;
        Shapss.Line.lc=0;
        Shapss.REct.rc=0;
        Shapss.REct.sc=0;
        Shapss.Triangle.tri=0;
        //jComboBox1.removeAllItems();
        //jComboBox1.addItem("Choose Shape");
          //   g.drawRect(0, 0, 1000, 1000);
            //    g.setColor(Color.white);
              //  g.fillRect(0, 0, 1000, 1000);
        Paint s = new Paint();
        JFileChooser a=new JFileChooser();
        FileNameExtensionFilter e=new FileNameExtensionFilter("only.json files", "json");
        a.addChoosableFileFilter(e);
        int f=a.showOpenDialog(null);
        
        if(f==JFileChooser.APPROVE_OPTION){
            jComboBox1.removeAllItems();
        jComboBox1.addItem("Choose Shape");
             g.drawRect(0, 0, 1000, 1000);
                g.setColor(Color.white);
                g.fillRect(0, 0, 1000, 1000);
        s.read(a.getSelectedFile().getAbsolutePath());
        
        }
        else
            JOptionPane.showMessageDialog(null,"Load Cancelled " );
        
        for(i=0;i<Shapss.shapes.shape.size();i++){
            if(Shapss.shapes.shape.get(i) instanceof Shapss.Circle)
            {
                Shapss.Circle.circ++;
        String ce=Integer.toString(Shapss.Circle.circ);
        jComboBox1.addItem("Circle " + ce );
            }
            if(Shapss.shapes.shape.get(i) instanceof Shapss.REct)
            {
                Shapss.REct.rc++;
       String ce=Integer.toString(REct.rc);
        jComboBox1.addItem("Rect " + ce );
             
            
        }
            if(Shapss.shapes.shape.get(i) instanceof Shapss.Line)
            {
                Line.lc++;
        String ce=Integer.toString(Line.lc);
        jComboBox1.addItem("Line " + ce );
                  
            }
          if(Shapss.shapes.shape.get(i) instanceof Shapss.Triangle)
          {
             Shapss.Triangle.tri++;
        String ce=Integer.toString(Shapss.Triangle.tri);
        jComboBox1.addItem("Triangle " + ce ); 
          }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Drawingapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Drawingapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Drawingapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Drawingapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Drawingapp().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public Node getparentNode() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setparentNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}

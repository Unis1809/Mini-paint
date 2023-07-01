/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Shapss;

/**
 *
 * @author king
 */
public interface Moveable {
    public void setDraggingPoint(java.awt.Point position); 
    public java.awt.Point getDraggingPoint();
    public boolean contains(java.awt.Point position);
    public void moveTo(java.awt.Point position);
    
    
}

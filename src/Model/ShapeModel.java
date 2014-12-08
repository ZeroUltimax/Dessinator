/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Antoine
 */
public class ShapeModel {

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    private ShapeList shapes;

    private boolean hasSelected;

    private Point mouseDown, mouseUp;

    public ShapeModel(){
        this.shapes = new ShapeList();
    }
    
    public ShapeList getShapes() {
        return shapes;
    }

    public boolean hasSelected() {
        return hasSelected;
    }
    
    private void setHasSelected(){
     boolean oldHasSelected = hasSelected;
        
        hasSelected = shapes.stream().anyMatch(s->s.isSelected());
        
        pcs.firePropertyChange("hasSelected", oldHasSelected, hasSelected);
    }

    public void unselectAll(){
        shapes.stream().forEach(s->{
            s.setSelected(false);
        });
    }
    
    public void setSelectedByRectangle() {
        
        Rectangle bounds = getRectangle();
        
        shapes.stream().forEach(s->{
            s.setSelected(s.intersectsBounds(bounds));
        });
               setHasSelected();
       
    }

    public ShapeList getSelectedShapes() {
        List<Shape> selected = shapes.stream().collect(Collectors.toList());
        return new ShapeList(selected);
    }

    public Rectangle getRectangle() {
        int left = Math.min(mouseDown.x, mouseUp.x);
        int up = Math.min(mouseDown.y, mouseUp.y);

        int width = Math.abs(mouseDown.x - mouseUp.x);
        int height = Math.abs(mouseDown.y - mouseUp.y);

        return new Rectangle(left, up, width, height);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    public void setMouseDown(Point point) {
        this.mouseDown = point;
    }

    public void setMouseUp(Point point) {
        this.mouseUp = point;
    }

    public void addShape(String shapeName) {
        unselectAll();
        switch(shapeName){
            case "Rectangle":
                shapes.addLast(new RectangleShape(getRectangle(), Color.yellow));
                break;
            case "Oval":
                shapes.addLast(new OvalShape(getRectangle(), Color.green));
                break;
        }
        
        setHasSelected();
    }

}

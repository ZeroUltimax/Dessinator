package Controller;

import Actions.NullAction;
import Model.ShapeModel;
import dessinator.Dessinator;

import java.awt.*;
import java.awt.event.*;
import java.util.TreeMap;
import javax.swing.Action;
import javax.swing.event.MouseInputListener;

public class DessinatorController implements MouseInputListener, ActionListener {

    private ShapeModel model;

    private Dessinator frame;

    private String currentState;

    private TreeMap<String, Action> actions; // All actions used by the application

    private boolean dragged;

    private DessinatorController() {
        this.model = new ShapeModel();
       
        
        this.actions = new TreeMap<>();
        
        // Create actions here
        
        
        
        this.frame = new Dessinator(this);
        this.frame.getCanvas().setToDraw(this.model.getShapes());
        
        this.setState("Arrow Select");
    }

    public static void main(String[] args) {
        DessinatorController c = new DessinatorController();
    }

    private void setState(String state) {
        this.currentState = state;
        switch (state) {
            case "Arrow Select":
            case "Oval":
            case "Rectangle":
                frame.setActiveButton(state);
        }
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        model.setMouseDown(arg0.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
         model.setMouseUp(arg0.getPoint());
        this.tryAction();
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
        this.dragged = true;
        model.setMouseUp(arg0.getPoint());
        this.drawDrag(arg0.getPoint());

    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        this.dragged = false;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.setState(arg0.getActionCommand());
    }

    private void tryAction() {
        if (this.dragged) {
            switch (currentState) {
                case "Arrow Select":
                    doSelect(model.getRectangle());
                    break;
                case "Oval":
                    doDrawOval(model.getRectangle());
                    break;
                case "Rectangle":
                    doDrawRectangle(model.getRectangle());
                    break;
            }

        }

        this.frame.getCanvas().setDragRectangle(null);
        this.dragged = false;

        doRepaint();
    }

    private void drawDrag(Point endPoint) {

        this.frame.getCanvas().setDragRectangle(model.getRectangle());

        doRepaint();

    }

    private void doSelect(Rectangle actionRectangle) {
        model.setSelectedByRectangle();
    }

    private void doDrawRectangle(Rectangle actionRectangle) {
        model.addShape("Rectangle");
        doRepaint();
    }

    private void doDrawOval(Rectangle actionRectangle) {
        model.addShape("Oval");

        doRepaint();
    }

    private void doRepaint() {
        this.frame.getCanvas().repaint();
    }

    public Action getAction(String actionName) {
        System.out.println(actions);
        return actions.getOrDefault(actionName, new NullAction(actionName));
    }

}

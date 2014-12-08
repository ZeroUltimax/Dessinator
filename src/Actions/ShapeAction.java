/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Model.ShapeModel;
import Model.Shape;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.function.BiConsumer;
import javax.swing.AbstractAction;

/**
 *
 * @author Antoine
 */
public class ShapeAction extends AbstractAction implements PropertyChangeListener{
    private ShapeModel model;
    private BiConsumer<Shape, ShapeModel> action;
    

    public ShapeAction(String actionCommand, ShapeModel model, BiConsumer<Shape, ShapeModel> action){
        this.model = model;
        this.action = action;
        model.addPropertyChangeListener(this);
    }
        
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.isEnabled()){
            model.getSelectedShapes().stream().forEach(shape -> action.accept(shape,model));
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        switch(pce.getPropertyName()){
            case "hasSelected":
                this.setEnabled((boolean) pce.getNewValue()); // Action is only enabled is there is at least one selected shape
                break;
        }
    }
    
}

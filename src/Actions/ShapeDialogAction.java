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
public class ShapeDialogAction extends AbstractAction implements PropertyChangeListener{
    
    private ShapeModel model;
    
    

    public ShapeDialogAction(String actionCommand, ShapeModel model){
        this.model = model;
        model.addPropertyChangeListener(this);
    }
        
    @Override
    public void actionPerformed(ActionEvent ae) {
        
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

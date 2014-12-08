
package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 *
 * @author Antoine
 */
public class NullAction extends AbstractAction{

    public NullAction(String actionName) {
       this.putValue(Action.NAME, actionName);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    
}

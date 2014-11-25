package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Antoine
 */
public class RectangleShape extends Shape {

	public RectangleShape(Rectangle bounds, Color color) {
		super(bounds, color);
	}

	@Override
	public void drawTo(Graphics g) {
		g.setColor(this.getColor());
		g.fillRect(this.getBounds().x, this.getBounds().y, this.getBounds().width, this.getBounds().height);
		
		if(isSelected()){
			g.setColor(SELECTED_BORDER_COLOR);
			g.drawRect(this.getBounds().x, this.getBounds().y, this.getBounds().width, this.getBounds().height);
		}
	}

}

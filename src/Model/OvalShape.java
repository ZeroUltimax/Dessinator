package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class OvalShape extends Shape {

	public OvalShape(Rectangle bounds, Color color) {
		super(bounds, color);
	}

	@Override
	public void drawTo(Graphics g) {
		g.setColor(this.getColor());
		g.fillOval(this.getBounds().x, this.getBounds().y, this.getBounds().width, this.getBounds().height);
		
		if(isSelected()){
			g.setColor(SELECTED_BORDER_COLOR);
			g.drawOval(this.getBounds().x, this.getBounds().y, this.getBounds().width, this.getBounds().height);
		}
		
	}
}

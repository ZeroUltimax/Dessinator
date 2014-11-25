package dessinator;

import Model.ShapeList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class DessinatorCanvas extends JPanel {

	private ShapeList toDraw;

	private Rectangle dragRectangle;

	public DessinatorCanvas(MouseInputListener listener) {
		super();
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.toDraw = new ShapeList();
		this.dragRectangle = null;
	}

	@Override
	public void paintComponent(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		toDraw.drawTo(g);

		if (dragRectangle != null) {
			g.setColor(Color.LIGHT_GRAY);
			g.drawRect(dragRectangle.x, dragRectangle.y, dragRectangle.width, dragRectangle.height);
		}
	}

	public void setToDraw(ShapeList toDraw) {
		this.toDraw = toDraw;
	}

	public void setDragRectangle(Rectangle dragRectangle) {
		this.dragRectangle = dragRectangle;
	}

}

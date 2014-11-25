package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Shape {

	private Rectangle bounds;
	private Color color;

	private boolean selected;

	protected static Color SELECTED_BORDER_COLOR = Color.BLACK;

	public Shape(Rectangle bounds, Color color) {
		this.bounds = bounds;
		this.color = color;

		this.selected = true; // Just created shape is selected by default
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public Color getColor() {
		return color;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public abstract void drawTo(Graphics g);

	public boolean intersectsBounds(Rectangle r) {
		return this.bounds.intersects(r);
	}

}

package Controller;

import Model.OvalShape;
import Model.RectangleShape;
import Model.ShapeList;
import java.awt.event.*;

import javax.swing.event.MouseInputListener;

import dessinator.Dessinator;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

public class DessinatorController implements MouseInputListener, ActionListener {

	private ShapeList shapes;

	private Dessinator frame;

	private String currentState;

	private Point down, up;

	private boolean dragged;

	private DessinatorController() {
		this.shapes = new ShapeList();
		this.frame = new Dessinator(this);
		this.frame.getCanvas().setToDraw(this.shapes);
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

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
		this.down = arg0.getPoint();
	}

	public void mouseReleased(MouseEvent arg0) {
		this.up = arg0.getPoint();
		this.tryAction();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		this.dragged = true;
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

	private static Rectangle getRectangle(Point a, Point b) {
		int left = Math.min(a.x, b.x);
		int up = Math.min(a.y, b.y);

		int width = Math.abs(a.x - b.x);
		int height = Math.abs(a.y - b.y);

		return new Rectangle(left, up, width, height);
	}

	private void tryAction() {
		doUnselectAll();
		if (this.dragged) {
			Rectangle actionRectangle = getRectangle(down, up);

			switch (currentState) {
				case "Arrow Select":
					doSelect(actionRectangle);
					break;
				case "Oval":
					doDrawOval(actionRectangle);
					break;
				case "Rectangle":
					doDrawRectangle(actionRectangle);
					break;
			}

		}

		this.frame.getCanvas().setDragRectangle(null);
		this.dragged = false;

		doRepaint();
	}

	private void drawDrag(Point endPoint) {

		this.frame.getCanvas().setDragRectangle(getRectangle(down, endPoint));

		doRepaint();

	}

	private void doUnselectAll() {
		shapes.setSelected(false);
	}

	private void doSelect(Rectangle actionRectangle) {
		shapes.getIntersecting(actionRectangle).setSelected(true);
	}

	private void doDrawRectangle(Rectangle actionRectangle) {
		shapes.addLast(new RectangleShape(actionRectangle, Color.yellow));

		doRepaint();
	}

	private void doDrawOval(Rectangle actionRectangle) {
		shapes.addLast(new OvalShape(actionRectangle, Color.green));

		doRepaint();
	}

	private void doRepaint() {
		this.frame.getCanvas().repaint();
	}

}

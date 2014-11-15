import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.io.Serializable;

public  class DessinatorShape implements Serializable{
	public static enum Type {RECT, ELLIPSE};
	// couleur qu'aura le prochain objet dessiné
	private static Color couleurCourante;
	private boolean selected;
	private RectangularShape rs; // référence à l'objet dessiné
	// champs pour la couleur de l'objet et son type
	private Color couleur; // la couleur de l'objet
	private Type type; // type de forme géométrique
	
	/**
	 * Constructeur, qui selon le type passé en argument, va initialiser rs avec une 
	 * ellipse ou un rectangle.  
	 * @param td le type de forme géométrique à créer
	 * @param x la position
	 * @param y la position
	 * @param w la largeur
	 * @param h la hauteur
	 */
	public DessinatorShape(Type td, double x, double y, double w, double h) {
		if(td == Type.RECT){
			this.rs = new Rectangle2D.Double();
			type = Type.RECT;
		}
		if(td == Type.ELLIPSE){
			this.rs = new Ellipse2D.Double();
			type = Type.ELLIPSE;
		}
		if(w < 0 && h >= 0)
			this.rs.setFrame(x+w, y, -x, h);
		if(w < 0 && h < 0)
			this.rs.setFrame(x+w, y+h, -x, -y);
		if(w >= 0 && h < 0)
			this.rs.setFrame(x, y+h, w, -y);
		if(w >= 0 && h >= 0)
			this.rs.setFrame(x, y, w, h);
		this.couleur = couleurCourante;
		
		
	}
	
	public DessinatorShape(Type td){
		this(td, 0,0,0,0);
	}
	
	public static void setCouleurCourante(Color c) {
		couleurCourante = c;
	}
	
	public static Color getCouleurCourante() {
		return couleurCourante;
	}
	
	public void dessine(Graphics2D g) {
		g.setColor(this.getCouleur());
		g.fill(rs);
		double side = 4;
		if(selected == true){
			g.setColor(Color.BLACK);
			g.fill(new Rectangle2D.Double(
					rs.getCenterX()-side/2, rs.getY()-side/2, side, side));
			g.fill(new Rectangle2D.Double(
					rs.getX()-side/2, rs.getCenterY()-side/2, side, side));
			g.fill(new Rectangle2D.Double(
					rs.getCenterX()-side/2, rs.getY()+rs.getHeight()-side/2, side, side));
			g.fill(new Rectangle2D.Double(
					rs.getX()+rs.getWidth()-side/2, rs.getCenterY()-side/2, side, side));
			g.draw(rs);
		}
	}

	public void setSelected(boolean b) {
		selected = b;
	}

	public void setCouleur(Color c){
		couleur = c;
	}

	public Color getCouleur(){
		return couleur;
	}
	
	public boolean isSelected() {
		return selected;
	}

	// méthodes qui seront redirigées vers rs
	public boolean contains(Point2D p) {
		return rs.contains(p);
	}
	
	public double getWidth() {
		return rs.getWidth();
	}

	public double getX() {
		return rs.getX();
	}

	public double getHeight() {
		return rs.getHeight();
	}

	public double getY() {
		return rs.getY();
	}
	
	public Type getType(){
		return this.type;
	}

	public void moveBy(double dx, double dy) {
			this.rs.setFrame(getX()+dx, getY()+dy, getWidth(), getHeight());
	}

	public void setFrameFromDiagonal(Point2D lastPointPress, Point2D p) {
		double x = lastPointPress.getX();
		double y = lastPointPress.getY();
		double dx = p.getX()-x;
		double dy = p.getY()-y;
		if(dx < 0 && dy >= 0)
			this.rs.setFrame(x+dx, y, -dx, dy);
		if(dx < 0 && dy < 0)
			this.rs.setFrame(x+dx, y+dy, -dx, -dy);
		if(dx >= 0 && dy < 0)
			this.rs.setFrame(x, y+dy, dx, -dy);
		if(dx >= 0 && dy >= 0)
			this.rs.setFrame(x, y, dx, dy);
	}
}
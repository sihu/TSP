import java.awt.geom.Line2D;


public class Vertex {

	private double xCoord, yCoord;
	private int id;
	
	public Vertex(double xCoord2, double yCoord2, int id) {
		this.xCoord = xCoord2;
		this.yCoord = yCoord2;
		this.id = id;
	}
	
	public double getX() {
		return xCoord;
	}
	
	public double getY() {
		return yCoord;
	} 
	
	public int getID() {
		return id;
	}
	
	public String toString(){
		return "(" + xCoord + ", " + yCoord + ")";
	}
	
	public float distanceTo(Vertex v) {
		return (float) Math.sqrt(Math.pow((getX() - v.getX()),2)
				+ Math.pow((getY() - v.getY()),2));
	}
	public Line2D getLineRepresentation(Vertex v) {
		return new Line2D.Double(getX(), getY(), v.getX(), v.getY());
	}
	public boolean equals(Vertex v) {
		return getX() == v.getX() && getY() == v.getY();
	}
}

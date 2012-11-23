import java.awt.geom.Line2D;


public class Vertex {

	private float xCoord, yCoord;
	private int id;
	
	public Vertex(float xCoord, float yCoord, int id) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.id = id;
	}
	
	public float getX() {
		return xCoord;
	}
	
	public float getY() {
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
		return new Line2D.Float(getX(), getY(), v.getX(), v.getY());
	}
	public boolean equals(Vertex v) {
		return getX() == v.getX() && getY() == v.getY();
	}
}

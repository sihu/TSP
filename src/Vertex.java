
public class Vertex {

	private float xCoord, yCoord;
	
	public Vertex(float xCoord, float yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	public float getX() {
		return xCoord;
	}
	
	public float getY() {
		return yCoord;
	}
	
	public String toString(){
		return xCoord + " " + yCoord;
	}
	
	public float distanceTo(Vertex v) {
		return (float) Math.sqrt(Math.pow((getX() - v.getX()),2)
				+ Math.pow((getY() - v.getY()),2));
	}
}

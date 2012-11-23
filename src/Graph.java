
public class Graph {

	public Vertex[] vertices;
	private float[][] distanceMatrix;
	
	public Graph(Vertex[] vertices, float[][] distanceMatrix) {
		this.vertices = vertices;
		this.distanceMatrix = distanceMatrix;
	}
	
	public float distanceBetween(Vertex v, Vertex v2) {
		return distanceMatrix[v.getID()][v2.getID()];
	}
}
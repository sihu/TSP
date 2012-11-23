
public class Graph {

	public Vertex[] vertices;
	private float[][] distanceMatrix;
	
	public Graph(Vertex[] vertices, float[][] distanceMatrix) {
		this.vertices = vertices;
		this.distanceMatrix = distanceMatrix;
	}
	
	public float distanceBetween(int v1, int v2) {
		return distanceMatrix[v1][v2];
	}
	
	public Vertex getVertex(int id) {
		return vertices[id];
	}
	
	public float getWeight(Path path) {
		float f = 0;
		for (int i = 0; i < path.getLength()-1; i++) {
			f += distanceBetween(path.getPath()[i], path.getPath()[i+1]);
		}
		return f;
	}
}
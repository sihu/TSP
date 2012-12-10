import java.util.ArrayList;
import java.util.TreeMap;

public class Graph {

	public Vertex[] vertices;
	public float[][] distanceMatrix;
	private ArrayList<int[]> closestNeighbours;

	public Graph(Vertex[] vertices, float[][] distanceMatrix) {
		this.vertices = vertices;
		this.distanceMatrix = distanceMatrix;
		closestNeighbours = new ArrayList<int[]>();
	}

	public float distanceBetween(int v1, int v2) {
		return distanceMatrix[v1][v2];
	}

	public Vertex getVertex(int id) {
		return vertices[id];
	}

	public void buildClosestNeighbours() {
		
		int numClosestNeighbours;
		
		if (vertices.length > 100)
			numClosestNeighbours = 100;
		else
			numClosestNeighbours = vertices.length/2;
		
		TreeMap<Float, Integer> tree = new TreeMap<Float, Integer>();
		
		for (int i = 0; i < vertices.length; i++) {
			closestNeighbours.add(new int[numClosestNeighbours]);
			
			for (int j = 0; j < distanceMatrix[i].length; j++) {
				tree.put(distanceMatrix[i][j],j);
			}
			
			tree.pollFirstEntry();
			
			for (int k = 0; k < numClosestNeighbours-1; k++) {
				closestNeighbours.get(i)[k] = tree.pollFirstEntry().getValue();
			}
			
			tree.clear();
		}
	}

	public int[] getClosestNeighbours(int id) {
		return closestNeighbours.get(id);
	}

	public float getWeight(Path path) {
		float f = 0;
		for (int i = 0; i < path.getLength()-1; i++) {
			f += distanceBetween(path.getPath()[i], path.getPath()[i+1]);
		}
		f+= distanceBetween(path.getPath()[path.getLength()-1], 0);
		return f;
	}
}
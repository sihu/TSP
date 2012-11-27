import java.util.ArrayList;
import java.util.TreeMap;


public class Graph {

	public Vertex[] vertices;
	private float[][] distanceMatrix;
	private ArrayList<TreeMap<Float, Integer>> idsToIdsSortedByDistance;
	
	public Graph(Vertex[] vertices, float[][] distanceMatrix) {
		this.vertices = vertices;
		this.distanceMatrix = distanceMatrix;
		idsToIdsSortedByDistance = new ArrayList<TreeMap<Float, Integer>>();
	}
	
	public float distanceBetween(int v1, int v2) {
		return distanceMatrix[v1][v2];
	}
	
	public Vertex getVertex(int id) {
		return vertices[id];
	}
	
	public void buildSortedTreeFromDistanceMatrix() {
		for (int i = 0; i < vertices.length; i++) {
			idsToIdsSortedByDistance.add(i,new TreeMap<Float, Integer>());
			for (int j = 0; j < distanceMatrix[i].length; j++) {
				idsToIdsSortedByDistance.get(i).put(distanceMatrix[i][j],j);
			}
		}	
	}
	
	public ArrayList<TreeMap<Float,Integer>> getIdsToIdsSortedByDistance() {
		return idsToIdsSortedByDistance;
	}
	
	public float getWeight(Path path) {
		float f = 0;
		for (int i = 0; i < path.getLength()-1; i++) {
			f += distanceBetween(path.getPath()[i], path.getPath()[i+1]);
		}
		return f;
	}
}
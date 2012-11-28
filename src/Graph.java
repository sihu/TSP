import java.util.ArrayList;
import java.util.TreeMap;

public class Graph {

	public Vertex[] vertices;
	private float[][] distanceMatrix;
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
		TreeMap<Float, Integer> tree = new TreeMap<Float, Integer>();
		
		for (int i = 0; i < vertices.length; i++) {
			closestNeighbours.add(new int[400]);
			
			for (int j = 0; j < distanceMatrix[i].length; j++) {
				tree.put(distanceMatrix[i][j],j);
			}
			
			tree.pollFirstEntry();
			
			for (int k = 0; k < 399; k++) {
				closestNeighbours.get(i)[k] = tree.pollFirstEntry().getValue();
			}
			
			tree.clear();
//			if (TSP.DEBUG) {
//				System.out.println("Closest neigbours to " + i + ":");
//				for (Float key : idsToIdsSortedByDistance.get(i).keySet()) {
//					System.out.print(idsToIdsSortedByDistance.get(i).get(key) + ", ");
//				}
//				System.out.println("\n");
//			}
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
		return f;
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TSP {

	private BufferedReader in;
	static boolean DEBUG = false;

	public static void main(String[] args) {
		TSP tsp = new TSP();
		long startTime = System.currentTimeMillis();

		Graph graph = tsp.readInstance();
		if (DEBUG)  {
			System.out.println("Read TSP instance (" + (System.currentTimeMillis() - startTime) + " ms)");
			startTime = System.currentTimeMillis();
		}

		Path path = NearestNeighbour.getNaivePath(graph);
		if (DEBUG) {
			System.out.println("Calculated naive path (nearest neighbour) (" + (System.currentTimeMillis() - startTime) + " ms)");
			startTime = System.currentTimeMillis();
			tsp.drawGUI(graph, path, "Greedy Tour");
		}
		
//		float oldWeight = Float.MAX_VALUE;
//		while (graph.getWeight(path) < oldWeight) {
//			oldWeight = graph.getWeight(path);
//			TwoOpt.optimizePath(graph, path, startTime);
//		}
//		if (DEBUG) {
//			System.out.println("Optimized path with Intersection-based 2-opt (" + (System.currentTimeMillis() - startTime) + " ms)");
//			startTime = System.currentTimeMillis();
//			tsp.drawGUI(graph, path, "Intersection-based 2-opt");
//		}

		float oldWeight = Float.MAX_VALUE;
		while (graph.getWeight(path) < oldWeight) {
			oldWeight = graph.getWeight(path);
			path = GeneralTwoOpt.optimizePath(graph, path, startTime);
		}
		if (DEBUG) {
			System.out.println("Optimized path with general 2-opt (" + (System.currentTimeMillis() - startTime) + " ms)");
			startTime = System.currentTimeMillis();
			tsp.drawGUI(graph, path, "General 2-opt");
		}
		System.out.println(path.toString());
	}

	TSP() {
		in = new BufferedReader(new InputStreamReader(System.in));
	} 

	private void drawGUI(Graph g, Path p, String name) {
		new GUI(g, p.clone(), name);
	}

	private Graph readInstance() {
		try {
			int m = Integer.valueOf(in.readLine());
			Vertex[] vertices = new Vertex[m];
			float[][] distanceMatrix = new float[m][m];

			for (int i = 0; i < m; i++) {
				String[] vertex = in.readLine().split(" ");
				float xCoord = Float.valueOf(vertex[0]);
				float yCoord = Float.valueOf(vertex[1]);			
				vertices[i] = new Vertex(xCoord,yCoord,i);
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m; j++) {
					distanceMatrix[i][j] = vertices[i].distanceTo(vertices[j]);
				}
			}
			return new Graph(vertices, distanceMatrix);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
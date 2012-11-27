
public class TSP {

	private Kattio io;
	static boolean DEBUG = false;

	public static void main(String[] args) {
		TSP tsp = new TSP();
		long startTime = System.currentTimeMillis();

		Graph graph = tsp.readInstance();
		graph.buildSortedTreeFromDistanceMatrix();
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
		System.out.println(path.toString());
		System.out.println(graph.getWeight(path));

		float oldWeight = Float.MAX_VALUE;
		while (graph.getWeight(path) < oldWeight) {
			oldWeight = graph.getWeight(path);
			TwoOpt.optimizePath(graph, path, startTime);
		}
		if (DEBUG) {
			System.out.println("Optimized path with Intersection-based 2-opt (" + (System.currentTimeMillis() - startTime) + " ms)");
			startTime = System.currentTimeMillis();
			tsp.drawGUI(graph, path, "Intersection-based 2-opt");
		}

		oldWeight = Float.MAX_VALUE;
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
		io = new Kattio(System.in);
	} 

	private void drawGUI(Graph g, Path p, String name) {
		new GUI(g, p.clone(), name);
	}

	private Graph readInstance() {
			int m = io.getInt();
			Vertex[] vertices = new Vertex[m];
			float[][] distanceMatrix = new float[m][m];

			for (int i = 0; i < m; i++) {
				double xCoord = io.getDouble();
				double yCoord = io.getDouble();			
				vertices[i] = new Vertex(xCoord,yCoord,i);
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m; j++) {
					distanceMatrix[i][j] = vertices[i].distanceTo(vertices[j]);
				}
			}
			return new Graph(vertices, distanceMatrix);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TSP {

	BufferedReader in;
	Graph graph;
	Path path;
	//	TwoOpt twoOpt;
	boolean DEBUG = false;
	long startTime;

	public static void main(String[] args) {
		new TSP();
	}

	TSP() {
		startTime = System.currentTimeMillis();
		in = new BufferedReader(new InputStreamReader(System.in));
		readInstance();
		path = NearestNeighbour.getNaivePath(graph);

		if (DEBUG) {
			System.out.println("Weight: " + graph.getWeight(path));
			//			System.out.println(path.toString());
			drawGUI("Greedy Tour");
		}

//		float oldWeight = Float.MAX_VALUE;
//		while (graph.getWeight(path)< oldWeight) {
//			oldWeight = graph.getWeight(path);
//			TwoOpt.optimizePath(graph, path, startTime);
//		}
//		if (DEBUG)
//			System.out.println("Weight: " + graph.getWeight(path));
//		if (DEBUG)
//			drawGUI("Intersection-based 2-opt");
		
		float oldWeight = Float.MAX_VALUE;
		while (graph.getWeight(path) < oldWeight) {
			oldWeight = graph.getWeight(path);
			path = GeneralTwoOpt.optimizePath(graph, path, startTime);
		}
		if (DEBUG)
			System.out.println("Weight: " + graph.getWeight(path));
		System.out.println(path.toString());
		if (DEBUG)
			drawGUI("General 2-opt");
	} 

	private void drawGUI(String name) {
		new GUI(graph, path.clone(), name);
	}

	private void readInstance() {
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

			graph = new Graph(vertices, distanceMatrix);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
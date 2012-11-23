import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TSP {

	BufferedReader in;
	Graph graph;
	Path path;
//	TwoOpt twoOpt;
	boolean DEBUG = false;

	public static void main(String[] args) {
		new TSP();
	}

	TSP() {
		in = new BufferedReader(new InputStreamReader(System.in));
		readInstance();
		path = NaivePath.getNaivePath(graph);
		if (DEBUG) {
			System.out.println("Weight: " + graph.getWeight(path));
			System.out.println(path.toString());
			drawGUI();
		}
		if (DEBUG)
			System.out.println("Optimizing path..");
		TwoOpt twoOpt = new TwoOpt(path, graph);
		twoOpt.optimizePath();
		if (DEBUG)
			System.out.println("Weight: " + graph.getWeight(path));
		System.out.println(path.toString());
		if (DEBUG)
			drawGUI();
	} 

	private void drawGUI() {
		new GUI(graph, path);
	}

	private void readInstance() {
		try {
			int m = Integer.valueOf(in.readLine());
			if (DEBUG)
				System.out.println("Reading " + m + " vertices..");
			Vertex[] vertices = new Vertex[m];
			float[][] distanceMatrix = new float[m][m];

			for (int i = 0; i < m; i++) {
				String[] vertex = in.readLine().split(" ");
				float xCoord = Float.valueOf(vertex[0]);
				float yCoord = Float.valueOf(vertex[1]);			
				vertices[i] = new Vertex(xCoord,yCoord,i);
				if (DEBUG)
					System.out.println("Added vertex (" + vertices[i].getX() + ", " + vertices[i].getY() + ")");
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
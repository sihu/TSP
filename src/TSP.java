import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TSP {

	BufferedReader in;
	Graph graph;
	Path path;
	TwoOpt twoOpt;
	boolean DEBUG = true;

	public static void main(String[] args) {
		new TSP();
	}

	TSP() {
		in = new BufferedReader(new InputStreamReader(System.in));
		if(DEBUG)
			System.out.println("Reading TSP istance..");
		readInstance();
		if(DEBUG)
			System.out.println("Finding path..");
		path = NaivePath.getNaivePath(graph);
		path.sortEdges();
		if(DEBUG)
			System.out.println("Weight: " + path.getWeight());
		if(DEBUG)
			System.out.println("Optimizing path..");
		Path path2 = path.clone();
		twoOpt = new TwoOpt(path2);
		twoOpt.optimizePath();
		path.sortEdges();
		if(DEBUG)
			System.out.println("Printing solution..");
		System.out.println(path2.toString());
		if(DEBUG) {
			System.out.println("Weight: " + path2.getWeight());
			drawGUI();
		}
	} 

	private void drawGUI() {

		new GUI(path);
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
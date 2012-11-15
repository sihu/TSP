import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TSP {
	
	Vertex[] vertices;
	BufferedReader in;
	Path path;
	TwoOpt twoOpt;
	
	public static void main(String[] args) {
		new TSP();
	}
	
	TSP() {
		in = new BufferedReader(new InputStreamReader(System.in));
		readInstance();
		path = findPath();
		path.sortEdges();
		printSolution();
		System.out.println("Weight: " + path.getWeight());
		//drawGUI();
		Path path2 = path.clone();
		twoOpt = new TwoOpt(path2);
		twoOpt.optimizePath();
		path2.sortEdges();
		System.out.println(path2.toString());
		System.out.println("Weight: " + path2.getWeight());
		drawGUI();
	} 

	private void drawGUI() {
		
		new GUI(path);
	}
	 
	private void printSolution() {
		
		System.out.println(path.toString());
	}

	private Path findPath() {
		int m = vertices.length;
		Vertex[] path = new Vertex[m]; 
		boolean[] used = new boolean[m];
		path[0] = vertices[0];
		used[0] = true;
		
		for (int i = 1; i < m; i++) {
			int best = -1;
			
			for (int j = 0; j < m; j++) {
				if (!used[j] && (best == -1 || path[i-1].distanceTo(vertices[j]) 
						< path[i-1].distanceTo(vertices[best])))
						best = j;
			}
			path[i] = vertices[best];
//			System.out.println("Added " + path[i].getID() + " to path");
			used[best] = true;
		}	
		return new Path(path);
	}

	private void readInstance() {
		try {
			int m = Integer.valueOf(in.readLine());
			vertices = new Vertex[m];
			for (int i = 0; i < m; i++) {
				String[] vertex = in.readLine().split(" ");
				float xCoord = Float.valueOf(vertex[0]);
				float yCoord = Float.valueOf(vertex[1]);			
				vertices[i] = new Vertex(xCoord,yCoord,i);
//				System.out.println("Added vertex with id " + i + " (" + xCoord + ", " + yCoord + ")");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
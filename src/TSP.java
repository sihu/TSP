import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TSP {
	
	private ArrayList<Vertex> vertices;
	BufferedReader in;
	int[] path;
	
	public static void main(String[] args) {
		new TSP();
	}
	
	TSP() {
		vertices = new ArrayList<Vertex>();
		in = new BufferedReader(new InputStreamReader(System.in));
		readInstance();
		path = findPath();
		printSolution();
	}

	private void printSolution() {
		for (int i = 0; i < path.length; i++) {
			System.out.println(path[i]);
		}
	}

	private int[] findPath() {
		int m = vertices.size();
		int[] path = new int[m]; 
		boolean[] used = new boolean[m];
		
		for (int i = 1; i <= m; i++) {
			int best = -1;
			
			for (int j = 0; j < m; j++) {
				if (!used[j] && (best == -1 || vertices.get(path[i-1]).distanceTo(vertices.get(j)) 
						< vertices.get(path[i-1]).distanceTo(vertices.get(best))))
						best = j;
			}
			path[i-1] = best;
			used[best] = true;
		}
		return path;
	}

	private void readInstance() {
		try {
			int m = Integer.valueOf(in.readLine());
			
			for (int i = 0; i < m; i++) {
				String[] vertex = in.readLine().split(" ");
				float xCoord = Float.valueOf(vertex[0]);
				float yCoord = Float.valueOf(vertex[1]);			
				vertices.add(new Vertex(xCoord,yCoord));
//				System.out.println("Added coord (" + xCoord + ", " + yCoord + ")");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
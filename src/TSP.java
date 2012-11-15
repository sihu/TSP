import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TSP {
	
	private ArrayList<Vertex> vertices;
	BufferedReader in;
	
	public static void main(String[] args) {
		new TSP();
	}
	
	TSP() {
		vertices = new ArrayList<Vertex>();
		in = new BufferedReader(new InputStreamReader(System.in));
		readInstance();
	}

	private void readInstance() {
		try {
			int m = Integer.valueOf(in.readLine());
			for(int i = 0; i < m; i++) {
				String[] vertex = in.readLine().split(" ");
				float xCoord = Float.valueOf(vertex[0]);
				float yCoord = Float.valueOf(vertex[1]);			
				vertices.add(new Vertex(xCoord,yCoord));
				System.out.println("Added coord (" + xCoord + ", " + yCoord + ")");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
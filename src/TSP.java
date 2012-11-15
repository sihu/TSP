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
			int m = in.read();
			for(int i = 0; i < m; i++) {
				vertices.add(new Vertex());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
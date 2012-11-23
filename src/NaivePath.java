
public class NaivePath {

	public static Path getNaivePath(Graph g) {
		int m = g.vertices.length;
		Vertex[] path = new Vertex[m]; 
		boolean[] used = new boolean[m];
		path[0] = g.vertices[0];
		used[0] = true;

		for (int i = 1; i < m; i++) {
			int best = -1;

			for (int j = 0; j < m; j++) {
				if (!used[j] && (best == -1 || path[i-1].distanceTo(g.vertices[j]) 
						< path[i-1].distanceTo(g.vertices[best])))
					best = j;
			}
			path[i] = g.vertices[best];
			used[best] = true;
		}	
		return new Path(path);
	}
}

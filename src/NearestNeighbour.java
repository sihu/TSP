
public class NearestNeighbour {

	public static Path getNaivePath(Graph g) {
		int m = g.vertices.length;
		int[] path = new int[m]; 
		boolean[] used = new boolean[m];
		used[0] = true;

		for (int i = 1; i < m; i++) {
			int best = -1;

			for (int j = 0; j < m; j++) {
				if (!used[j] && (best == -1 || g.distanceBetween(path[i-1],j) 
						< g.distanceBetween(path[i-1], best)))
					best = j;
			}
			path[i] = best;
			used[best] = true;
		}	
		return new Path(path);
	}
}

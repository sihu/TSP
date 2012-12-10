
public class TwoOpt {
	boolean DEBUG = true;

	public static void optimizePath(Graph g, Path p, long startTime) {

		int[] path = p.getPath();
		for (int i = 0; i < path.length-1; i++) {
			for (int j = i; j < path.length-1; j++) {
				if (System.currentTimeMillis() - startTime > 2000)
					return;
				if (path[i] != path[j] && linesIntersects(g.getVertex(path[i]), g.getVertex(path[i+1]),
						g.getVertex(path[j]), g.getVertex(path[j+1]))) {
					p.flipSubPath(i+1, j);
					return;
				}
			}
		}
	}

	private static boolean linesIntersects(Vertex p, Vertex q, Vertex r, Vertex s) {
		return (p.getLineRepresentation(q).intersectsLine(r.getLineRepresentation(s)) &&
				!p.equals(r) && !p.equals(s) && ! q.equals(r) && ! q.equals(s));
	}
}

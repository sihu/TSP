
public class TwoOpt {
	private Path path;
	private Graph graph;
	boolean DEBUG = true;

	public TwoOpt(Path p, Graph g) {
		path = p;
		graph = g;
	}

	public void optimizePath() {

		int[] path = this.path.getPath();
		for (int i = 0; i < path.length-1; i++) {
			for (int j = i; j < path.length-1; j++) {
				if (path[i] != path[j] && linesIntersects(graph.getVertex(path[i]), graph.getVertex(path[i+1]),
						graph.getVertex(path[j]), graph.getVertex(path[j+1]))) {
						this.path.flipSubPath(i, j+1);
						return;
				}
			}
			
		}
	}

	private boolean linesIntersects(Vertex p, Vertex q, Vertex r, Vertex s) {
		return (p.getLineRepresentation(q).intersectsLine(r.getLineRepresentation(s)) &&
				!p.equals(r) && !p.equals(s) && ! q.equals(r) && ! q.equals(s));
	}
}

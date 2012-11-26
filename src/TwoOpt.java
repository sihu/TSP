
public class TwoOpt {
	private Path path;
	private Graph graph;
	private long startTime;
	boolean DEBUG = true;

	public TwoOpt(Path p, Graph g, long startTime) {
		path = p;
		graph = g;
		this.startTime = startTime;
	}

	public void optimizePath() {

		int[] path = this.path.getPath();
		for (int i = 0; i < path.length-1; i++) {
			for (int j = i; j < path.length-1; j++) {
				if (System.currentTimeMillis() - startTime > 2000)
					return;
				if (path[i] != path[j] && linesIntersects(graph.getVertex(path[i]), graph.getVertex(path[i+1]),
						graph.getVertex(path[j]), graph.getVertex(path[j+1]))) {
					this.path.flipSubPath(i, j+1);
					return;
				}
			}

		}
	}

	public Path optimize(Graph graph, Path p) {
		
		int[] path = p.getPath();
		int[] newPath = new int[path.length];
		int newI = 0, newJ = 0;
		double bestLenght = 0;
		for (int i = 0; i < (path.length-2); i++) {
			newPath[i] = path[i];
			boolean visited[] = new boolean[graph.vertices.length]; 
			//			while(true) {
			for (int j = i+2; j < path.length-2; j++) {
				
				double originalLength = 0;
				originalLength += graph.distanceBetween(path[i], path[i+1]);
				originalLength += graph.distanceBetween(path[j], path[j+1]);
				double newLength = 0;
				newLength += graph.distanceBetween(path[i], path[j]);
				newLength += graph.distanceBetween(path[j+1], path[i+1]);
				if (Double.compare(newLength, originalLength) < 0 ) {
					if ( (newI == 0) || (Double.compare(originalLength - newLength, bestLenght) > 0) ) {
						newI = i;
						newJ = j;
						bestLenght = originalLength - newLength;
					}
				}
			}
		}
		//			System.out.println(" byter: " + newI + " " + newJ);
		for (int a = 1; a < (newJ+1)-newI; a++) {
			newPath[newI+a] = path[newJ-a+1];
		}
		for (int a = newJ+1; a < path.length; a++) {
			newPath[a] = path[a];
		}
		return new Path(newPath);
	}
	
	private boolean linesIntersects(Vertex p, Vertex q, Vertex r, Vertex s) {
		return (p.getLineRepresentation(q).intersectsLine(r.getLineRepresentation(s)) &&
				!p.equals(r) && !p.equals(s) && ! q.equals(r) && ! q.equals(s));
	}
}

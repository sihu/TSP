
public class TwoOpt {
	private Path path;
	
	public TwoOpt(Path p) {
		path = p;
	}
	
	public void optimizePath() {
		for (Edge e : path.getEdges()) {
			for (Edge e2 : path.getEdges()) {
				if (e != e2 && e.intersectsWith(e2))
					switchEdges(e,e2);
			}
		}
	}
	
	private void switchEdges(Edge e, Edge e2) {
		Vertex v,v2;
		v = e.getP();
		v2 = e2.getP();
		e.setP(v2);
		e2.setP(v);
	}
	
	public Path getPath() {
		return path;
	}
}

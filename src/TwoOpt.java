
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
		
	}
	
	public Path getPath() {
		return path;
	}
}

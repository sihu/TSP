
public class TwoOpt {
	private Path path;
	boolean DEBUG = true;

	public TwoOpt(Path p) {
		path = p;
	}

	public void optimizePath() {

		if(DEBUG) {
			System.out.println("Edges before 2-opt:");
			for (int i = 0; i < path.getEdges().length; i++) {
				System.out.println(path.getEdges()[i].toString());
			}
		}
		
		for (Edge e : path.getEdges()) {
			for (Edge e2 : path.getEdges()) {
				if (e != e2 && e.intersectsWith(e2)) {
					if (e.getP().getID() != e2.getQ().getID() && e.getQ().getID() != e2.getP().getID()
							&& e.getP().getID() != e2.getP().getID() && e.getQ().getID() != e2.getQ().getID()) {
						switchEdges(e,e2);
					}
				}
			}
		}

		if(DEBUG) {
			System.out.println("Edges after 2-opt:");
			for (int i = 0; i < path.getEdges().length; i++) {
				System.out.println(path.getEdges()[i].toString());
			}
		}
	}

	private void switchEdges(Edge e, Edge e2) {

		if (DEBUG)
			System.out.println("Before switch:" + e + ", " + e2);

		Vertex v,v2;
		v = e.getQ();
		v2 = e2.getP();

		e.setQ(v);
		e2.setP(v2);

		if(DEBUG)
			System.out.println("After switch:" + e + ", " + e2);


		path.flipSubPath(v, v2);
	}

	public Path getPath() {

		System.out.println("Edges returned:");
		for (int i = 0; i < path.getEdges().length; i++) {
			System.out.println(path.getEdges()[i].toString());
		}

		return path;
	}
}

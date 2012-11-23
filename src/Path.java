
public class Path {
	private Edge[] edges;
	private float weight;
	boolean DEBUG = false;

	public Path(Edge[] edges) {
		this.edges = edges;
		weight = calculateWeight();
	}
	/**
	 * Builds edges from sorted array of vertices
	 * @param vertices
	 */
	public Path(Vertex[] vertices) {
		this(verticesToEdges(vertices));
	}

	private static Edge[] verticesToEdges(Vertex[] vertices) {
		Edge[] edges = new Edge[vertices.length -1];
		for (int i = 0; i < edges.length; i++) {
			edges[i] = new Edge(vertices[i], vertices[i+1]);
		}
		return edges;
	}

	public float calculateWeight() {
		float f = 0;
		for (Edge e : edges) {
			f += e.getWeight();
		}
		return f;
	}

	public String toString() {
		String path = edges[0].getP().getID() + "\n";

		for (int i = 0; i < edges.length; i++) {
			path += edges[i].getQ().getID() + "\n";
		}

		System.out.println(edges.length);
		return path;
	}

	private Edge getEdgeByPID(int id) {
		Edge edge = null;
		for (int i = 0; i < edges.length; i++) {
			if(edges[i].getP().getID() == id) {
				edge = edges[i]; break;				
			}
		}
		return edge;
	}

	public void sortEdges() {

		if(DEBUG) {
			System.out.println("Edges before sort: ");

			for (Edge e : edges) {
				System.out.println(e.toString());
			}
		}

		Edge[] newEdges = new Edge[edges.length];
		newEdges[0] = getEdgeByPID(0);
		Edge nextEdge;
		for (int i = 1; i < edges.length; i++) {
			nextEdge = getEdgeByPID(newEdges[i-1].getQ().getID()); 
			if (nextEdge != null) {
				newEdges[i] = nextEdge;
			} else {
				System.out.println("There is no edge with PID " + newEdges[i-1].getQ().getID());
			}
		}
		edges = newEdges;

		if(DEBUG) {
			System.out.println("Edges after sort: ");

			for (Edge e : edges) {
				System.out.println(e.toString());
			}
		}
	}

	public Path clone() {
		return new Path(edges.clone());
	}

	public float getWeight() {
		weight = calculateWeight();
		return weight;
	}

	public Edge[] getEdges() {
		return edges;
	}

	public void flipSubPath(Vertex v, Vertex v2) {
		
		Edge currentEdge = getEdgeByPID(v.getID());
		Edge nextEdge = getEdgeByPID(currentEdge.getQ().getID());
		currentEdge.flipEdge();
		
		while (nextEdge != null) {
			nextEdge = getEdgeByPID(currentEdge.getQ().getID());
			currentEdge.flipEdge();
			currentEdge = nextEdge;
		}
	}
}

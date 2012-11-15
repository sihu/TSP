
public class Path {
	private Edge[] edges;
	private final float weight;
	
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
		
		return path;
	}
	
	private Edge getEdgeByPID(int id) {
		Edge edge = null;
		for (int i = 0; i < edges.length; i++) {
			if(edges[i].getP().getID() == id)
				edge = edges[i]; break;
		}
		return edge;
	}
	
	public void sortEdges() {
		Edge[] newEdges = new Edge[edges.length];
		newEdges[0] = getEdgeByPID(0);
		for (int i = 1; i < newEdges.length; i++) {
			newEdges[i] = getEdgeByPID(newEdges[i-1].getQ().getID()); 
		}
		edges = newEdges;
	}

	public Path clone() {
		return new Path(edges.clone());
	}
	
	public float getWeight(){
		return weight;
	}
	
	public Edge[] getEdges() {
		return edges;
	}
}

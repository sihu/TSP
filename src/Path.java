
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
		String path = "";
		
		for (int i = 0; i < edges.length; i++) {
			path += edges[i].getP().getID() + "\n";
		}
		
		return path;
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

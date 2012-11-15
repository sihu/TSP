import java.awt.geom.Line2D;

public class Edge {
	private Vertex p,q;
	private Line2D.Float lineRepresentation;
	
	public Edge(Vertex p, Vertex q) {
		this.p = p;
		this.q = q;
		lineRepresentation = new Line2D.Float(p.getX(), p.getY(), q.getX(), q.getY());
	}
	
	public float getWeight() {
		return p.distanceTo(q);
	}
	
	public Line2D getLineRepresentation() {
		return lineRepresentation;
	}
	
	public boolean intersectsWith(Edge e) {
		return lineRepresentation.intersectsLine(e.getLineRepresentation());
	}
}

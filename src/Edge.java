import java.awt.geom.Line2D;

public class Edge {
	private Vertex p,q;

	
	public Edge(Vertex p, Vertex q) {
		this.p = p;
		this.q = q;
	}
	
	public float getWeight() {
		return p.distanceTo(q);
	}
	
	public Line2D getLineRepresentation() {
		return new Line2D.Float(p.getX(), p.getY(), q.getX(), q.getY());
	}
	
	public boolean intersectsWith(Edge e) {
		return getLineRepresentation().intersectsLine(e.getLineRepresentation());
	}
	
	public Vertex getP() {
		return p;
	}

	public void setP(Vertex p) {
		this.p = p;
	}

	public Vertex getQ() {
		return q;
	}

	public void setQ(Vertex q) {
		this.q = q;
	}


}

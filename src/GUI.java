import javax.swing.JFrame;
import java.awt.*;

public class GUI extends Canvas
{
	private Path path;
	private static final int scaling = 1;
	
	public GUI(Path path) {
		
		this.path = path;
		
		frame = new JFrame("TSP");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.add(this);
		frame.setVisible(true);
	}

	public void paint(Graphics g) {
		
		Edge[] edges = path.getEdges();
		Vertex first = edges[0].getP();
		
		g.drawString(first.getID() + "", (int) first.getX()*scaling, (int) first.getY()*scaling);
		
		for (int i = 0; i < path.getEdges().length; i++) {
			Vertex p = edges[i].getP();
			Vertex q = edges[i].getQ();
			
			g.drawString(q.getID() + "", (int) q.getX()*scaling, (int) q.getY()*scaling);
			g.drawLine((int) p.getX()*scaling, (int) p.getY()*scaling, (int) q.getX()*scaling, (int) q.getY()*scaling);
		}
	}

	private JFrame frame;
}
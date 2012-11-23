import javax.swing.JFrame;
import java.awt.*;

public class GUI extends Canvas
{
	private Path path;
	private Graph graph;
	private static final int scaling = 4;
	
	public GUI(Graph graph, Path path) {
		
		this.graph = graph;
		this.path = path;
		
		frame = new JFrame("TSP");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.add(this);
		frame.setVisible(true);
	}

	public void paint(Graphics g) {
		for (int i = 0; i < path.getLength()-1; i++) {
			Vertex p = graph.getVertex(path.getPath()[i]);
			Vertex q = graph.getVertex(path.getPath()[i+1]);
			
			g.drawString(q.getID() + "", (int) q.getX()*scaling, (int) q.getY()*scaling);
			g.drawLine((int) p.getX()*scaling, (int) p.getY()*scaling, (int) q.getX()*scaling, (int) q.getY()*scaling);
		}
	}

	private JFrame frame;
}
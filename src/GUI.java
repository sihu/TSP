import javax.swing.JFrame;
import java.awt.*;

public class GUI extends Canvas
{
	private Path path;
	private Graph graph;
	private static final int scaling = 1500;
	
	public GUI(Graph graph, Path path, String name) {
		
		this.graph = graph;
		this.path = path;
		
		frame = new JFrame("TSP - " + name + ", Length: " + graph.getWeight(path));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(740,740);
		frame.add(this);
		frame.setVisible(true);
	}

	public void paint(Graphics g) {
		for (int i = 0; i < path.getLength()-1; i++) {
			Vertex p = graph.getVertex(path.getPath()[i]);
			Vertex q = graph.getVertex(path.getPath()[i+1]);
		
			g.setColor(Color.BLACK);
			g.drawLine((int) p.getX()/scaling+20, (int) p.getY()/scaling+20, (int) q.getX()/scaling+20, (int) q.getY()/scaling+20);
//			g.drawString("" + p.getID(),(int) p.getX()/scaling - 3 + 20, (int) p.getY()/scaling - 3 + 20);
			g.setColor(Color.RED);
			g.fillOval((int) q.getX()/scaling - 3 + 20, (int) q.getY()/scaling - 3 + 20, 6, 6);
		}
	}

	private JFrame frame;
}
import javax.swing.JFrame;
import java.awt.*;

public class GUI extends Canvas
{
	Vertex[] vertices;
	int[] path;
	private static final int scaling = 5;
	
	public GUI(Vertex[] vertices, int[] path) {
		
		this.vertices = vertices;
		this.path = path;
		
		frame = new JFrame("TSP");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.add(this);
		frame.setVisible(true);
	}

	public void paint(Graphics g) {
		for (int i = 0; i < vertices.length; i++) {
			g.drawOval((int) (vertices[i].getX()*scaling), (int) (vertices[i].getY()*scaling), 10, 10);
		}
		
		for (int j = 1; j < path.length; j++) {
			g.drawLine((int) vertices[path[j-1]].getX()*scaling, (int) vertices[path[j-1]].getY()*scaling, 
					(int) vertices[path[j]].getX()*scaling, (int) vertices[path[j]].getY()*scaling);
		}
	}

	private JFrame frame;
}
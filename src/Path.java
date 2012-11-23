
public class Path {
	private int[] path;
	public Graph graph;
	private int length;

	public Path(int[] path, Graph graph) {
		this.path = path;
		this.graph = graph;
		this.length = path.length;
	}

	public String toString() {
		String pathString = "";
		
		for (int i = 0; i < path.length; i++) {
			pathString += path[i] + "\n";
		}
		return pathString.substring(0, pathString.length()-1);
	}

	public float getWeight() {
		float f = 0;
		for (int i = 0; i < path.length-1; i++) {
			f += graph.distanceBetween(path[i], path[i+1]);
		}
		return f;
	}
	
	public int getLength() {
		return length;
	}
	
	public int[] getPath() {
		return path;
	}
	
	public void flipSubPath(int v1, int v2)
	{
		int[] newPath = path.clone();
		for (int i = 1; i < (v2 - v1)+1; i++) {
			newPath[v1+1] = path[v2-1];
		}
		path = newPath;
	}
}

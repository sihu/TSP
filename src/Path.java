
public class Path {
	private int[] path;
	private int[] order;
	private int length;

	public Path(int[] path) {
		this.path = path;
		this.length = path.length;
		order = orderPath(path);
	}

	private int[] orderPath(int[] path) {
		
		int[] order = new int[path.length];
		
		for (int i = 0; i < path.length; i++) {
			order[path[i]] = i;
		}
		return order;
	}

	public String toString() {
		String pathString = "";
		
		for (int i = 0; i < path.length; i++) {
			pathString += path[i] + " - " + order[path[i]] + "\n";
		}
		return pathString.substring(0, pathString.length()-1);
	}

	public int[] getPath(){
		return path;
	}
	public int getLength() {
		return length;
	}
	public int getOrder(int id) {
		return order[id];
	}
	public Path clone() {
		return new Path(path.clone());
	}
	
	public void flipSubPath(int v1, int v2) {
		int[] newPath = path.clone();
		int[] newOrder = order.clone();
		for (int i = 1; i < (v2-v1); i++) {
			newPath[v1+i] = path[v2-i];
			newOrder[newPath[v1+i]] = order[path[v2-i]];
		}
		path = newPath;
		order = newOrder;
	}
}

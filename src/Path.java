
public class Path {
	private int[] path;
	private int length;
	private boolean DEBUG = false;

	public Path(int[] path, Graph graph) {
		this.path = path;
		this.length = path.length;
	}

	public String toString() {
		String pathString = "";
		for (int i = 0; i < path.length; i++) {
			pathString += path[i] + "\n";
		}
		return pathString.substring(0, pathString.length()-1);
	}

	public int[] getPath(){
		return path;
	}
	public int getLength() {
		return length;
	}
	
	public int getPathID(int i) {
		return path[i];
	}
}

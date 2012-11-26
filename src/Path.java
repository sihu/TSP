
public class Path {
	private int[] path;
	private int length;

	public Path(int[] path) {
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
	public Path clone() {
		return new Path(path.clone());
	}
	
	public void flipSubPath(int v1, int v2) {
		int[] newPath = path.clone();
		for (int i = 1; i < (v2-v1); i++) {
			newPath[v1+i] = path[v2-i];
		}
		path = newPath;
	}
}

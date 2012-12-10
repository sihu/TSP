
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

	public void print() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < path.length; i++) {
			sb.append(path[i] + "\n") ;
		}

		System.out.println(sb);
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
		while (v1 != v2 && !(v1 == v2 + 1)) {

			int tmp = v1;
			order[path[v1]] = v2;
			order[path[v2]] = tmp;

			tmp = path[v1];
			path[v1] = path[v2];
			path[v2] = tmp;

			v1++;
			v2--;
			
			if (v2 < 0) {
				v2 = length - 1;
			}

			if (v1 > length - 1) {
				v1 = 0;
			}
		}
	}
}
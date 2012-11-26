
public class GeneralTwoOpt {

	boolean DEBUG = true;

	public static Path optimizePath(Graph g, Path p, long startTime) {
		
		int[] path = p.getPath();
		int[] newPath = new int[path.length];
		int newI = 0, newJ = 0;
		float bestLength = 0;
		
		for (int i = 0; i < path.length-2; i++) {
			if (System.currentTimeMillis() - startTime > 1700)
				break;
			newPath[i] = path[i];
			float originalLength, newLength;
			for (int j = i+2; j < path.length-2; j++) {
				originalLength = 0;
				originalLength += g.distanceBetween(path[i], path[i+1]);
				originalLength += g.distanceBetween(path[j], path[j+1]);
				
				newLength = 0;	
				newLength += g.distanceBetween(path[i], path[j]);
				newLength += g.distanceBetween(path[j+1], path[i+1]);
				
				if (newLength < originalLength) {
					if (newI == 0 || (originalLength - newLength) > bestLength) {
						newI = i;
						newJ = j;
						bestLength = originalLength - newLength;
					}
				}
			}
		}
		
		for (int i = 1; i < (newJ+1)-newI; i++) {
			newPath[newI+i] = path[newJ-i+1];
		}
		
		for (int i = newJ+1; i < path.length; i++) {
			newPath[i] = path[i];
		}
		
		return new Path(newPath);
	}
}

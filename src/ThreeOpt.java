
public class ThreeOpt {
	public static Path optimizePath(Graph g, Path p, long startTime) {

		int[] path = p.getPath();
		int newI = 0, newJ = 0, newK = 0;
		float bestLength = 0;

		for (int i = 0; i < path.length-1; i++) {
			if (System.currentTimeMillis() - startTime > 1800) {
				System.out.println("BROKE!");
				break;
			}
			int v1, v2, u1, u2, x1, x2;
			float originalLength, newLength;

			v1 = path[i];
			v2 = path[i+1];

			for (int j = i+1; j < path.length-1; j++) {
				u1 = path[j];
				u2 = path[j+1];
				for (int k = j+1; k < path.length; k++) {
					x1 = path[k];
					x2 = path[k+1];
					
					originalLength = g.distanceBetween(v1, v2) + g.distanceBetween(u1,u2) + g.distanceBetween(x2, x1);
					newLength = g.distanceBetween(v1, x1) + g.distanceBetween(v2, u2) + g.distanceBetween(u1, x2);
					float newLength2 = g.distanceBetween(v1, x2) + g.distanceBetween(v2, u2) + g.distanceBetween(u1, x1);
					float newLength3 = g.distanceBetween(v1, u1) + g.distanceBetween(x1, u2) + g.distanceBetween(x2, v2);
					float newlength4 = g.distanceBetween(v1, u2) + g.distanceBetween(v2, x1) + g.distanceBetween(u1, x2);
					float newlength5 = g.distanceBetween(v1, x1) + g.distanceBetween(v2, u1) + g.distanceBetween(u2, x2);
					float newLength6 = g.distanceBetween(v1, x1) + g.distanceBetween(v2, u2) + g.distanceBetween(u1, x2);

					if (newLength < originalLength||newLength2 < originalLength
							||newLength3 < originalLength || newlength4 < originalLength) {
						System.out.println("JOOOOOOODDU!");
						if (newI == 0 || (originalLength - newLength) > bestLength) {
							newI = i;
							newJ = j+1;
							newK = k+1;
							bestLength = originalLength - newLength;
						}
					}	
				}
			}
		}

		Path newPath = new Path(p.getPath());

		newPath.flipSubPath(newI, newJ);
		newPath.flipSubPath(newI, newK);

		return newPath;
	}
}

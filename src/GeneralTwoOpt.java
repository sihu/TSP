public class GeneralTwoOpt {

	public static Path optimizePath(Graph g, Path p, long startTime) {

		int[] path = p.getPath();
		int newI = 0, newJ = 0;
		float bestLength = 0;

		for (int i = 0; i < path.length-1; i++) {
			if (System.currentTimeMillis() - startTime > 2000)
				break;
			int v1, v2, u1, u2;
			float originalLength, newLength;

			v1 = path[i];
			v2 = path[i+1];

			for (int j = i+1; j < path.length-1; j++) {
				u1 = path[j];
				u2 = path[j+1];

				originalLength = g.distanceBetween(v1, v2) + g.distanceBetween(u1,u2);
				newLength = g.distanceBetween(v1, u1) + g.distanceBetween(v2, u2);

				if (newLength < originalLength) {
					if (newI == 0 || (originalLength - newLength) > bestLength) {
						newI = i+1;
						newJ = j;
						bestLength = originalLength - newLength;
					}
				}
			}
		}

		Path newPath = p.clone();

		newPath.flipSubPath(newI, newJ);

//		if (g.getWeight(p) > g.getWeight(newPath)) {
//			return newPath;
//		} else {
//			System.out.println("newPath.weight > p.weight, fail");
//			return p;
//		}
		
		return newPath;
	}
}
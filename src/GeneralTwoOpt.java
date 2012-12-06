public class GeneralTwoOpt {

	public static Path optimizePath(Graph g, Path p, long startTime) {

		int[] path = p.getPath();
		int newI = 0, newJ = 0;
		float bestLength = 0;

		for (int i = 0; i < path.length-1; i++) {

			int[] closestNeighbours = g.getClosestNeighbours(i);

//			if (System.currentTimeMillis() - startTime > 1750)
//				break;
			int v1, v2, u1, u2;
			float originalLength, newLength;

			v1 = path[i];
			v2 = path[i+1];

			for (int j = 0; j < closestNeighbours.length; j++) {
				
				if (p.getOrder(closestNeighbours[j]) != 0) {
					u1 = closestNeighbours[j];
					u2 = path[p.getOrder(closestNeighbours[j])-1];
					
					if (u2 == v1 || u1 == v2 || u1 == v1 || u2 == v2)
						continue;
				} else {
					continue;
				}

				//				if (g.distanceBetween(v1,v2) < g.distanceBetween(v1, u2))
				//					break;
				
				Path newPath = p.clone();
				newPath.flipSubPath(i, p.getOrder(u1));
				
				if (g.getWeight(p) > g.getWeight(newPath)) {
					p = newPath;
					path = p.getPath();
				}

//				originalLength = g.distanceBetween(v1, v2) + g.distanceBetween(u1,u2);
//				newLength = g.distanceBetween(v1, u1) + g.distanceBetween(u2, v2);
//
//				if (newLength < originalLength) {
//					if (newI == 0 || (originalLength - newLength) > bestLength) {
//						if (TSP.DEBUG)
//							System.out.println("Checking ("+v1+","+v2+") and ("+u1+","+u2+")");
//						newI = i;
//						newJ = p.getOrder(u1);
//						bestLength = originalLength - newLength;
//					}
//				}
			}
		}

//		Path newPath = p.clone();
//
//		newPath.flipSubPath(newI, newJ);
//
//		if (newJ != 0 )
//			System.out.println("("+path[newI]+","+path[newI+1]+") and ("+path[newJ-1]+","+path[newJ]+") -> ("+path[newI]+","+path[newJ-1]+") and ("+path[newI+1]+","+path[newJ]+")");
//
//		if (g.getWeight(p) < g.getWeight(newPath)) {
//			System.out.println("newPath.weight > p.weight, feck");
//		}
		return p;
	}
}
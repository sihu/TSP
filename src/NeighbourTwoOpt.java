public class NeighbourTwoOpt {

	public static Path optimizePath(Graph g, Path p, long startTime) {
		int[] path = p.getPath();
		
		while(System.currentTimeMillis() - startTime < 2000){
			
			float bestLength = 0;
			float oldLength = 0;
			float newLength = 0;
			
			int newI = -1;
			int newJ = -1;
			
			for (int i = 0; i < g.vertices.length; i++) {
				
				int v1 = i;
				int v2;
				
				if (p.getOrder(i) == path.length-1)
					v2 = path[0];
				else
					v2 = path[p.getOrder(i)+1];
				
				for (int j = 0; j < g.getClosestNeighbours(i).length; j++) {
					
					int u1 = g.getClosestNeighbours(i)[j];
					int u2;
					
					if (p.getOrder(u1) == 0) 
						u2 = path[path.length-1];
					else
						u2 = path[p.getOrder(u1)-1];
					
					oldLength = g.distanceBetween(v1,v2) + g.distanceBetween(u1,u2);
					newLength = g.distanceBetween(v1,u2) + g.distanceBetween(u1,v2);
					
					if(u1 != v2 && (oldLength > newLength)){
						if	((oldLength) - (newLength) > bestLength) {
							bestLength = oldLength - newLength;
							newI = v2;
							newJ = u2;
						}
					}
				}
			}
			
			if (newI != -1) {
				p.flipSubPath(p.getOrder(newI), p.getOrder(newJ));
			} else {
				break;
			}
		}
		return p;
	}
}
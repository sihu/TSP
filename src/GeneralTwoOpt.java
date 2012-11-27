import java.util.Iterator;
import java.util.TreeMap;

public class GeneralTwoOpt {
 
        boolean DEBUG = true;
 
        public static Path optimizePath(Graph g, Path p, long startTime) {
                
                int[] path = p.getPath();
                int newI = 0, newJ = 0;
                float bestLength = 0;
                
                for (int i = 0; i < path.length-1; i++) {
                        if (System.currentTimeMillis() - startTime > 1750)
                                break;
                        int v1, v2, u1, u2;
                        float originalLength, newLength;
                        
                        v1 = path[i];
                        v2 = path[i+1];
                        
                        TreeMap<Float,Integer> tree = g.getIdsToIdsSortedByDistance().get(v1);
                        Iterator<Float> it = tree.keySet().iterator();
                        it.next();
                        
                        for (int j = 0; j < 10; j++) {
                        		int id = tree.get(it.next());
                        		
                        		if (p.getOrder(id) != 999) {
                            		u1 = id;
                                    u2 = path[p.getOrder(id)+1];
                        		} else {
                        			continue;
                        		}
                                
                                originalLength = g.distanceBetween(v1, v2) + g.distanceBetween(u1,u2);
                                newLength = g.distanceBetween(v1, u1) + g.distanceBetween(v2, u2);
                                
                                if (newLength < originalLength) {
                                        if (newI == 0 || (originalLength - newLength) > bestLength) {
                                                newI = i;
                                                newJ = p.getOrder(id)+1;
                                                bestLength = originalLength - newLength;
                                        }
                                }
                        }
                }
                
                Path newPath = new Path(p.getPath());
                
                newPath.flipSubPath(newI, newJ);
                
                return newPath;
        }
}
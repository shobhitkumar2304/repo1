import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Long, Integer> edgeCounts = new HashMap<>();
        int maxEdges = 0;
        
        for (List<Integer> row : wall) {
            long currentPos = 0;
            // Iterate up to the second-to-last brick to avoid the outer boundary edge
            for (int i = 0; i < row.size() - 1; i++) {
                currentPos += row.get(i);
                int count = edgeCounts.getOrDefault(currentPos, 0) + 1;
                edgeCounts.put(currentPos, count);
                maxEdges = Math.max(maxEdges, count);
            }
        }
        
        return wall.size() - maxEdges;
    }
}
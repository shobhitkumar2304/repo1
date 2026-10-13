import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Pre-size map to avoid resizing overhead (capacity k with load factor 0.75)
        Map<Integer, Integer> remainderCounts = new HashMap<>(k * 2);
        remainderCounts.put(0, 1);
        
        int prefixSum = 0;
        int count = 0;
        
        for (int num : nums) {
            prefixSum += num;
            
            int remainder = prefixSum % k;
            if (remainder < 0) {
                remainder += k;
            }
            
            
            Integer existing = remainderCounts.get(remainder);
            if (existing != null) {
                count += existing;
                remainderCounts.put(remainder, existing + 1);
            } else {
                remainderCounts.put(remainder, 1);
            }
        }
        
        return count;
    }
}
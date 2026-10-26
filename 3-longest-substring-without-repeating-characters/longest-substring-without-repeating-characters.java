import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        
        // Array to store the last seen position of ASCII characters (initialized to -1)
        int[] lastIndex = new int[128];
        Arrays.fill(lastIndex, -1);
        
        int left = 0;
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            // If the character was seen after or at the current left boundary, move left
            if (lastIndex[currentChar] >= left) {
                left = lastIndex[currentChar] + 1;
            }
            
            // Update last seen index of currentChar
            lastIndex[currentChar] = right;
            
            // Update maximum window length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
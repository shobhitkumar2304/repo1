class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int index = 0;
        int i = 0;
        while(i<n){
            char curr = chars[i];
            int count = 0;
            while(i<n && chars[i] == curr){
                count = count + 1;
                i++;
            }
            chars[index] = curr;
            index++;
            if(count>1){
                String s = Integer.toString(count);
                for(char ch : s.toCharArray()){
                    chars[index++] = ch;
                }
            }
        }
        return index;
    }
}
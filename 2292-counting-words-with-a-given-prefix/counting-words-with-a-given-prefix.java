class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for(String word : words){
            if(word.startsWith(pref)){
                count = count + 1;
            }
        }
        if(count>=1){
            return count;
        }
        return 0;
    }
}
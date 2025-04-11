class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        boolean word = false;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ' ' && word) break;
            else if(s.charAt(i) != ' '){
                count++;
                word = true;
            }
        }
        return count;
    }
}
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder reversed = new StringBuilder(word).reverse();
            result.append(reversed).append(" ");
        }

        return result.toString().trim();
    }
}

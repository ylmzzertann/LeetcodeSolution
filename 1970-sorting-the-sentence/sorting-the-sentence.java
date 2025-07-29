class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] result = new String[words.length];

        for (String word : words) {
            // Extract the position (last character as index)
            int index = word.charAt(word.length() - 1) - '1'; // subtract '1' to make it 0-indexed
            result[index] = word.substring(0, word.length() - 1); // Remove the number
        }

        return String.join(" ", result);
    }
}

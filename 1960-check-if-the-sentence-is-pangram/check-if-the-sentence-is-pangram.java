import java.util.HashSet;

class Solution {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) return false;

        HashSet<Character> letters = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            letters.add(c);
        }

        return letters.size() == 26;
    }
}

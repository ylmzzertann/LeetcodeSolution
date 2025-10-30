class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (vowels.indexOf(w.charAt(0)) != -1) {
                res.append(w);
            } else {
                res.append(w.substring(1)).append(w.charAt(0));
            }
            res.append("ma");

            // 'a' ekleme
            for (int j = 0; j <= i; j++) res.append('a');

            if (i != words.length - 1) res.append(' ');
        }

        return res.toString();
    }
}

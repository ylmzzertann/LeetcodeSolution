class Solution {
    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        if (n != goal.length()) return false;

        // Eğer s == goal ise, en az bir karakterin tekrarlı olması gerekir (örneğin "aa")
        if (s.equals(goal)) {
            boolean[] seen = new boolean[26];
            for (char c : s.toCharArray()) {
                if (seen[c - 'a']) return true;
                seen[c - 'a'] = true;
            }
            return false;
        }

        // Farklı olan karakterlerin indekslerini bul
        int first = -1, second = -1, diff = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diff++;
                if (diff == 1) first = i;
                else if (diff == 2) second = i;
                else return false; // 2'den fazla fark varsa, imkansız
            }
        }

        // Tam 2 fark varsa ve swap sonrası eşit oluyorsa true
        return diff == 2 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first);
    }
}

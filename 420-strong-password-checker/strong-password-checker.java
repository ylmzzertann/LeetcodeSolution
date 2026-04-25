class Solution {
    public int strongPasswordChecker(String s) {
        int n = s.length();

        int hasLower = 0, hasUpper = 0, hasDigit = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = 1;
            else if (Character.isUpperCase(c)) hasUpper = 1;
            else if (Character.isDigit(c)) hasDigit = 1;
        }

        int missing = 3 - (hasLower + hasUpper + hasDigit);

        // count repeating sequences
        int replace = 0;
        int[] cnt = new int[3]; // mod 0,1,2 buckets

        for (int i = 0; i < n;) {
            int j = i;
            while (i < n && s.charAt(i) == s.charAt(j)) i++;
            int len = i - j;

            if (len >= 3) {
                replace += len / 3;
                cnt[len % 3]++;
            }
        }

        if (n < 6) {
            return Math.max(missing, 6 - n);
        }

        if (n <= 20) {
            return Math.max(missing, replace);
        }

        // n > 20
        int delete = n - 20;

        // 1️⃣ remove from mod 0 (best efficiency)
        int use = Math.min(cnt[0], delete);
        replace -= use;
        delete -= use;

        // 2️⃣ remove from mod 1
        use = Math.min(cnt[1] * 2, delete);
        replace -= use / 2;
        delete -= use;

        // 3️⃣ remove from mod 2
        use = Math.min(cnt[2] * 3, delete);
        replace -= use / 3;
        delete -= use;

        // 4️⃣ still deletions left
        replace -= delete / 3;

        return (n - 20) + Math.max(missing, replace);
    }
}
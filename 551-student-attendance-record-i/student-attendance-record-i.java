class Solution {
    public boolean checkRecord(String s) {
        int absents = 0;
        int lateStreak = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            
            if (c == 'A') {
                absents++;
                if (absents > 1) return false;
            }

         
            if (c == 'L') {
                lateStreak++;
                if (lateStreak >= 3) return false;
            } else {
                lateStreak = 0;
            }
        }

        return true;
    }
}

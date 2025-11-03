class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;

        for (int b : bills) {
            if (b == 5) {
                fives++;
            } else if (b == 10) {
                if (fives == 0) return false;
                fives--;
                tens++;
            } else { // b == 20
                if (tens > 0 && fives > 0) {      // use 10 + 5 first
                    tens--;
                    fives--;
                } else if (fives >= 3) {          // otherwise 5 + 5 + 5
                    fives -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";

        boolean negative = num < 0;
        long n = num;               // uzun tip kullan, MIN_VALUE sorununu önle
        if (n < 0) n = -n;

        // 32-bit int için base-7 en fazla 11 rakam alır. +1 işaret için 12.
        char[] buf = new char[12];
        int idx = buf.length; // doldurmaya sondan başla

        while (n > 0) {
            int digit = (int)(n % 7);
            buf[--idx] = (char)('0' + digit);
            n /= 7;
        }

        if (negative) {
            buf[--idx] = '-';
        }

        return new String(buf, idx, buf.length - idx);
    }
}

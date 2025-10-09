class Solution {
    public String convertToBase7(int num) {
        // 0 için özel durum
        if (num == 0) return "0";

        boolean negative = num < 0;
        num = Math.abs(num);

        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(num % 7);  // kalan ekle
            num /= 7;            // böl
        }

        if (negative) sb.append("-");

        return sb.reverse().toString();
    }
}

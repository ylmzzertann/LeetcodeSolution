class Solution {
    public String convertToBase7(int num) {
        // 0 özel durumu
        if (num == 0) return "0";

        // Negatifse işaret tut
        boolean isNegative = num < 0;
        num = Math.abs(num);

        StringBuilder sb = new StringBuilder();

        // 7 tabanına çevirme işlemi
        while (num > 0) {
            int remainder = num % 7;   // kalan
            sb.append(remainder);
            num /= 7;                  // bölümü güncelle
        }

        // ters çevrilmeli çünkü kalanı sondan başa yazıyoruz
        if (isNegative) sb.append("-");
        return sb.reverse().toString();
    }
}

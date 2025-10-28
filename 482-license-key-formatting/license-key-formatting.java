class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        // Sondan başa: her k karakterde bir '-' koy
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '-') continue;
            if (c >= 'a' && c <= 'z') c = (char)(c - 'a' + 'A'); // toUpperCase hızlısı
            sb.append(c);
            count++;
            if (count == k) {
                sb.append('-');
                count = 0;
            }
        }
        // Sondaki tire varsa kaldır
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}

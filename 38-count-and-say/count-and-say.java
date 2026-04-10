class Solution {
    public String countAndSay(int n) {
        // İlk adım her zaman "1"dir.
        String result = "1";
        
        // n-1 defa dönüşüm işlemini uygula
        for (int i = 1; i < n; i++) {
            result = getNextSequence(result);
        }
        
        return result;
    }

    private String getNextSequence(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        
        for (int i = 0; i < s.length(); i++) {
            // Eğer bir sonraki karakter mevcut karakterle aynıysa sayacı artır
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                // Karakter değiştiğinde (veya sona gelindiğinde) "Say ve Söyle"
                sb.append(count).append(s.charAt(i));
                count = 1; // Sayacı sıfırla
            }
        }
        
        return sb.toString();
    }
}
class Solution {
    public int compareVersion(String version1, String version2) {
        // Stringleri noktalardan bölüyoruz
        // \\. kullanılmasının sebebi noktanın regex'te özel bir karakter olmasıdır
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int maxLength = Math.max(v1.length, v2.length);
        
        for (int i = 0; i < maxLength; i++) {
            // Eğer v1'de o indexte değer yoksa 0 kabul et, varsa Integer'a çevir
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            
            // Eğer v2'de o indexte değer yoksa 0 kabul et, varsa Integer'a çevir
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        
        // Tüm revizyonlar eşitse
        return 0;
    }
}
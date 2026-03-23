class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1; // a string'inin sonu
        int j = b.length() - 1; // b string'inin sonu
        int carry = 0;          // elde tutulan değer

        // Stringler bitene kadar veya elde (carry) kalmayana kadar devam et
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry; // Önceki basamaktan gelen eldeyi ekle
            
            if (i >= 0) {
                sum += a.charAt(i--) - '0'; // Char'ı int'e çevir ve ekle
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0'; // Char'ı int'e çevir ve ekle
            }
            
            // Mevcut basamağa yazılacak değer (0 veya 1)
            res.append(sum % 2);
            
            // Bir sonraki basamağa aktarılacak elde (0 veya 1)
            carry = sum / 2;
        }
        
        // Tersten eklediğimiz için string'i çevirip döndür
        return res.reverse().toString();
    }
}
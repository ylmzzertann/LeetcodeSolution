class Solution {
    public String addBinary(String a, String b) {
        // Sonucu toplamak için hızlı bir string oluşturucu
        StringBuilder sb = new StringBuilder();
        
        // String'lerin en sonundan (sağdaki basamaktan) başlıyoruz
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0; // Elde tutulan değer

        // Stringler bitene kadar veya elde (carry) kalmayana kadar döngü çalışır
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry; // Önceki basamaktan gelen eldeyi ekleyerek başla
            
            // Eğer a string'inde hala basamak varsa ekle
            if (i >= 0) {
                sum += a.charAt(i--) - '0'; // '1' - '0' işlemi char'ı int (1) yapar
            }
            
            // Eğer b string'inde hala basamak varsa ekle
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            
            // Toplamın 2'ye bölümünden kalan (0 veya 1) o basamağın değeridir
            sb.append(sum % 2);
            
            // Toplamın 2'ye bölümü (0 veya 1) sonraki basamağa aktarılacak eldedir
            carry = sum / 2;
        }
        
        // Basamakları sondan eklediğimiz için string'i ters çevirip döndürüyoruz
        return sb.reverse().toString();
    }
}
class Solution {
    /**
     * Verilen bir tamsayıyı sıfıra indirmek için gereken adım sayısını hesaplar.
     * Sayı çift ise 2'ye bölünür, tek ise 1 çıkarılır.
     *
     * @param num Sıfıra indirilecek negatif olmayan tamsayı.
     * @return Sayıyı sıfıra indirmek için gereken toplam adım sayısı.
     */
    public int numberOfSteps(int num) {
        // Atılan adımları saymak için bir sayaç başlatılır.
        int adimSayisi = 0;

        // Sayı 0'a ulaşana kadar döngü devam eder.
        while (num > 0) {
            // Sayının çift olup olmadığını kontrol et.
            // (num % 2 == 0) ifadesi, num'un 2'ye bölümünden kalanın 0 olup olmadığını kontrol eder.
            if (num % 2 == 0) {
                // Sayı çift ise 2'ye böl.
                num = num / 2;
            } else {
                // Sayı tek ise 1 çıkar.
                num = num - 1;
            }
            // Her işlem bir adım olduğu için sayacı bir artır.
            adimSayisi++;
        }

        // Toplam adım sayısını döndür.
        return adimSayisi;
    }
}
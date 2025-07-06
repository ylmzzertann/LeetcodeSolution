class Solution {
    public int balancedStringSplit(String s) {
        // Bölünebilecek maksimum dengeli alt dize sayısını tutan değişken.
        int maxParcaSayisi = 0;
        
        // 'L' ve 'R' karakterlerinin dengesini takip etmek için kullanılan sayaç.
        int dengeSayaci = 0;

        // Dizenin her bir karakteri üzerinde döngüye gir.
        // s.toCharArray() metodu, dizeyi bir karakter dizisine çevirir.
        for (char karakter : s.toCharArray()) {
            
            // Eğer karakter 'L' ise sayacı bir artır.
            if (karakter == 'L') {
                dengeSayaci++;
            } 
            // Eğer karakter 'R' ise sayacı bir azalt.
            else {
                dengeSayaci--;
            }

            // Eğer denge sayacı sıfır olduysa, bu bir dengeli alt dize bulduğumuz anlamına gelir.
            if (dengeSayaci == 0) {
                // Dengeli parça sayısını bir artır.
                maxParcaSayisi++;
            }
        }

        // Hesaplanan maksimum parça sayısını döndür.
        return maxParcaSayisi;
    }
}
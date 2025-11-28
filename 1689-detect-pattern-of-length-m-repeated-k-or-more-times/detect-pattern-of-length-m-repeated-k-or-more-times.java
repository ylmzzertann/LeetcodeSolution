class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        int count = 0;
        
        // i + m < n olduğu sürece döngüye devam et (Array sınırını aşmamak için)
        for (int i = 0; i + m < n; i++) {
            
            if (arr[i] != arr[i + m]) {
                // Eşleşme bozuldu, sayacı sıfırla
                count = 0;
            } else {
                // Eşleşme var (i. eleman ile m adım sonrası aynı)
                count++;
            }
            
            // Eğer yeterli sayıda ardışık eşleşme bulduysak (k-1 tane m uzunluğunda blok)
            if (count == (k - 1) * m) {
                return true;
            }
        }
        
        return false;
    }
}
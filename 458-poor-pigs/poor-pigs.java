class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // Kaç test turu yapabiliyoruz
        int rounds = minutesToTest / minutesToDie;
        // Bir domuz için olası durum sayısı (hangi turda ölür veya hiç ölmez)
        int states = rounds + 1;

        int pigs = 0;
        int capacity = 1; // states^pigs

        // states^pigs >= buckets olana kadar domuz ekle
        while (capacity < buckets) {
            pigs++;
            capacity *= states;
        }

        return pigs;
    }
}

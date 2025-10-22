class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // rec = [x1, y1, x2, y2]
        // Pozitif alanlı kesişim için sıkı (<) karşılaştırmalar gerekir (kenardan/köşeden temas false)
        boolean xOverlap = rec1[0] < rec2[2] && rec2[0] < rec1[2];
        boolean yOverlap = rec1[1] < rec2[3] && rec2[1] < rec1[3];
        return xOverlap && yOverlap;
    }
}

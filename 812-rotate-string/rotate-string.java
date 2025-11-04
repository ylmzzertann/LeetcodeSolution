class Solution {
    public boolean rotateString(String s, String goal) {
        // Uzunluklar farklıysa zaten mümkün değil
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Boş string için (ikisi de boşsa) true döner
        if (s.length() == 0) {
            return true;
        }
        
        // s+s içinde goal geçiyorsa rotate ile elde edilebilir
        String doubled = s + s;
        return doubled.contains(goal);
    }
}

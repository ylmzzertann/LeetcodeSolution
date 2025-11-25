class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0; // Pointer for name
        int j = 0; // Pointer for typed
        
        // Iterate through the typed string
        while (j < typed.length()) {
            // Scenario 1: Characters match
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } 
            // Scenario 2: Long press (current typed char equals the PREVIOUS name char)
            // Note: We check j > 0 to ensure we don't look back at index -1
            else if (j > 0 && typed.charAt(j) == name.charAt(i - 1)) {
                j++;
            } 
            // Scenario 3: Mismatch / Invalid character
            else {
                return false;
            }
        }
        
        // Ensure we actually finished the 'name' string
        // Example: name="abc", typed="aaabb" -> loop finishes, but i is not at end
        return i == name.length();
    }
}
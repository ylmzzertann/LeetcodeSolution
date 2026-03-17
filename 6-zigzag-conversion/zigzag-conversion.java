class Solution {
    public String convert(String s, int numRows) {
        // Base case: if numRows is 1 or string is short, no zigzag happens
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Initialize a list of StringBuilders (one for each row)
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Iterate through each character in the input string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // If we reach the top row or bottom row, change direction
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move the pointer up or down
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all StringBuilders into a single result string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
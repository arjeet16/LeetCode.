class Solution {
    public String convert(String s, int numRows) {

        // Edge case
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Create rows
        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        int direction = 1; // 1 = down, -1 = up

        // Put characters into rows
        for (char ch : s.toCharArray()) {

            rows[currentRow].append(ch);

            // Top row -> start going down
            if (currentRow == 0) {
                direction = 1;
            }

            // Bottom row -> start going up
            else if (currentRow == numRows - 1) {
                direction = -1;
            }

            currentRow += direction;
        }

        // Combine all rows
        StringBuilder answer = new StringBuilder();

        for (StringBuilder row : rows) {
            answer.append(row);
        }

        return answer.toString();
    }
}
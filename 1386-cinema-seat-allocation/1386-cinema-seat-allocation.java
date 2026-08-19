import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> reserved = new HashMap<>();

        // Store reserved seats as a bitmask for each row
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            reserved.put(row, reserved.getOrDefault(row, 0) | (1 << col));
        }

        // Every completely empty row can fit 2 groups
        long ans = 2L * n;

        // Only process rows that contain reserved seats
        for (int mask : reserved.values()) {

            boolean left = (mask & (
                    (1 << 2) |
                    (1 << 3) |
                    (1 << 4) |
                    (1 << 5)
            )) == 0;

            boolean middle = (mask & (
                    (1 << 4) |
                    (1 << 5) |
                    (1 << 6) |
                    (1 << 7)
            )) == 0;

            boolean right = (mask & (
                    (1 << 6) |
                    (1 << 7) |
                    (1 << 8) |
                    (1 << 9)
            )) == 0;

            if (left && right) {
                // 2 groups possible
            } else if (left || middle || right) {
                // Only 1 group possible
                ans--;
            } else {
                // No group possible
                ans -= 2;
            }
        }

        return (int) ans;
    }
}
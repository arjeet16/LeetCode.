import java.util.*;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            int[] nums,
            int index,
            List<Integer> current,
            List<List<Integer>> result) {

        // Add current subset
        result.add(new ArrayList<>(current));

        // Try remaining elements
        for (int i = index; i < nums.length; i++) {

            // Take nums[i]
            current.add(nums[i]);

            // Move forward
            backtrack(nums, i + 1, current, result);

            // Undo choice
            current.remove(current.size() - 1);
        }
    }
}
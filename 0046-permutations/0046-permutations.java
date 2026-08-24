class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        backtrack(nums, result, new ArrayList<>(), used);

        return result;
    }

    private void backtrack(
        int[] nums,
        List<List<Integer>> result,
        List<Integer> current,
        boolean[] used
    ) {

        // permutation complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // try every number
        for (int i = 0; i < nums.length; i++) {

            // already used
            if (used[i]) {
                continue;
            }

            // choose
            current.add(nums[i]);
            used[i] = true;

            // next position
            backtrack(nums, result, current, used);

            // undo choice
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
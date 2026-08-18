class Solution {
    public int pivotIndex(int[] nums) {

        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            total = total + nums[i];
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            int rightSum = total - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum = leftSum + nums[i];
        }

        return -1;
    }
}
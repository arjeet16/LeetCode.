class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] answer = new int[n];

        // Step 1: Store left products
        int leftProduct = 1;

        for (int i = 0; i < n; i++) {

            answer[i] = leftProduct;

            leftProduct *= nums[i];
        }

        // Step 2: Multiply by right products
        int rightProduct = 1;

        for (int i = n - 1; i >= 0; i--) {

            answer[i] *= rightProduct;

            rightProduct *= nums[i];
        }

        return answer;
    }
}
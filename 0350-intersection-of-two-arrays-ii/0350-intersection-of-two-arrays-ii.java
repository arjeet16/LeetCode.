class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];
        int k = 0;

        boolean[] used = new boolean[nums2.length];

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j] && !used[j]) {

                    result[k] = nums1[i];
                    k++;

                    used[j] = true;

                    break;
                }
            }
        }

        int[] answer = new int[k];

        for (int i = 0; i < k; i++) {
            answer[i] = result[i];
        }

        return answer;
    }
}

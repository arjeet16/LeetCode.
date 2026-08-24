class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];
        int k = 0;

        for (int i = 0; i < nums1.length; i++) {

            boolean found = false;

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    found = true;
                    break;
                }
            }

            if (found) {

                boolean alreadyThere = false;

                for (int x = 0; x < k; x++) {

                    if (result[x] == nums1[i]) {
                        alreadyThere = true;
                        break;
                    }
                }

                if (!alreadyThere) {
                    result[k] = nums1[i];
                    k++;
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
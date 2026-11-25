class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // If mid is greater than right, minimum must be after mid.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // Otherwise, mid could be the minimum,
            // so keep mid in the search range.
            else {
                right = mid;
            }
        }

        // left and right meet at the minimum element.
        return nums[left];
    }
}
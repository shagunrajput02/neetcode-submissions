class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        // Continue while there is still a valid search range.
        while (left <= right) {

            // Find the middle index of the current search range.
            int mid = left + (right - left) / 2;

            // If the middle element itself is the target, we are done.
            if (nums[mid] == target) {
                return mid;
            }

            // If nums[left] <= nums[mid], the left half is sorted.
            if (nums[left] <= nums[mid]) {

                // Check if target lies inside the sorted left half.
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    // Otherwise, target can only be in the right half.
                    left = mid + 1;
                }

            } else {

                // If the left half isn't sorted, the right half must be sorted.
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    // Otherwise, target can only be in the left half.
                    right = mid - 1;
                }
            }
        }

        // Search range is empty, so target doesn't exist.
        return -1;
    }
}
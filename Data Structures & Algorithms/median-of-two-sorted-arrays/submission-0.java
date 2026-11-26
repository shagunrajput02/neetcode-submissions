class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Binary search should run on the smaller array.
        // This ensures partition2 always stays within valid boundaries.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        while (left <= right) {

            // partition1 tells how many nums1 elements go to the left side.
            int partition1 = left + (right - left) / 2;

            // The total left side must contain half the combined elements.
            int partition2 = (m + n + 1) / 2 - partition1;

            // If nums1 contributes nothing to the left side,
            // treat its left boundary as negative infinity.
            int left1 = (partition1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partition1 - 1];

            // If nums1 contributes nothing to the right side,
            // treat its right boundary as positive infinity.
            int right1 = (partition1 == m)
                    ? Integer.MAX_VALUE
                    : nums1[partition1];

            // Handle the left boundary of nums2 in the same way.
            int left2 = (partition2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partition2 - 1];

            // Handle the right boundary of nums2 in the same way.
            int right2 = (partition2 == n)
                    ? Integer.MAX_VALUE
                    : nums2[partition2];

            // The partition is correct when both left-side values
            // are less than or equal to the opposite right-side values.
            if (left1 <= right2 && left2 <= right1) {

                // For an odd number of elements, the left side has
                // one extra element, so its largest value is the median.
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // For an even number of elements, the median is the
                // average of the largest left value and smallest right value.
                int maxLeft = Math.max(left1, left2);
                int minRight = Math.min(right1, right2);

                // Divide by 2.0 so Java returns a decimal result.
                return ((double) maxLeft + minRight) / 2.0;
            }

            // left1 is too large, so nums1 is contributing
            // too many elements to the left side.
            else if (left1 > right2) {
                right = partition1 - 1;
            }

            // left2 is too large, so nums1 must contribute
            // more elements to the left side.
            else {
                left = partition1 + 1;
            }
        }

        // The input arrays are sorted, so execution should never reach here.
        throw new IllegalArgumentException("Input arrays must be sorted.");
    }
}
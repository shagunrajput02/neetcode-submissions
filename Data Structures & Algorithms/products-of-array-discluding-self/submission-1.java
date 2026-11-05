class Solution {
    public int[] productExceptSelf(int[] nums) {

        // Answer array to store product of all elements except the current element
        int[] answer = new int[nums.length];

        // Start with 1 because there is no element before the first element
        int prefix = 1;

        // Calculate product of all elements to the left of each index
        for(int i = 0; i < nums.length; i++) {

            // Store product of elements before the current index
            answer[i] = prefix;

            // Include current element in prefix for the next index
            prefix *= nums[i];
        }

        // Start with 1 because there is no element after the last element
        int suffix = 1;

        // Move from right to left to calculate product of elements on the right 
        // Start from last index and use i >= 0 because index 0 also needs to be processed
        for(int i = nums.length - 1; i >= 0; i--) {

            // Multiply left product with right product to get product except self
            answer[i] *= suffix;

            // Include current element in suffix for the previous index
            suffix *= nums[i];
        }

        // Return the final product except self array
        return answer;
    }
}
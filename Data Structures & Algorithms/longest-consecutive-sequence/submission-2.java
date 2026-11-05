class Solution {
    public int longestConsecutive(int[] nums) {

        // HashSet stores unique numbers and allows fast checking if a number exists
        HashSet<Integer> set = new HashSet<>();

        // Add all numbers into the set to remove duplicates and make searching faster
        for(int num : nums) {
            set.add(num);
        }

        // Stores the longest consecutive sequence length found so far
        int longest = 0;

        // Check every unique number in the set
        for(int num : set) {

            // Start counting only if num is the beginning of a sequence
            // If num - 1 does not exist, there is no smaller consecutive number before it
            if(!set.contains(num - 1)) {

                // Start the sequence from the current number
                int currentNum = num;

                // Length starts from 1 because currentNum itself is the first number
                int currentLength = 1;

                // Keep checking the next consecutive number: currentNum + 1
                while(set.contains(currentNum + 1)) {

                    // Move to the next consecutive number
                    currentNum++;

                    // Increase length because another consecutive number was found
                    currentLength++;
                }

                // Keep the greater length between previous longest and current sequence
                longest = Math.max(longest, currentLength);
            }
        }

        // Return the longest consecutive sequence length
        return longest;
    }
}
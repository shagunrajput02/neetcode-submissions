class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // HashMap for key-value: key = number, value = frequency
        Map<Integer, Integer> map = new HashMap<>();

        // Loop through all numbers in nums to count their frequency
        for(int num : nums) {

            // getOrDefault gets current frequency, or 0 if number is not present, then increases it by 1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Get all unique numbers (keys) from map and store them in a list
        List<Integer> list = new ArrayList<>(map.keySet());

        // Sort the list based on frequency from highest to lowest
        list.sort(Comparator.comparingInt(map::get).reversed());

        // Create result array of size k to store top k frequent numbers
        int[] result = new int[k];

        // Loop k times to get first k numbers from the sorted list
        for(int i = 0; i < k; i++) {

            // Put the current number from list into result array
            result[i] = list.get(i);
        }

        // Return the top k frequent numbers
        return result;
    }
}
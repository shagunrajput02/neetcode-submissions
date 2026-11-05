class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Build frequency arrays
        for (int i = 0; i < n; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (java.util.Arrays.equals(freq1, freq2)) {
            return true;
        }

        // Slide the window
        for (int right = n; right < m; right++) {

            freq2[s2.charAt(right) - 'a']++;       // add new char
            freq2[s2.charAt(right - n) - 'a']--;   // remove old char

            if (java.util.Arrays.equals(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }
}
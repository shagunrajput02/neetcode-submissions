class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] map = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, new StringBuilder(), map, result);

        return result;
    }

    private void backtrack(String digits, int index,
                           StringBuilder current,
                           String[] map,
                           List<String> result) {

        // Base case
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters corresponding to current digit
        String letters = map[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {

            // Choose
            current.append(ch);

            // Explore next digit
            backtrack(digits, index + 1, current, map, result);

            // Undo choice
            current.deleteCharAt(current.length() - 1);
        }
    }
}

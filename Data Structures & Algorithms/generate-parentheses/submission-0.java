
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    private void backtrack(List<String> result,
                           StringBuilder current,
                           int open,
                           int close,
                           int n) {

        // Base case
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Add '(' if we still have opening brackets available
        if (open < n) {
            current.append('(');

            backtrack(result, current, open + 1, close, n);

            // Backtrack
            current.deleteCharAt(current.length() - 1);
        }

        // Add ')' only if there is an unmatched '('
        if (close < open) {
            current.append(')');

            backtrack(result, current, open, close + 1, n);

            // Backtrack
            current.deleteCharAt(current.length() - 1);
        }
    }
}
class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Create 9 sets because Sudoku has 9 rows, each set stores numbers already seen in that row
        HashSet<Character>[] rows = new HashSet[9];

        // Create 9 sets because Sudoku has 9 columns, each set stores numbers already seen in that column
        HashSet<Character>[] cols = new HashSet[9];

        // Create 9 sets because Sudoku has 9 boxes of size 3x3
        HashSet<Character>[] boxes = new HashSet[9];

        // Initialize a separate HashSet for every row, column and box
        for(int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Go through all 9 rows
        for(int i = 0; i < 9; i++) {

            // Go through all 9 columns of the current row
            for(int j = 0; j < 9; j++) {

                // Get the value present at current row i and column j
                char num = board[i][j];

                // '.' means the cell is empty, so there is nothing to check
                if(num == '.') {
                    continue;
                }

                // Find which 3x3 box the current cell belongs to
                // i/3 gives box row (0,1,2) and j/3 gives box column (0,1,2)
                // Multiplying box row by 3 gives a unique box index from 0 to 8
                int boxIndex = (i / 3) * 3 + (j / 3);

                // If number already exists in same row, column or 3x3 box, Sudoku is invalid
                if(rows[i].contains(num) ||
                   cols[j].contains(num) ||
                   boxes[boxIndex].contains(num)) {
                    return false;
                }

                // Store number in its row so duplicate can be detected later
                rows[i].add(num);

                // Store number in its column so duplicate can be detected later
                cols[j].add(num);

                // Store number in its 3x3 box so duplicate can be detected later
                boxes[boxIndex].add(num);
            }
        }

        // If no duplicate was found in any row, column or box, Sudoku is valid
        return true;
    }
}
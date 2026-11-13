class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length; //total number of rows
        int cols = matrix[0].length; //total number of columns

        int left = 0; //first index of imaginary 1D array
        int right = rows * cols - 1; //last index of imaginary 1D array

        while (left <= right) {

            int mid = left + (right - left) / 2; //middle index

            int row = mid / cols; //convert 1D index to row
            int col = mid % cols; //convert 1D index to column

            if (matrix[row][col] == target) {
                return true; //target found
            }

            if (matrix[row][col] < target) {
                left = mid + 1; //target must be on right side
            } else {
                right = mid - 1; //target must be on left side
            }
        }

        return false; //target not present
    }
}
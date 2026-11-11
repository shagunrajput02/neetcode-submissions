class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>(); //stores indexes of bars in increasing height order
        int maxArea = 0; //stores largest rectangle area found

        for (int i = 0; i <= heights.length; i++) {

            int currHeight = (i == heights.length) ? 0 : heights[i]; //use 0 at end to process remaining bars

            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()]; //height of rectangle to calculate

                int width;

                if (stack.isEmpty()) {
                    width = i; //rectangle can extend from index 0 to i-1
                } else {
                    width = i - stack.peek() - 1; //width between smaller bars on left and right
                }

                int area = height * width; //calculate rectangle area
                maxArea = Math.max(maxArea, area); //keep the largest area
            }

            stack.push(i); //store current index for future rectangle calculation
        }

        return maxArea;
    }
}
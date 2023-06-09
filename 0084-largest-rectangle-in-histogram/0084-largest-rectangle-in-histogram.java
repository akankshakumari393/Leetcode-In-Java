class Solution {

    public int largestRectangleArea(int[] heights) {
        int[] nse = nextSmallIndex(heights);
        int[] pse = previousSmallIndex(heights);
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * ((nse[i]-1) - (pse[i]+1) + 1));
        }
        return max;
    }

    public static int[] nextSmallIndex(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];

        Stack<Integer> maxheap = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int element = heights[i];
            while (!maxheap.isEmpty() && element <= heights[maxheap.peek()]) {
                maxheap.pop();
            }
            if (!maxheap.isEmpty()) {
                nse[i] = maxheap.peek();
            } else {
                nse[i] = n;
            }
            maxheap.push(i);
        }
        return nse;
    }

    public static int[] previousSmallIndex(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];

        Stack<Integer> maxheap = new Stack<>();
        for (int i = 0; i < n; i++) {
            int element = heights[i];
            while (!maxheap.isEmpty() && element <= heights[maxheap.peek()]) {
                maxheap.pop();
            }
            if (!maxheap.isEmpty()) {
                pse[i] = maxheap.peek();
            } else {
                pse[i] = -1;
            }
            maxheap.push(i);
        }
        return pse;
    }
}

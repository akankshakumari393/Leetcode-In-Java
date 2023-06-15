/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// BFS
import java.util.*;

class Solution {
    public int maxLevelSum(TreeNode root) {
        return bfs(root);
    }

    private int bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int maxSumLevel = -1;
        int maxSum = Integer.MIN_VALUE;
        int level =1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            int sum = 0;
            while (n > 0) {
                TreeNode node = queue.poll();
                sum = sum + node.val;
                if (node.left != null) {
                    queue.add(node.left);
                } 
                if (node.right != null) {
                    queue.add(node.right);
                }   
                n--;
            }
            if (maxSum < sum) {
                maxSum = sum;
                maxSumLevel = level;
            }
            level++;
        }
        return maxSumLevel;
    }
}
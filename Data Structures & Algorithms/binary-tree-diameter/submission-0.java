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
/*
CORE IDEA: 
---> Take variable 'MAX_DIAMETER'
---> Update as per condition
---> Diameter is necessarily sum of leftHeight and rightHeight
*/
class Solution {
    //Class variable
    int max_diameter = Integer.MIN_VALUE;
    //helper method - calculateHeight
    private int calculateHeight(TreeNode root){
        if(root==null) return 0;
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        max_diameter = Math.max(max_diameter, leftHeight+rightHeight);
        return 1+Math.max(leftHeight, rightHeight);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        //function call
        calculateHeight(root);
        return max_diameter;
    }
}

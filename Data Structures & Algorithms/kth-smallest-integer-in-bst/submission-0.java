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
CORE IDEA: Inorder traversal of BST --> elements in ASCENDING order
---> Store data in List and return kth smallest element
*/
class Solution {
    //Global arraylist
    List<Integer> values = new LinkedList<>();
    //helper method
    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        values.add(root.val);
        inOrder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        inOrder(root);
        //Check if k is out of elements idx range
        if(values.size()<k) return -1;
        return values.get(k-1);
    }
}

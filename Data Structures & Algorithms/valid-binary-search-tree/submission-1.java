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

class Solution {
    List<Integer> elements = new ArrayList<>();
    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        elements.add(root.val);
        inOrder(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null) return false;
        inOrder(root);
        for(int i=1; i<elements.size(); i++){
            if(elements.get(i)<=elements.get(i-1)) return false;
        }

        return true;
    }
}

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
HELPER METHOD: isSameTree()
---> Check isSameTree(root.left, subRoot)
---> Check isSameTree(root.right, subRoot)
    ---> If either is TRUE, return true as found
else return FALSE
Initially, root is null, then return false, as parent doesn't exist...
*/
class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        //Case: If subRoot and root are same
        if(isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    //Helper method
    private boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        else if (p==null || q==null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while(!nodes.isEmpty()){
            int levelSize = nodes.size();
            List<Integer> pocket = new ArrayList<>();
            for(int i=0; i<levelSize; i++){
                TreeNode current = nodes.poll();
                pocket.add(current.val);

                if(current.left!=null) nodes.offer(current.left);
                if(current.right!=null) nodes.offer(current.right);
            }

            result.add(pocket);
        }

        return result;
    }
}

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        //Perform Level-Order Traversal
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while(!nodes.isEmpty()){
            int levelSize = nodes.size();
            List<Integer> levelElements = new ArrayList<>();
            for(int i=0; i<levelSize; i++){
                TreeNode currNode = nodes.poll();
                levelElements.add(currNode.val);
                if(currNode.left!=null) nodes.offer(currNode.left);
                if(currNode.right!=null) nodes.offer(currNode.right);
            }
            result.add(levelElements.get(levelSize-1));
        }
        return result;
    }
}

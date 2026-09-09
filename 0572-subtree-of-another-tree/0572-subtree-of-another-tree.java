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
    public boolean same(TreeNode a,TreeNode b){
        if(a==null && b==null){
            return true;
        }
        if(a==null || b==null || a.val!=b.val){
            return false;
        }
        return same(a.left,b.left)&&same(a.right,b.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        if(same(root,subRoot)){
            return true;
        }
        return isSubtree(root.right,subRoot)|| isSubtree(root.left,subRoot);
        
    }
}
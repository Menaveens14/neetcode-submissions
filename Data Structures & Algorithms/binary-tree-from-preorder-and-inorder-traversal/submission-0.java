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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer, Integer> map =  new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        
        return build(preorder, inorder, 0, 0, preorder.length-1, map);
 

        

    }


    public TreeNode build(int[] preorder, int[] inorder, int index,  int l, int r, Map<Integer, Integer> map){

        //TreeNode node = new TreeNode(preorder[index]);

        TreeNode leftChild = null;
        TreeNode rightChild = null;

        int value = preorder[index];
        int m = map.get(value);
        
        //int leftIndex = preorder[index+1];
        //int rightIndex = preorder[index+l+1];

        int l_count = m - l;
        int r_count = r - m;

        if(l_count>0){
            leftChild = build(preorder, inorder,index+1, l, m-1, map );
        }
        if(r_count > 0){
            rightChild = build(preorder, inorder,index+l_count+1, m+1, r, map );
        }

        TreeNode root = new TreeNode(value, leftChild, rightChild);

        return root;

     
    }
}
public class A0965UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean left=false;
        boolean right=false;
        if(root.left!=null && root.val!=root.left.val){
            return false;
        }else{
            left=isUnivalTree(root.left);
        }
        if(root.right!=null && root.val!=root.right.val){
            return false;
        }else {
            right=isUnivalTree(root.right);
        }
        return left&&right;
    }

}

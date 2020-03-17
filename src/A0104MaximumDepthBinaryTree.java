public class A0104MaximumDepthBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }




//    2019-10写的方法
    public int maxDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
        int depth=1;
        return f(root,depth);

    }

    private int f(TreeNode t, int depth){
        if(t==null){
            return depth;
        }
        if(t.left != null || t.right != null){
            return Math.max(f(t.left,depth+1),f(t.right,depth+1));
        }
        return depth;
    }


}

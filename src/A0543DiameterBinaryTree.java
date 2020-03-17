public class A0543DiameterBinaryTree {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        depth(root);
        return ans-2;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int depthLeft = depth(node.left) + 1;
            int depthRight = depth(node.right) + 1;
            ans = Math.max(ans, depthLeft + depthRight);
            return Math.max(depthLeft, depthRight);
        }
    }
}

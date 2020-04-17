public class A0687LongestUnivaluePath {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if(root==null){
            return 0;
        }
        int t = f(root.left,root.val)+f(root.right,root.val);
        return Math.max(max,t);
    }

    public int f(TreeNode node, int pValue) {
        if (node == null) {
            return 0;
        } else {
            int tl = f(node.left, node.val);
            int tr = f(node.right, node.val);
            max = Math.max(max, tl+tr);
            if (node.val != pValue) {
                return 0;
            } else {
                return Math.max(tl,tr)+1;
            }
        }
    }
}

public class A0235LowestCommonAncestorBinarySearchTree {

    TreeNode commonNode = null;
//这道题上晕了一天，然后发现问题出在没看清题目，题目要找到common node，而且必定存在，我一直在考虑不存在的情况，绕死自己了
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ft(root,p,q);
        return commonNode;
    }

    public void ft(TreeNode node, TreeNode t1, TreeNode t2) {
        if ((t1.val - node.val) * (t2.val - node.val) <= 0) {
            commonNode = node;
        } else if (t1.val > node.val && t2.val > node.val) {
            ft(node.right, t1, t2);
        } else if (t1.val < node.val && t2.val < node.val) {
            ft(node.left, t1, t2);
        }
    }


}

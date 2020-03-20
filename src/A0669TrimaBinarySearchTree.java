public class A0669TrimaBinarySearchTree {
//标准答案
    public TreeNode trimBST2(TreeNode root, int L, int R) {
        if (root == null) return root;
//下面两行条件满足 就跳过，查找下一个左或右，如果root节点变化，也在这一步实现
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);
//查找左右
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
//虽然写出来了，但是太复杂，标准答案真是简洁啊
    public TreeNode trimBST(TreeNode root, int L, int R) {
        TreeNode newRoot = findNewRoot(root, L, R);
        buildLeft(newRoot, L);
        buildRight(newRoot, R);
        return newRoot;
    }

    private TreeNode findNewRoot(TreeNode node, int L, int R) {
        if (node == null) {
            return null;
        }
        if (node.val < L) {
            return findNewRoot(node.right, L, R);
        } else if (node.val > R) {
            return findNewRoot(node.left, L, R);
        } else {// L<=nodeval<=R
            return node;
        }
    }

    private void buildLeft(TreeNode node, int L) {
        if (node == null || node.left == null) {
            return;
        }

        if (node.left.val < L) {
            node.left = node.left.right;
            buildLeft(node, L);
        } else {//node.val >= L
            buildLeft(node.left, L);
            buildLeft(node.right, L);
        }
    }

    private void buildRight(TreeNode node, int R) {
        if (node == null || node.right == null) {
            return;
        }
        if (node.right.val > R) {
            node.right = node.right.left;
            buildRight(node, R);
        } else {//node.val >= L
            buildRight(node.left, R);
            buildRight(node.right, R);
        }
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(0);
        test.right = new TreeNode(2);
        TreeNode treeNode = new A0669TrimaBinarySearchTree().trimBST(test, 1, 2);
        treeNode.printByLayer();
    }

}

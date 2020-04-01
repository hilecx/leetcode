public class A0671SecondMinimumNodeInaBinaryTree {
    int min;
    Integer min2nd = null;

    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        f(root);
        if (min2nd == null || min2nd == min) {
            return -1;
        }
        return min2nd;
    }

    private void f(TreeNode node) {
        if (node == null) {
            System.out.printf("node is null\n");
            return;
        }
        if (node.val == min) {
            System.out.printf("node val:%d == min\n", min);
            f(node.left);
            f(node.right);
        } else {
            if (min2nd == null) {
                min2nd = node.val;
            } else {
                min2nd = Math.min(node.val, min2nd);
            }
            System.out.printf("node val:%d != min, and new min2nd=%d\n", node.val, min2nd);
        }
    }
}

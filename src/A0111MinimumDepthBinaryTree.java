public class A0111MinimumDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
//        int r = Integer.MAX_VALUE;
//        if (root.right != null) {
//            r = Math.min(minDepth(root.right.left, root.right.right) + 1, r);
//        }
//        if (root.left != null) {
//            r = Math.min(minDepth(root.left.left, root.left.right) + 1, r);
//        }
//        return r + 1;
        return minDepth(root.left,root.right)+1;
    }

    public int minDepth(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return 0;
        }

        int mld = left == null?Integer.MAX_VALUE:minDepth(left.left, left.right) + 1;
        int mrd = right == null?Integer.MAX_VALUE:minDepth(right.left, right.right) + 1;
        return Math.min(mld, mrd);
    }

    public static void main(String[] args) {
        TreeNode root;
        int a;
//        [3,9,20,null,null,15,7]
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        a = new A0111MinimumDepthBinaryTree().minDepth(root);
        System.out.println(a);
//        [1,2]
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        a = new A0111MinimumDepthBinaryTree().minDepth(root);
        System.out.println(a);


//        [1,2,2,3,3,null,null,4,4]
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        a = new A0111MinimumDepthBinaryTree().minDepth(root);
        System.out.println(a);
    }
}

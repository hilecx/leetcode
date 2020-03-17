import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A0110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {

        return f(root)!=-1;
    }

    public int f(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int ld = f(node.left);
        int rd = f(node.right);
        if (ld == -1 || rd == -1) {
            return -1;
        }
        if (Math.abs(ld - rd) >= 2) {
            return -1;
        }else {
            return Math.max(ld,rd)+1;
        }
    }

    public static void main(String[] args) {
//        [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        boolean a = new A0110BalancedBinaryTree().isBalanced(root);
        System.out.println(a);


//        [1,2,2,3,3,null,null,4,4]
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        a = new A0110BalancedBinaryTree().isBalanced(root);
        System.out.println(a);
    }
}

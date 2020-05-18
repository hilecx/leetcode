import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class A1008ConstructBinarySearchTreefromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        f(preorder, 1, preorder.length - 1, root);
        return root;
    }

    public void f(int[] preorder, int start, int end, TreeNode parent) {
        if (start > end) {
            return;
        }
        if (preorder[start] < parent.val) {
            parent.left = new TreeNode(preorder[start]);
            int i = start + 1;
            for (; i <= end; i++) {
                if (preorder[i] > parent.val) {
                    parent.right = new TreeNode(preorder[i]);
                    f(preorder, i+1, end, parent.right);
                    break;
                }
            }
            f(preorder, start + 1, i - 1, parent.left);
        } else {
            parent.right = new TreeNode(preorder[start]);
            f(preorder, start + 1, end, parent.right);
        }
    }

    public static void main(String[] args) {
        new A1008ConstructBinarySearchTreefromPreorderTraversal().bstFromPreorder(new int[]{8,5,1,7});
    }
}

import java.util.HashMap;
import java.util.Map;

public class A0437PathSumIII3 {
    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        findFromRoot(root, sum);
        return count;
    }

    private void findFromRoot(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum == root.val) {
            count++;
        }
        find(root.left, sum - root.val);
        findFromRoot(root.left, sum);
        find(root.right, sum - root.val);
        findFromRoot(root.right, sum);
    }

    private void find(TreeNode node, int diff) {
        if (node == null) {
            return;
        }
        if (diff == node.val) {
            count++;
        }
        find(node.left, diff - node.val);
        find(node.right, diff - node.val);
    }

}
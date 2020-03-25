import java.util.HashSet;
import java.util.Set;

public class A0653TwoSumIV {
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(root.val)) {
            return true;
        }
        set.add(k - root.val);
        return findTarget(root.right, k) || findTarget(root.left, k);
//        if (diff < root.val) {
//            return findTarget(root.left, k);
//        } else if (diff > root.val) {
//            return findTarget(root.right, k);
//        } else { //==
//            return findTarget(root.right, k) || findTarget(root.left, k);
//        }
    }
}

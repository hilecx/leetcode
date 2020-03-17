import java.util.*;

public class A0107BinaryTreeLevelOrderTraversalII {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root);
        queue.offerFirst(null);
        List<List<Integer>> r = new ArrayList<>();
        if(root==null){
            return r;
        }
        List<Integer> t = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollLast();
            if (node == null) {
                queue.offerFirst(null);
                r.add(t);
                t = new ArrayList<>();
                if (queue.size() == 1) {
                    break;
                }
            } else if (node != null) {
                t.add(node.val);
            }
            if (node != null && node.left != null) {
                queue.offerFirst(node.left);
            }
            if (node != null && node.right != null) {
                queue.offerFirst(node.right);
            }
        }
        Collections.reverse(r);
        return r;

    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.left.left = new TreeNode(15);
//        root.left.right = new TreeNode(7);

        TreeNode root = null;
        List<List<Integer>> r = new A0107BinaryTreeLevelOrderTraversalII().levelOrderBottom(root);
        System.out.println(Arrays.toString(r.toArray()));
    }
}

import java.util.*;

public class A0107BinaryTreeLevelOrderTraversalII2 {

//优化版本，通过queue.size()判断层数即可
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> sublist = new ArrayList<>();
        sublist.add(root.val);
        list.add(sublist);
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            sublist = new ArrayList<>();
            for (int i = 0; i <size; i++) {
                TreeNode node=queue.poll();
                if(node.left!=null){
                    sublist.add(node.left.val);
                    queue.add(node.left);
                }
                if(node.right!=null){
                    sublist.add(node.right.val);
                    queue.add(node.right);
                }
            }
            if(sublist.size()>0) {
                list.add(0, sublist);
            }
        }

        return list;

    }

    private void f(TreeNode node, List<TreeNode> list) {
        list.add(node.left);
        list.add(node.right);
        if (node.left != null) {
            f(node.left, list);
        }
        if (node.right != null) {
            f(node.right, list);
        }
    }


    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.left.left = new TreeNode(15);
//        root.left.right = new TreeNode(7);

        TreeNode root = null;
        List<List<Integer>> r = new A0107BinaryTreeLevelOrderTraversalII2().levelOrderBottom(root);
        System.out.println(Arrays.toString(r.toArray()));
    }
}

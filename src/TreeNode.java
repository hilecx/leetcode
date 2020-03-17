import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    public void printByLayer() {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        stack.add(this);
        while (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            for (int i = list.size()-1; i >=0; i--) {

                System.out.printf("%d ", list.get(i)==null?null:list.get(i).val);
                if (list.get(i) != null) {
                    stack.add(list.get(i).left);
                    stack.add(list.get(i).right);
                }
            }
            list.clear();
        }
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
       root.printByLayer();
    }
}

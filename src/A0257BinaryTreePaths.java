import java.util.ArrayList;
import java.util.List;

public class A0257BinaryTreePaths {
    List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return list;
        }else {
            f(String.valueOf(root.val),root);
        }
        return list;

    }

    public void f(String s, TreeNode node) {
        if (node.left == null && node.right == null) {
            list.add(s);
        }
        if (node.left != null) {
            f(new StringBuilder(s).append("->").append(node.left.val).toString(), node.left);
        }
        if (node.right != null) {
            f(new StringBuilder(s).append("->").append(node.right.val).toString(), node.right);
        }
    }
}

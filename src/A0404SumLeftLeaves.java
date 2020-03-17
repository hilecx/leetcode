import sun.reflect.generics.tree.Tree;

public class A0404SumLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {

        return f(root,false);
    }

    public int f(TreeNode node, boolean isleft){
        if(node==null){
            return 0;
        }else if(node.left==null && node.right==null && isleft){
            return node.val;
        }else if(node.left!=null ||node.right!=null){
            return f(node.left, true) + f(node.right,false);
        }else {
            return 0;
        }
    }
}
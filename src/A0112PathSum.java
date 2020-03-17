import java.util.Stack;

public class A0112PathSum {


    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        sum = sum-root.val;
        if(sum==0 && isleaf(root)){
            return true;
        }
        return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);

    }


    public boolean isleaf(TreeNode node){
        if(node==null){
            return false;
        }
        return node.left==null && node.right==null;
    }
    public static void main(String[] args) {
        TreeNode root;
        boolean a;
//        [3,9,20,null,null,15,7]
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        a = new A0112PathSum().hasPathSum(root,12);
        System.out.println(a);
//        [1,2]
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        a = new A0112PathSum().hasPathSum(root,1);
        System.out.println(a);


//        [1,2,2,3,3,null,null,4,4]
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        a = new A0112PathSum().hasPathSum(root,10);
        System.out.println(a);
    }
}
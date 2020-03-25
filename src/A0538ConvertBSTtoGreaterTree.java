public class A0538ConvertBSTtoGreaterTree {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        f(root);
        return root;
    }

    private void f(TreeNode node) {
        if(node==null){
            return;
        }
        f(node.right);
        sum+=node.val;
        node.val=sum;
        f(node.left);
    }


}

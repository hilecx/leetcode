import java.util.Arrays;

public class A0108ConvertArrayBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        TreeNode node = new TreeNode(nums[nums.length/2]);
        f1(node,Arrays.copyOfRange(nums,0,(nums.length/2)), Arrays.copyOfRange(nums,(nums.length/2)+1,nums.length));
        return node;
    }


    public void f1(TreeNode parent,int[] numsLeft,int[] numsRight){
        if(numsLeft.length==1){
            parent.left = new TreeNode(numsLeft[0]);
        }
        if(numsLeft.length==0){
            return;
        }
        if(numsRight.length==1){
            parent.right = new TreeNode(numsRight[0]);
        }
        if(numsRight.length==0){
            return;
        }
        parent.left =new TreeNode(numsLeft[numsLeft.length/2]);
        f1(parent.left, Arrays.copyOfRange(numsLeft,0,(numsLeft.length/2)), Arrays.copyOfRange(numsLeft,(numsLeft.length/2)+1,numsLeft.length));

        parent.right =new TreeNode(numsRight[numsRight.length/2]);
        f1(parent.right, Arrays.copyOfRange(numsRight,0,(numsRight.length/2)), Arrays.copyOfRange(numsRight,(numsRight.length/2)+1,numsRight.length));
    }

    public void f(TreeNode node,int[] nums,int left,int right,int mid ){
        if(left>mid || right<mid){
            return;
        }
        node.left = new TreeNode(nums[(mid-left)/2]);
        node.right = new TreeNode(nums[mid+(right-mid)/2]);
        f(node.left,nums,left,mid-1,(mid-left)/2);
        f(node.right,nums,mid+1,right,mid+(right-mid)/2);
    }

    public static void main(String[] args) {
        TreeNode node = new A0108ConvertArrayBinarySearchTree().sortedArrayToBST(new int[]{-10,-3,0,5,9});
        node.printByLayer();

    }
}

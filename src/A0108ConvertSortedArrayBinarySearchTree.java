public class A0108ConvertSortedArrayBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        int m = nums.length/2;
        TreeNode root = new TreeNode(nums[m]);
        f(root,nums,0,m,nums.length-1);
        return root;

    }

    private void f(TreeNode node, int[] nums, int start, int mid, int end){
        if(end==start){
            return;
        }
        if(start<mid){
            int midL=mid/2+start/2;
            node.left = new TreeNode(nums[midL]);
            f(node.left,nums,start,midL,mid-1);
        }

        if(end>mid){
            int midR=(end+1)/2+(mid+1)/2;
            node.right = new TreeNode(nums[midR]);
            f(node.right,nums,mid+1,midR,end);
        }

    }

    public static void main(String[] args) {

    }
}

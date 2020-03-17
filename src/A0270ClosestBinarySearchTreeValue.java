public class A0270ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        double cminDiff = Double.MAX_VALUE;
        TreeNode cnode = root;
        TreeNode rnode = root;
        double minDiff;
        while (cnode != null) {
            if (cnode == null) {
                break;
            }
            minDiff = Math.abs(cnode.val - target);
            if (minDiff < cminDiff) {
                rnode = cnode;
                cminDiff = minDiff;
            }

            if (cnode.val > target) {
                cnode = cnode.left;
            } else if (cnode.val < target) {
                cnode = cnode.right;
            } else {
                break;
            }

        }
        return rnode.val;
    }


    public static void main(String[] args) {
        int i = 3;
        double d = 3.3;
        System.out.println(Math.abs(i - d));
    }
}

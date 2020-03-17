import java.math.BigInteger;

public class A0617MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 != null && t2 == null) {
            return t1;
        }
        if (t1 == null && t2 != null) {
            return t2;
        }
        TreeNode newNode = new TreeNode(t1.val + t2.val);
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        return newNode;
    }


//    疫情感染人数数据预测
    public static void main(String[] args) {
        BigInteger i = new BigInteger("1");
        double d = 1.074325509595481;
        double r= 61243;
        for (int j = 1; j <= 365; j++) {
            r *=d;
            System.out.printf("day:%d, number:%f, %s\n",j, r, r>6000000000d?"boom":"");
        }
    }
}

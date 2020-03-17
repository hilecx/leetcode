import java.util.HashMap;
import java.util.Map;

public class A0437PathSumIII2 {

//    Queue<TreeNode> queue = new LinkedList<>();
//    Set<Long> map = new HashSet<>();

    Long c = 0L;

    class ExtTreeNode {
        public TreeNode node;
        Map<Long, Integer> map = new HashMap();

    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root != null && root.val == sum) {
            c++;
        }
        ExtTreeNode extTreeNode = new ExtTreeNode();
        extTreeNode.node = root;
        if (root.val == 0) {
            extTreeNode.map.put(root.val + 0L, 2);
        } else {
            extTreeNode.map.put(root.val + 0L, 1);
            extTreeNode.map.put(0L, 1);
        }
        f(extTreeNode, sum);
        return c.intValue();

    }

    public void f(ExtTreeNode node, long sum) {
        if (node.node == null) {
            return;
        }

        if (node.node.left != null && node.map.keySet().contains(sum - node.node.left.val)) {
            System.out.println("node left" + node.node.left.val + "==" + node.map.get(sum - node.node.left.val));
            c += node.map.get(sum - node.node.left.val);
        }
        if (node.node.right != null && node.map.keySet().contains(sum - node.node.right.val)) {
            System.out.println("node right" + node.node.right.val + "==" + node.map.get(sum - node.node.right.val));
            c += node.map.get(sum - node.node.right.val);
        }
        //构造子节点
        if (node.node.left != null) {
            ExtTreeNode lnode = new ExtTreeNode();
            lnode.node = node.node.left;
            for (Long l : node.map.keySet()) {
                lnode.map.put(l + lnode.node.val, node.map.get(l));
                System.out.printf("l:%d left map key %d   value %d:", l, l + lnode.node.val, lnode.map.get(l + lnode.node.val));
            }
            System.out.println();
            lnode.map.put(0L, lnode.map.get(0L) == null ? 1 : lnode.map.get(0L) + 1);
            f(lnode, sum);
        }

        if (node.node.right != null) {
            ExtTreeNode rnode = new ExtTreeNode();
            rnode.node = node.node.right;
            for (Long l : node.map.keySet()) {
                rnode.map.put(l + rnode.node.val, node.map.get(l));
                System.out.printf("l:%d right map key %d   value %d:", l, l + rnode.node.val, rnode.map.get(l + rnode.node.val));

            }
            System.out.println();
            rnode.map.put(0L, rnode.map.get(0L) == null ? 1 : rnode.map.get(0L) + 1);
            f(rnode, sum);
        }
    }

    public static void main(String[] args) {
        TreeNode root;
        int a;


//        [3,9,20,null,null,15,7]  2
        root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(-1);
        a = new A0437PathSumIII2().pathSum(root, 0);
        System.out.println("================" + a);

//        [3,9,20,null,null,15,7]  2
        root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(-1);
        a = new A0437PathSumIII2().pathSum(root, 0);
        System.out.println("================" + a);


//        [3,9,20,null,null,15,7]  2
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        a = new A0437PathSumIII2().pathSum(root, 12);
        System.out.println("================" + a);


//  [1,9]  1
        root = new TreeNode(1);
        root.left = new TreeNode(9);
        a = new A0437PathSumIII2().pathSum(root, 10);
        System.out.println("================" + a);
// [1] 1
        root = new TreeNode(1);
        a = new A0437PathSumIII2().pathSum(root, 1);
        System.out.println("================" + a);

//[5,4,8,11,null,13,4,7,2,null,null,5,1] 3
        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        a = new A0437PathSumIII2().pathSum(root, 22);
        System.out.println("================" + a);


//  [1,0,1]  3
        root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        a = new A0437PathSumIII2().pathSum(root, 1);
        System.out.println("================" + a);
//  [0,1,1]  4
        root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        a = new A0437PathSumIII2().pathSum(root, 1);
        System.out.println("================" + a);
    }
}
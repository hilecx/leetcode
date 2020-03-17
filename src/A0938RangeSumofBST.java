public class A0938RangeSumofBST {

//    这题其实是要找tree中值>=L && <=R 的node的sum
    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }

    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R)
                ans += node.val;
            if (L < node.val)
                dfs(node.left, L, R);
            if (node.val < R)
                dfs(node.right, L, R);
        }
    }


        //===================start 题目理解错误，写错了答案。这题不带图根本无法理解
    int sum = 0;

    public int rangeSumBST2(TreeNode root, int L, int R) {
        findroot(root, L, R);
        return sum;
    }

    private void findroot(TreeNode node, int L, int R) {
        if (node.val >= L && node.val <= R) {
            sum = node.val;
            fnodeL(node.left, L);
            fnodeR(node.right, R);
        } else if (node.val < L) {
            findroot(node.right, L, R);
        } else if (node.val > R) {
            findroot(node.left, L, R);
        }

    }

    private void fnodeL(TreeNode node, int L) {
        if (node == null) {
            return;
        }
        if (node.val < L) {
            fnodeL(node.right, L);
        } else if (node.val > L) {
            sum += node.val;
            fnodeL(node.left, L);
        }else {
            sum += node.val;
            return;
        }

    }

    private void fnodeR(TreeNode node, int R) {
        if (node == null) {
            return;
        }
        if (node.val < R) {
            sum += node.val;
            fnodeR(node.left, R);
        } else if (node.val > R) {
            fnodeR(node.right, R);
        }else {
            sum += node.val;
            return;
        }
    }
    //===================end 题目理解错误，写错了答案。这题不带图根本无法理解



}

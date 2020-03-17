import java.util.HashMap;
import java.util.Map;

public class A0437PathSumIII4 {
//    最优解法，但是很难理解
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return pathSumFrom(root, 0, sum, map);
    }

    private int pathSumFrom(TreeNode root, int sum, int target, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        int res = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        res += pathSumFrom(root.left, sum, target, map)
                + pathSumFrom(root.right, sum, target, map);

        map.put(sum, map.get(sum) - 1);//移除以防止重复使用
        return res;
    }

}
import java.util.ArrayList;
import java.util.List;

//这个写法不是最快，一般广度优先用deque，参考方法2 https://leetcode.com/problems/average-of-levels-in-binary-tree/solution/
public class A0637AverageLevelsinBinaryTree {
    List<List<Integer>> lists = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> r = new ArrayList<>();
        f(root,0);
        long sum=0;
        List<Integer> list;
        for (int i = 0; i < lists.size(); i++) {
            sum=0;
            list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                sum+=list.get(j);
            }
            r.add((double)sum/list.size());
        }
        return r;
    }

    public void f(TreeNode node, int level){
        if(node==null){
            return;
        }
        List<Integer> list;
        if(level+1>lists.size()){
            list = new ArrayList<>();
            lists.add(list);
        }else {
            list = lists.get(level);
        }
        list.add(node.val);
        f(node.left,level+1);
        f(node.right,level+1);
    }
}

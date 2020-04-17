import java.util.ArrayList;
import java.util.List;

public class A0111MinimumDepthBinaryTree2 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int min=1;
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        list1.add(root);
        while (list1.size()!=0){
            for (int i = 0; i < list1.size(); i++) {
                if(list1.get(i).left==null && list1.get(i).right==null){
                    return min;
                }else {
                    if(list1.get(i).left!=null) {
                        list2.add(list1.get(i).left);
                    }
                    if(list1.get(i).right!=null) {
                        list2.add(list1.get(i).right);
                    }
                }
            }
            min++;
            list1=list2;
            list2=new ArrayList<>();
        }
        return min;
    }
}

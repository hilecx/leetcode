import java.util.ArrayList;
import java.util.List;

public class A0559MaximumDepthofNaryTree {
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        List<Node> nodes1 = new ArrayList<>();
        List<Node> nodes2 = new ArrayList<>();
        nodes1.add(root);
        int d=1;
        while (true){
            for (int i = 0; i < nodes1.size(); i++) {
                nodes2.addAll(nodes1.get(i).children);

            }
            if(nodes2.size()==0){
                break;
            }
            nodes1=nodes2;
            nodes2= new ArrayList<>();
            d++;
        }
        return d;
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}

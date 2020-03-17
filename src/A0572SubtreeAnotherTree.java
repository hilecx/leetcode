import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class A0572SubtreeAnotherTree {


    class Pair{
        TreeNode s;
        TreeNode t;

        public Pair(TreeNode s, TreeNode t) {
            this.s = s;
            this.t = t;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return s.equals(pair.s) &&
                    t.equals(pair.t);
        }

        @Override
        public int hashCode() {
            return Objects.hash(s, t);
        }
    }

    Map<Pair,Boolean> map = new HashMap<>();


    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }


    private boolean isEqual(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else if (s.val == t.val) {
            Boolean r = map.get(new Pair(s,t));
            if(r!=null){
                return r;
            }else {
                Boolean result = isEqual(s.left, t.left) && isEqual(s.right, t.right);
                map.put(new Pair(s,t),result);
                return result;
            }
        } else {
            return false;
        }

    }

    private boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (isEqual(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }
}

import java.util.ArrayList;
import java.util.List;

public class A0118PascalTriangle {

//			[[1]
//                    ,[1,1]
//                    ,[1,2,1]
//                    ,[1,3,3,1]
//                    ,[1,4,6,4,1]
//                    ,[1,5,10,10,5,1]
//                    ,[1,6,15,20,15,6,1]
//                    ,[1,7,21,35,35,21,7,1]
//                    ,[1,8,28,56,70,56,28,8,1]
//                    ,[1,9,36,84,126,126,84,36,9,1]]
    static List<List<Integer>> a = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        a = new ArrayList<>();
        if (numRows == 0) {
            return a;
        }
        int i = 2;
        List<Integer> b1 = new ArrayList<>();
        b1.add(1);
        a.add(b1);
        f(i, numRows, b1);
        return a;
    }

    public void f(int i, int numRows, List<Integer> b) {
        if (i <= numRows) {
            List<Integer> bnext = new ArrayList<>();
            bnext.add(1);
            for (int j = 0; j < b.size() - 1; j++) {
                bnext.add(b.get(j) + b.get(j + 1));
            }
            bnext.add(1);
            a.add(bnext);
            f(i + 1, numRows, bnext);
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        new A0118PascalTriangle().generate(0);
    }
}

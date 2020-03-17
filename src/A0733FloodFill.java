import java.util.*;

public class A0733FloodFill {
//一开始用了 catch indexOutofBound, 效率奇低
//    class Pairs {
//        public int x;
//        public int y;
//
//        public Pairs(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Pairs pairs = (Pairs) o;
//            return x == pairs.x &&
//                    y == pairs.y;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(x, y);
//        }
//    }

//    Set<Pairs> pairsSet = new HashSet<>();


    int[][] n = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int originColor = 0;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        originColor = image[sr][sc];
        if(newColor!=originColor) {
            findPairs(image, sr, sc, newColor);
        }
        return image;
    }

    private void findPairs(int[][] image, int sr, int sc, int newColor) {
        image[sr][sc] = newColor;
        for (int i = 0; i < 4; i++) {
            int nColor = -1;
            int newr =  sr + n[i][0];
            int newc =  sc + n[i][1];
            if(newr>=0 && newr<image.length && newc>=0 && newc<image[0].length) {
                nColor = image[newr][newc];
                if (nColor == originColor) {
                    findPairs(image, newr, newc, newColor);
                }
            }

        }
    }
}

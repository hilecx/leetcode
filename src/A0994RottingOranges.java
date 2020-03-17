import java.util.*;

public class A0994RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        Deque<RotNode> rotNodeDeque = new ArrayDeque<RotNode>();
        int[] xoffset = new int[]{0, 0, 1, -1};
        int[] yoffset = new int[]{1, -1, 0, 0};
        int xlength = grid.length;
        int ylength = grid[0].length;
        int maxLayer = 0;
        int count1 = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rotNodeDeque.add(new RotNode(i, j, 0));
                }else if (grid[i][j] == 1) {
                    count1++;
                }
            }
        }

        while (rotNodeDeque.peekFirst() != null) {
            RotNode rotNode = rotNodeDeque.pollFirst();
            for (int i = 0; i < 4; i++) {
                int xchange = rotNode.x + xoffset[i];
                int ychange = rotNode.y + yoffset[i];
                if (xchange >= 0 && xchange < xlength && ychange >= 0 && ychange < ylength && grid[xchange][ychange] == 1) {
                    //change 1 to 2.
                    // add new 2 to deque
                    //count is changed by layer
                    grid[xchange][ychange] = 2;
                    rotNodeDeque.addLast(new RotNode(xchange,ychange,rotNode.layer+1));
                    maxLayer = rotNode.layer+1;
                    count1--;
                }
            }
        }

//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if(grid[i][j]==1){
//                    return -1;
//                }
//            }
//        }
        return count1==0?maxLayer:-1;

    }

    class RotNode {
        int x;
        int y;
        int layer;

        public RotNode(int x, int y, int layer) {
            this.x = x;
            this.y = y;
            this.layer = layer;
        }
    }

    class FreshNode {
        int x;
        int y;

        public FreshNode(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FreshNode freshNode = (FreshNode) o;
            return x == freshNode.x &&
                    y == freshNode.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

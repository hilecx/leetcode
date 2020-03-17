public class A0661ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int nx = M.length;
        int ny = M[0].length;
        int[][] res = new int[nx][ny];
        for (int i = 0; i < nx; i++) {
            for (int j = 0; j < ny; j++) {
                res[i][j] = smooth(M, i, j);
            }
        }
        return res;
    }

    private int smooth(int[][] M, int x, int y) {
        int nx = M.length;
        int ny = M[0].length;
        int sum = 0;
        int count = 0;

        for (int i = -1; i <= 1; i++) {//这个迭代周围8个方法比预设一个数组快
            for (int j = -1; j <= 1; j++) {
                if (x + i < 0 || x + i >= nx || y + j < 0 || y + j >= ny) {
                    continue;
                }
                count++;
                sum += M[x + i][y + j];
            }
        }

        return sum / count;
    }
}

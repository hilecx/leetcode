public class A0766ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        boolean r = true;
        for (int i = 0; i < height; i++) {
            r = helper(matrix, i, 0);
            if (!r) {
                return r;
            }
        }

        for (int i = 0; i < width; i++) {
            r = helper(matrix, 0, i);
            if (!r) {
                return r;
            }
        }
        return r;
    }

    private boolean helper(int[][] matrix, int h, int w) {
        int o = matrix[h][w];
        boolean r = true;
        while (true) {
            if (++h == matrix.length || ++w == matrix[0].length) {
                break;
            } else if (h < matrix.length && w < matrix[0].length && matrix[h][w] == o) {
                continue;
            } else {
                r = false;
                break;
            }
        }
        return r;
    }
}

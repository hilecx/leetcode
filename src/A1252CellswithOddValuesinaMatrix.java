public class A1252CellswithOddValuesinaMatrix {
    public int oddCells(int n, int m, int[][] indices) {
        boolean[] r = new boolean[n];
        boolean[] c = new boolean[m];
        for (int i = 0; i < indices.length; i++) {
            r[indices[i][0]] = !r[indices[i][0]];
            c[indices[i][1]] = !r[indices[i][1]];
        }
        int cTure = 0;
        int rTure = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i]) {
                cTure++;
            }
        }
        for (int i = 0; i < r.length; i++) {
            if (r[i]) {
                rTure++;
            }
        }
        return cTure * n + rTure * m - (cTure * rTure) * 2;
    }
}

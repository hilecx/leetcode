public class A0463IslandPerimeter {
    //很简单，暴力解法。抄的答案
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        if(m==0) return 0;
        int n = grid[0].length;
        int per = 0;
        for(int i=0; i<m;i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==1) {
                    if(i==0||grid[i-1][j]==0) per++;
                    if(i==m-1||grid[i+1][j]==0) per++;
                    if(j==0||grid[i][j-1]==0) per++;
                    if(j==n-1||grid[i][j+1]==0) per++;
                }
            }
        }
        return per;
    }
}

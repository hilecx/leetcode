import com.sun.javafx.robot.FXRobotImage;

public class A0200NumberofIslands {
    public int numIslands(char[][] grid) {
        int islandCount=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    f(grid,i,j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void f(char[][] grid,int i,int j){
        boolean isChanged=true;
        while (isChanged){
            isChanged=false;
            int ipre = i-1;
            int ipost = i+1;
            int jpre = j-1;
            int jpost = j+1;
            if(ipre>=0 && grid[ipre][j]=='1'){
                grid[ipre][j]=0;
                isChanged=true;
                f(grid,ipre,j);
            }
            if(ipost<=grid.length-1 && grid[ipost][j]=='1'){
                grid[ipost][j]=0;
                isChanged=true;
                f(grid,ipost,j);
            }
            if(jpre>=0 && grid[i][jpre]=='1'){
                grid[i][jpre]=0;
                isChanged=true;
                f(grid,i,jpre);
            }
            if(jpost<=grid[0].length-1 && grid[i][jpost]=='1'){
                grid[i][jpost]=0;
                isChanged=true;
                f(grid,i,jpost);
            }
        }
        return;
    }

    public static void main(String[] args) {
        System.out.println(new A0200NumberofIslands().numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
    }
}

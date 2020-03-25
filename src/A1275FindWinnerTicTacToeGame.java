public class A1275FindWinnerTicTacToeGame {
    int[][][] dict = new int[9][4][2];

    public String tictactoe(int[][] moves) {
        buildDict();
        Integer[][] board = new Integer[3][3];
        for (int i = 0; i < moves.length; i++) {
            int r=moves[i][0];
            int c=moves[i][1];
            board[r][c]=i%2;
            if(i>=4){
                if(check(board,r,c)){
                    return board[r][c]==0?"A":"B";
                }
            }
        }

        return moves.length==9?"Draw":"Pending";
    }

    private boolean check(Integer[][] board, int r, int c){
        int index = (r*3)+c;
//        System.out.printf("r:%d, c:%d, index:%d\n",r,c,index);
        for (int i = 0; i < dict[index].length; i++) {
                int g0 = dict[index][i][0];
                int g1 = dict[index][i][1];
                int g2 = dict[index][i][2];
//            System.out.printf("g0:%d, g1:%d, g2:%d\n",g0,g1,g2);
//            System.out.printf("getX g0:%d, g1:%d, g2:%d\n",getX(g0),getX(g1),getX(g2));
//            System.out.printf("getY g0:%d, g1:%d, g2:%d\n",getY(g0),getY(g1),getY(g2));
                if(board[getX(g0)][getY(g0)]==board[getX(g1)][getY(g1)] && board[getX(g0)][getY(g0)]==board[getX(g2)][getY(g2)]){
                    return true;
                }
        }
        return false;
    }



    private int getX(int n){
        return n/3;
    }
    private int getY(int n){
        return n%3;
    }

    private void buildDict() {
        int[] r1 = new int[]{0, 1, 2};
        int[] r2 = new int[]{3, 4, 5};
        int[] r3 = new int[]{6, 7, 8};
        int[] c1 = new int[]{0, 3, 6};
        int[] c2 = new int[]{1, 4, 7};
        int[] c3 = new int[]{2, 5, 8};
        int[] d1 = new int[]{0, 4, 8};
        int[] d2 = new int[]{2, 4, 6};

        dict[0] = new int[][]{r1, c1, d1};
        dict[1] = new int[][]{r1, c2};
        dict[2] = new int[][]{r1, c3, d2};
        dict[3] = new int[][]{r2, c1};
        dict[4] = new int[][]{r2, c2, d1, d2};
        dict[5] = new int[][]{r2, c3};
        dict[6] = new int[][]{r3, c1, d2};
        dict[7] = new int[][]{r3, c2};
        dict[8] = new int[][]{r3, c3, d1};
    }

    public static void main(String[] args) {

    }
}

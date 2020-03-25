public class A1275FindWinnerTicTacToeGameV2 {
    int[][][][][] dict = new int[3][3][4][3][2];

    public String tictactoe(int[][] moves) {
        buildDict();
        Integer[][] board = new Integer[3][3];
        for (int i = 0; i < moves.length; i++) {
            int r = moves[i][0];
            int c = moves[i][1];
            board[r][c] = i % 2;
            if (i >= 4) {
                if (check(board, r, c)) {
                    return board[r][c] == 0 ? "A" : "B";
                }
            }
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }

    private boolean check(Integer[][] board, int r, int c) {
        for (int i = 0; i < dict[r][c].length; i++) {
            int g0x = dict[r][c][i][0][0];
            int g0y = dict[r][c][i][0][1];
            int g1x = dict[r][c][i][1][0];
            int g1y = dict[r][c][i][1][1];
            int g2x = dict[r][c][i][2][0];
            int g2y = dict[r][c][i][2][1];
            if (board[g0x][g0y] == board[g0x][g0y] && board[g1x][g1y] == board[g2x][g2y]) {
                return true;
            }
        }
        return false;
    }


    private void buildDict() {
        int[][] r1 = new int[][]{{0,0}, {0,1}, {0,2}};
        int[][] r2 = new int[][]{{1,0}, {1,1}, {1,2}};
        int[][] r3 = new int[][]{{2,0}, {2,1}, {2,2}};
        int[][] c1 = new int[][]{{0,0}, {1,0}, {2,0}};
        int[][] c2 = new int[][]{{0,1}, {1,1}, {2,1}};
        int[][] c3 = new int[][]{{0,2}, {1,2}, {2,2}};
        int[][] d1 = new int[][]{{0,0}, {1,1}, {2,2}};
        int[][] d2 = new int[][]{{0,2}, {1,1}, {2,0}};

        dict[0][0] = new int[][][]{r1, c1, d1};
        dict[0][1] = new int[][][]{r1, c2};
        dict[0][2] = new int[][][]{r1, c3, d2};
        dict[1][0] = new int[][][]{r2, c1};
        dict[1][1] = new int[][][]{r2, c2, d1, d2};
        dict[1][2] = new int[][][]{r2, c3};
        dict[2][0] = new int[][][]{r3, c1, d2};
        dict[2][1] = new int[][][]{r3, c2};
        dict[2][2] = new int[][][]{r3, c3, d1};
    }

    public static void main(String[] args) {

    }
}

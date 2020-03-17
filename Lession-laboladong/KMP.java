import java.util.Arrays;

public class KMP {
    private int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        // dp[状态][字符] = 下个状态
        dp = new int[M][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // 影子状态 X 初始为 0
        int X = 0;
        // 构建状态转移图（稍改的更紧凑了）
        /*
        * 可以理解一层一层的加状态
        * search是在txt中匹配pat，构造是在pat中匹配pat[1:]，状态X总是落后状态j一个状态，与j具有最长的相同前缀
        * */
        for (int j = 1; j < M; j++) {
            for (int c = 97; c <=99; c++) {
                dp[j][c] = dp[X][c];
                System.out.printf("1--- j:%d c:%d X:%d c:%d dp[j][c]:%d dp[X][c]:%d \n",j,c,X,c,dp[j][c] , dp[X][c]);
            }
            dp[j][pat.charAt(j)] = j + 1;
            System.out.printf("2--- j:%d j+1:%d pat.charAt(j):%s dp[j][pat.charAt(j)]:%d \n",j,j+1,pat.charAt(j),dp[j][pat.charAt(j)]);
            // 更新影子状态
            X = dp[X][pat.charAt(j)];
            System.out.printf("3--- j:%d pat.charAt(j):%s X:%d \n",j,pat.charAt(j),X);
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        // pat 的初始态为 0
        int j = 0;
        for (int i = 0; i < N; i++) {
            // 计算 pat 的下一个状态
            j = dp[j][txt.charAt(i)];
            // 到达终止态，返回结果
            if (j == M) return i - M + 1;
        }
        // 没到达终止态，匹配失败
        return -1;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP("ababc");
        for (int i = 0; i < kmp.dp.length; i++) {
            System.out.println(i + " " + Arrays.toString(kmp.dp[i]));

        }
        int a = kmp.search("aabbaabbababc");
        System.out.println(a);
    }
}
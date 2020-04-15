public class A1175PrimeArrangements {
    public int numPrimeArrangements(int n) {
        if (n == 1) {
            return 0;
        }
        int[] dic = new int[101];
        dic[2] = 1;
        dic[3] = 2;
        dic[4] = 2;
        dic[5] = 3;
        dic[6] = 3;
        dic[7] = 4;
        dic[8] = 4;
        dic[9] = 4;
        dic[10] = 4;
        dic[11] = 5;
        dic[12] = 5;
        dic[13] = 6;
        dic[14] = 6;
        dic[15] = 6;
        dic[16] = 6;
        dic[17] = 7;
        dic[18] = 7;
        dic[19] = 8;
        dic[20] = 8;
        dic[21] = 8;
        dic[22] = 8;
        dic[23] = 9;
        dic[24] = 9;
        dic[25] = 9;
        dic[26] = 9;
        dic[27] = 9;
        dic[28] = 9;
        dic[29] = 10;
        dic[30] = 10;
        dic[31] = 11;
        dic[32] = 11;
        dic[33] = 11;
        dic[34] = 11;
        dic[35] = 11;
        dic[36] = 11;
        dic[37] = 12;
        dic[38] = 12;
        dic[39] = 12;
        dic[40] = 12;
        dic[41] = 13;
        dic[42] = 13;
        dic[43] = 14;
        dic[44] = 14;
        dic[45] = 14;
        dic[46] = 14;
        dic[47] = 15;
        dic[48] = 15;
        dic[49] = 15;
        dic[50] = 15;
        dic[51] = 15;
        dic[52] = 15;
        dic[53] = 16;
        dic[54] = 16;
        dic[55] = 16;
        dic[56] = 16;
        dic[57] = 16;
        dic[58] = 16;
        dic[59] = 17;
        dic[60] = 17;
        dic[61] = 18;
        dic[62] = 18;
        dic[63] = 18;
        dic[64] = 18;
        dic[65] = 18;
        dic[66] = 18;
        dic[67] = 19;
        dic[68] = 19;
        dic[69] = 19;
        dic[70] = 19;
        dic[71] = 20;
        dic[72] = 20;
        dic[73] = 21;
        dic[74] = 21;
        dic[75] = 21;
        dic[76] = 21;
        dic[77] = 21;
        dic[78] = 21;
        dic[79] = 22;
        dic[80] = 22;
        dic[81] = 22;
        dic[82] = 22;
        dic[83] = 23;
        dic[84] = 23;
        dic[85] = 23;
        dic[86] = 23;
        dic[87] = 23;
        dic[88] = 23;
        dic[89] = 24;
        dic[90] = 24;
        dic[91] = 24;
        dic[92] = 24;
        dic[93] = 24;
        dic[94] = 24;
        dic[95] = 24;
        dic[96] = 24;
        dic[97] = 25;
        dic[98] = 25;
        dic[99] = 25;
        dic[100] = 25;

        int m = 1000000007;
        int x = dic[n];
        int y = n - x;
        int[] dp = new int[101];
        long r = 1;
        for (int i = 2; i <= y || i<=x; i++) {
            r = (r%m) * i;
            if(i<=x&&i<=y){
                r = (r%m) * i;
            }

//            dp[i]=r;
            System.out.printf("i{%d},r{%d}\n", i, r);
        }
//
//        for (int i = 2; i <= x; i++) {
//            r = (r%m) * i;
//            System.out.printf("i{%d},r{%d}\n", i, r);
//        }

        return (int)(r%m);
    }

    public static void main(String[] args) {
        System.out.println(new A1175PrimeArrangements().numPrimeArrangements(5));
        System.out.println(new A1175PrimeArrangements().numPrimeArrangements(25));
        System.out.println(new A1175PrimeArrangements().numPrimeArrangements(100));
    }
}

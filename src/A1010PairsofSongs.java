public class A1010PairsofSongs {
    public int numPairsDivisibleBy60(int[] time) {
        int[] map = new int[60];
        for (int i = 0; i < time.length; i++) {
            map[time[i] % 60]++;
        }
        int count=f(map[30]-1);
        count += f(map[0]-1);
        for (int i = 1; i < 30; i++) {
            count+=map[i]*map[60-i];
        }
        return count;
    }

    private int f(int n){
        int r = 0;
        for (int i = 1; i <= n; i++) {
            r+=i;
        }
        return r;
    }
}

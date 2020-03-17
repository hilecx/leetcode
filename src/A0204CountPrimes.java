import java.util.Arrays;

public class A0204CountPrimes {

//leetcode解法
    class Solution3 {
        public int countPrimes(int n) {

            if(n < 3)
                return 0;
            boolean s[] = new boolean[n];
            int c = n/2;
            for(int i = 3; i *i < n; i+=2) {
                if(s[i])
                    continue;
                for(int j = i*i ; j < n ; j+=2*i) {
                    if(!s[j]){
                        c--;
                        s[j]=true;
                    }
                }
            }
            return c;
        }
    }
    //自己优化的
    class Solution2 {
        public int countPrimes(int n) {
            if (n <= 1) {
                return 0;
            }
            int x = (int) Math.sqrt(n) + 1;
            boolean[] notPrimes = new boolean[n];
            for (int i = 4; i < notPrimes.length; i=i+2) {
                notPrimes[i]=true;
            }

            for (int i = 3; i < x; i=i+2) {
                if (notPrimes[i]) {
                    continue;
                }
                for (int j = i; j * i < notPrimes.length; j++) {
                    int a = j * i;
                    if (!notPrimes[a]) {
                        notPrimes[a] = true;
                    }
                }
            }
            int count = 0;
            for (int i = 2; i < notPrimes.length; i++) {
                if (!notPrimes[i]) {
                    count++;
                }
            }
            return count;
        }
    }

    //first version
    class Solution {
        public int countPrimes(int n) {
            if (n <= 1) {
                return 0;
            }
//            int x = (n + 1) / 2;
            int x = (int) Math.sqrt(n) + 1;
            int[] primes = new int[n];
            for (int i = 2; i < x; i++) {
                if (primes[i] > 0) {
                    continue;
                }
                for (int j = i; j * i <= primes.length; j++) {
                    int a = j * i;
                    if (a > 0 && a < primes.length && primes[a] == 0) {
                        primes[a]++;
                    }
                }
            }
//            return (int) Arrays.stream(primes).parallel().filter(item -> item == 0).count() - 2;

            int count = 0;
            for (int i = 2; i < primes.length; i++) {
                if (primes[i] == 0) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
//        System.out.println((int)Math.sqrt(35));
        System.out.println(new A0204CountPrimes().new Solution2().countPrimes(400));
    }
}

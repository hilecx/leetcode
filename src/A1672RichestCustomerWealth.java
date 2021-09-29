import java.util.Arrays;

public class A1672RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        int r = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                sum+=accounts[i][j];
            }
            r = Math.max(r,sum);
            sum=0;
        }
        return r;
    }

    public int maximumWealth2(int[][] accounts) {
        return Arrays.stream(accounts).parallel().mapToInt(a -> (
            Arrays.stream(a).parallel().sum()
            )).max().getAsInt();

    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        System.out.println(Arrays.stream(a).sum());
        System.out.println(Arrays.stream(a).mapToLong(b->(b*3)).max().getAsLong());
    }
}

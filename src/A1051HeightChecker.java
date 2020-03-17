import java.util.Arrays;

public class A1051HeightChecker {
    public int heightChecker(int[] heights) {
        int[] copy = new int[heights.length];
        System.arraycopy(heights,0,copy,0,heights.length);
        Arrays.sort(copy);
        int c = 0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i]!=copy[i]){
                c++;
            }
        }
        return c;
    }
}

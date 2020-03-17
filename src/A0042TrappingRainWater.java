import java.util.concurrent.ConcurrentSkipListMap;

public class A0042TrappingRainWater {

    //官方答案，天才
    public int trap2(int[] height) {
        if(height.length==0) return 0;
        int[] leftH = new int[height.length];
        int[] rightH = new int[height.length];
        leftH[0] = height[0];
        rightH[height.length-1] = height[height.length-1];
        for(int i=1;i<height.length;i++){
            leftH[i] = Math.max(height[i], leftH[i-1]);
        }
        for(int i=height.length-2;i>=0;i--){
            rightH[i] = Math.max(height[i], rightH[i+1]);
        }
        int sum = 0;
        for(int i=0;i<height.length;i++){
            sum+=Math.min(leftH[i],rightH[i])-height[i];
        }
        return sum;
    }
//    自己写的，增加了dp
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int[] skipDp = new int[height.length];
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int nextindex = i + 1;
            int preindex = i - 1;
            if (nextindex < height.length && height[i] < height[nextindex]) {
                int bottom = height[i];
                for (int k = preindex; k >= 0; k--) {
                    if(skipDp[k]!=0){
                        k=skipDp[k];
                    }
                    if (height[k] > bottom) {
                        int minLR = Math.min(height[nextindex], height[k]);
                        sum += (i - k) * (minLR - bottom);
                        for (int j = k + 1; j <= i; j++) {
                            height[j] = minLR;
                        }
                        bottom = minLR;
                        skipDp[i]=k+1;
                    }

                    if (height[k] >= height[nextindex]) {
                        break;
                    }

                }

            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new A0042TrappingRainWater().trap(new int[]{100, 0, 1, 100})); //
        System.out.println(new A0042TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new A0042TrappingRainWater().trap(new int[]{1, 2, 7, 4, 1, 2})); //1
        System.out.println(new A0042TrappingRainWater().trap(new int[]{1, 2, 7, 4, 1, 1})); //0
        System.out.println(new A0042TrappingRainWater().trap(new int[]{1, 2, 7, 4, 1, 9})); //9
        System.out.println(new A0042TrappingRainWater().trap(new int[]{1, 1, 1, 1, 1})); //
        System.out.println(new A0042TrappingRainWater().trap(new int[]{456, 4, 64, 56, 465})); //
    }
}

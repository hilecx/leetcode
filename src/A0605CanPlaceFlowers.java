public class A0605CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int zeroCount=1;
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i]==0){
                zeroCount++;
            }else {
                n-=(zeroCount-1)/2;
                zeroCount=0;
            }
            if(n<=0){
                break;
            }
        }
        n-=(zeroCount)/2;
        return n<=0;
    }
}

import sun.font.FontRunIterator;

import java.util.HashMap;
import java.util.Map;

public class A0914XKindDeckofCards {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) {
            return false;
        }
        int[] map = new int[10001];
        for (int i = 0; i < deck.length; i++) {
            map[deck[i]]++;
        }
        if (map.length == 1) {
            return true;
        }
        
        int mcd = 0;
        for (int i = 0; i < map.length; i++) {
            if(map[i]==0){
                continue;
            }
            if(mcd==0){
                mcd=map[i];
            }else {
                mcd=GCD(mcd,map[i]);
            }
        }

        return mcd>=2;
    }
    public int GCD(int a, int b) {
        return b > 0 ? GCD(b, a % b) : a;
    }
    public static int maxCommonDivisor(int m, int n) {
        if (m < n) {     // 保证被除数大于除数
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {  // 在余数不能为0时,进行循环
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;    // 返回最大公约数
    }

    public static void main(String[] args) {
        System.out.println(new A0914XKindDeckofCards().hasGroupsSizeX(new int[]{1,1,1,1,2,2,2,2,2,2}));
        System.out.println(new A0914XKindDeckofCards().hasGroupsSizeX(new int[]{1,1,1,1,2,2,2,2}));
        System.out.println(new A0914XKindDeckofCards().hasGroupsSizeX(new int[]{1,1,1,1,2,2,2}));
    }
}

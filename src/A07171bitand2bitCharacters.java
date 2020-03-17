import java.util.EmptyStackException;

public class A07171bitand2bitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
//        if (bits.length <= 2) {
//            return true;
//        }
        int i = 0;
        for (; i < bits.length-1; i++) {
            if(bits[i]==1){
                i++;
            }else {
                continue;
            }
        }
        return i<bits.length;
//        return f(bits, bits.length - 2);
    }



    private boolean f(int[] bits, int index) {
        if (index < 0) {
            return false;
        }
        if (index == 0 && bits[0] == 0) {
            return true;
        } else if (index == 1 && (bits[1] == 0 && bits[0] == 1) || (bits[1] == 0 && bits[0] == 0) || (bits[1] == 1 && bits[0] == 1)) {
            return true;
        }
        if (bits[index] == 0 && bits[index - 1] == 1) {
            f(bits, index - 2);
        }else if(bits[index] == 0 && bits[index - 1] == 0) {
            f(bits, index - 1);
        } else if (bits[index] == 1 && bits[index - 1] == 1) {
            f(bits, index - 2);
        }else if(bits[index] == 1 && bits[index - 1] == 0) {
            f(bits, index - 2);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new A07171bitand2bitCharacters().isOneBitCharacter(new int[]{1, 1, 1, 0}));
        System.out.println(new A07171bitand2bitCharacters().isOneBitCharacter(new int[]{1, 1, 0}));
        System.out.println(new A07171bitand2bitCharacters().isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(new A07171bitand2bitCharacters().isOneBitCharacter(new int[]{1, 0}));
        System.out.println(new A07171bitand2bitCharacters().isOneBitCharacter(new int[]{0}));
    }
}

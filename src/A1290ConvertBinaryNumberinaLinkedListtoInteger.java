import java.util.Stack;

public class A1290ConvertBinaryNumberinaLinkedListtoInteger {

//    抄答案的，遇到2进制一定要记得位运算啊
    public int getDecimalValue2(ListNode head) {

        int decVal = 0;
        while (head != null) {
            decVal <<= 1;
            decVal += head.val;
            head = head.next;
        }
        return decVal;
    }

    public int getDecimalValue(ListNode head) {
        int[] dict = new int[32];
        dict[0] = 1;
        dict[1] = 2;
        dict[2] = 4;
        dict[3] = 8;
        dict[4] = 16;
        dict[5] = 32;
        dict[6] = 64;
        dict[7] = 128;
        dict[8] = 256;
        dict[9] = 512;
        dict[10] = 1024;
        dict[11] = 2048;
        dict[12] = 4096;
        dict[13] = 8192;
        dict[14] = 16384;
        dict[15] = 32768;
        dict[16] = 65536;
        dict[17] = 131072;
        dict[18] = 262144;
        dict[19] = 524288;
        dict[20] = 1048576;
        dict[21] = 2097152;
        dict[22] = 4194304;
        dict[23] = 8388608;
        dict[24] = 16777216;
        dict[25] = 33554432;
        dict[26] = 67108864;
        dict[27] = 134217728;
        dict[28] = 268435456;
        dict[29] = 536870912;
        dict[30] = 1073741824;
        dict[31] = 2147483647;

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int sum = 0;
        int i = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop() * dict[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 31; i++) {
            System.out.printf("dict[%d]=%d;\n", i, (int) Math.pow(2, i));
        }
    }
}

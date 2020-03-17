import java.util.ArrayList;
import java.util.List;

public class A0401BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h=0; h<12; h++)
            for (int m=0; m<60; m++)
                //Integer.bitCount 这个方法统计int的二进制有几个1
                //用h*64统计hour中的1
                if (Integer.bitCount(h * 64 + m) == num)
                    times.add(String.format("%d:%02d", h, m));
        return times;


    }

    public List<String> readBinaryWatch2(int num) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();//这里用stringbuffer更快
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h * 64 + m) == num) {
                    sb.setLength(0);
                    sb.append(h);
                    sb.append(':');
                    if (m < 10) sb.append('0');
                    sb.append(m);
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(3));
    }

}

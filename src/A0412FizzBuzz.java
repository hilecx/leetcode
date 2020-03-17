import java.util.ArrayList;
import java.util.List;

public class A0412FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            int m3 = i % 3;
            int m5 = i % 5;
            if (m3 == 0 && m5 == 0) {
                list.add("FizzBuzz");
            } else if (m3 == 0) {
                list.add("Fizz");
            } else if (m5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}

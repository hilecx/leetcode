import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class A1185DayoftheWeek {
//    更加基础的方法是用蔡勒公式 Zeller's congruence  https://zh.wikipedia.org/wiki/%E8%94%A1%E5%8B%92%E5%85%AC%E5%BC%8F
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int d = LocalDate.of(year,month,day).getDayOfWeek().getValue();
        return days[d-1];
    }

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of (2020,3,14);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        dayOfWeek.getValue();
        System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.CHINA));
        System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.US));
        System.out.println(dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.US));
        System.out.println(dayOfWeek.getValue());
    }
}

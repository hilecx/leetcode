import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class A1360NumberofDaysBetweenTwoDates {
    public int daysBetweenDates(String date1, String date2) {
        LocalDate localDate1 = LocalDate.parse(date1,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate localDate2 = LocalDate.parse(date2,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(localDate1.getDayOfMonth());
        System.out.println(localDate2.getDayOfMonth());
        long daysDiff = ChronoUnit.DAYS.between(localDate1,localDate2);
        return Math.abs((int)daysDiff);
    }

    public static void main(String[] args) {
        System.out.println(new A1360NumberofDaysBetweenTwoDates().daysBetweenDates("2019-06-26","2019-07-29"));
    }
}

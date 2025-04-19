package planning;

import java.time.DayOfWeek;

public class Test {
    public static void main(String[] args) {
        DayOfWeek day = DayOfWeek.valueOf("Tuesday");
        System.out.println(day.name());
    }
}

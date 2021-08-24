package timeservice;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeService {
    LocalDate date= LocalDate.now();
    LocalTime timer= LocalTime.now();
    String test=date.toString()+ timer.toString();
}

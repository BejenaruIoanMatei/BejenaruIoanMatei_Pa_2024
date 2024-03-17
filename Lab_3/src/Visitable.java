import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface Visitable {
    Map<LocalDate, TimeInterval> getTimetable();
    default LocalTime getOpeningHour (LocalDate date)
    {
        TimeInterval hours = getTimetable().get(date);
        return hours.getFirst();
    }
}

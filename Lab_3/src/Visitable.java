import java.time.LocalDate;

public interface Visitable {
    Map<LocalDate, TimeInterval> getTimetable();
    default void getOpeningHour(LocalDate date)
    {

    }

}

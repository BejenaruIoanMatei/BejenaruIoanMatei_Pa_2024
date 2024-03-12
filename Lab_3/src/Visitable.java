import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface Visitable {
    Map<String, List<String>> getOpeningHours ();
}

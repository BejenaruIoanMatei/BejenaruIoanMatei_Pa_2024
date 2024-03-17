import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TravelPlan {

    private String tripName;
    public Map<Attraction, LocalDate> visitSchedule;

    public TravelPlan(String tripName) {
        this.tripName = tripName;
        this.visitSchedule = new HashMap<>();
    }

    public void addVisit(Attraction attraction, LocalDate visitDate) {
        visitSchedule.put(attraction, visitDate);
    }

    public LocalDate getVisitDate(Attraction attraction) {
        return visitSchedule.get(attraction);
    }

    public String getTripName() {
        return tripName;
    }
}
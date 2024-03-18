import java.time.*;
import java.util.Map;

class Concert extends Attraction implements Visitable, Payable {
    private Map<LocalDate, TimeInterval> openingHours;
    private float entryFee;

    public Concert(String name, Map<LocalDate, TimeInterval> openingHours, float entryFee) {
        super(name);
        this.openingHours = openingHours;
        this.entryFee = entryFee;
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return openingHours;
    }

    public void setOpeningHours(Map<LocalDate, TimeInterval> openingHours) {
        this.openingHours = openingHours;
    }

    @Override
    public float getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(float entryFee) {
        this.entryFee = entryFee;
    }
}
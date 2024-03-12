import java.util.List;
import java.util.Map;

class Concert extends Attraction implements Visitable, Payable {
    private Map<String, List<String>> openingHours;
    private float entryFee;

    public Concert(String name, Map<String, List<String>> openingHours, float entryFee) {
        super(name);
        this.openingHours = openingHours;
        this.entryFee = entryFee;
    }

    @Override
    public Map<String, List<String>> getOpeningHours() {
        return openingHours;
    }

    @Override
    public float howMuch() {
        return entryFee;
    }
}
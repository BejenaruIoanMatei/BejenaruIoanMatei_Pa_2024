import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Church extends Attraction implements Visitable {
    private Map<String, List<String>> openingHours;

    public Church(String name, Map<String, List<String>> openingHours) {
        super(name);
        this.openingHours = openingHours;
    }

    @Override
    public Map<String, List<String>> getOpeningHours() {
        return openingHours;
    }
}
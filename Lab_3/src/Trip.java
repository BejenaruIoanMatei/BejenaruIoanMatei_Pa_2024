import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Trip {
    private String cityName;
    private String periodOfTime;
    private List<Attraction> attractions;

    public Trip(String cityName, String periodOfTime, List<Attraction> attractions) {
        this.cityName = cityName;
        this.periodOfTime = periodOfTime;
        this.attractions = attractions;
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPeriodOfTime() {
        return periodOfTime;
    }

    public void setPeriodOfTime(String periodOfTime) {
        this.periodOfTime = periodOfTime;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }
    public List<Attraction> getVisitableFreeAttractions()
    {
        List<Attraction> atractiiGratis = new ArrayList<>();
        for (Attraction atractie : attractions)
        {
            //vedem daca atractia este vizitabila
            if (atractie instanceof Visitable)
            {
                //daca e vizitabila atunci vedem daca este si gratuita
                if (!(atractie instanceof Payable))
                {
                    atractiiGratis.add(atractie);
                }
            }
        }
        //atractiile a1 si a2 implementeaza interfata Visitable
        atractiiGratis.sort((a1, a2) ->
        {
            LocalDate ziuaDeAzi = LocalDate.now();
            LocalTime oraDeschidereA1 = ((Visitable) a1).getOpeningHour(ziuaDeAzi);
            LocalTime oraDeschidereA2 = ((Visitable) a2).getOpeningHour(ziuaDeAzi);
            return oraDeschidereA1.compareTo(oraDeschidereA2);
        });
        return atractiiGratis;
    }
}
import java.util.List;

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
}
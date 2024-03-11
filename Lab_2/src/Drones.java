public class Drones extends Vehicle {
    private int duration; //in minute

    public Drones(int duration) {
        this.duration = duration;
    }

    public Drones(String name, Tour tour)
    {
        super(name,tour);
    }

    public Drones(String name, Tour tour, int duration) {
        super(name, tour);
        this.duration = duration;
    }

    //Setters n getters
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

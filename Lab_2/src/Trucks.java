public class Trucks extends Vehicle {
    private int capacity;

    public Trucks(int capacity) {
        this.capacity = capacity;
    }

    public Trucks(String name, Tour tour, int capacity) {
        super(name, tour);
        this.capacity = capacity;
    }

    public Trucks(String name, Tour tour)
    {
        super(name, tour);
    }

    //Setters n getters
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


}

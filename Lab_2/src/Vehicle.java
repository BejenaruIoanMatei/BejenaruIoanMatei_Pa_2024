public abstract class Vehicle {
    protected String vehicleName;
    private Tour tour;

    //Constructor

    public Vehicle()
    {
        //vehicleName va fi null la fel si drumul
    }
    public Vehicle(String name, Tour tour)
    {
        this.vehicleName = name;
        this.tour = tour;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }


    @Override
    public String toString()
    {
        return "Vehicle : "+ vehicleName+ ',' + tour;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null || !(obj instanceof Vehicle))
        {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return vehicleName.equals(other.vehicleName);
    }
}

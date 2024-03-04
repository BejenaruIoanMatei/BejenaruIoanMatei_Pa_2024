public class Vehicle {
    private String vehicleName;
    private Depot depot;
    //Constructor
    public Vehicle(String name, Depot depot)
    {
        this.vehicleName = name;
        this.depot = depot;
    }

    //Setters
    public void setVehicleName(String name)
    {
        this.vehicleName = name;
    }
    public void setDepot(Depot depot)
    {
        this.depot = depot;
    }
    //Getters
    public String getVehicleName()
    {
        return vehicleName;
    }
    public Depot getDepot()
    {
        return depot;
    }

    @Override
    public String toString()
    {
        return "Vehicle : "+ vehicleName+ ',' + depot;
    }
}

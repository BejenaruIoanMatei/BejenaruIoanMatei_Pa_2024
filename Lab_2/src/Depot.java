import java.util.ArrayList;

public class Depot {
    private String depotName;
    //Adaugam un vector de masini, un depozit poate sa aibe mai multe masini
    private ArrayList<Vehicle> vehicles;

    //Constructor

    public Depot(String name)
    {
        this.depotName = name;
    }
    public Depot(String name, ArrayList<Vehicle> vehicles)
    {
        this.depotName = name;
        this.vehicles = vehicles;
    }

    //Setters

    public void setNameDepot(String name)
    {
        this.depotName = name;
    }

    //Punem in depozit vehiculele
    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    //Getters

    public String getNameDepot()
    {
        return this.depotName;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public String toString()
    {
        return "Depot : " + depotName;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj ==null || !(obj instanceof Depot))
        {
            return false;
        }
        Depot other = (Depot) obj;
        return depotName.equals(other.depotName);
    }

    public boolean addVehicle(Vehicle vehicle)
    {
        for(Vehicle v: vehicles )
        {
            if(v.equals(vehicle))
            {
                return false;
            }
        }
        vehicles.add(vehicle);
        return true;
    }

}




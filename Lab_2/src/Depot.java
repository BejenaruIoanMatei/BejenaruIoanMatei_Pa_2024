public class Depot {
    private String depotName;

    //Constructor
    public Depot(String name)
    {
        this.depotName = name;
    }

    //Setters

    public void setNameDepot(String name)
    {
        this.depotName = name;
    }
    //Getters
    public String getNameDepot()
    {
        return this.depotName;
    }

    @Override
    public String toString()
    {
        return "Depot : " + depotName;
    }

}

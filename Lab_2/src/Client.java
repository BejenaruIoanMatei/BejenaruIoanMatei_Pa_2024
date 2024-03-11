

public class Client {
    public enum tipClient{
        regular , premium
    }
    private String clientName;
    private String timeInterval;
    private tipClient clientType;
    private boolean hasVehicle;

    //Constructorul pentru Client
    public Client(String name, String time,tipClient type,boolean hasVehicle)
    {
        this.clientName = name;
        this.timeInterval = time;
        this.clientType = type;
        this.hasVehicle = hasVehicle;
    }


    //Setters
    public void setClientName(String name)
    {
        this.clientName = name;
    }
    public void setTimeInterval(String time)
    {
        this.timeInterval = time;
    }
    public void setClientType(tipClient type)
    {
        this.clientType = type;
    }
    public void setHasVehicle(boolean hasVehicle) {
        this.hasVehicle = hasVehicle;
    }

    //Getters

    public String getClientName()
    {
        return clientName;
    }
    public String getTimeInterval()
    {
        return timeInterval;
    }
    public tipClient getClientType()
    {
        return clientType;
    }
    public boolean isHasVehicle()
    {
        return hasVehicle;
    }


    //toString
    @Override
    public String toString()
    {
        return "Client : "+ clientName+", interval vizita "+timeInterval+
                ", tip client "+ clientType;

    }
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null || !(obj instanceof Client))
        {
            return false;
        }
        Client other = (Client) obj;
        return clientName.equals(other.clientName);
    }
}

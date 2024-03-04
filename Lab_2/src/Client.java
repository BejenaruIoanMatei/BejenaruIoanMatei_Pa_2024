

public class Client {
    public enum tipClient{
        regular , premium
    }
    private String clientName;
    private String timeInterval;
    private tipClient clientType;

    //Constructorul pentru Client
    public Client(String name, String time,tipClient type)
    {
        this.clientName = name;
        this.timeInterval = time;
        this.clientType = type;
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
    //toString
    @Override
    public String toString()
    {
        return "Client : "+ clientName+", interval vizita "+timeInterval+
                ", tip client "+ clientType;

    }

}

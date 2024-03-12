import java.util.ArrayList;
import java.util.Random;

/**
 * The type Tour.
 */
public class Tour {
    private ArrayList<Client> clients;
    //private Vehicle vehicle;
    //Constructor

    /**
     * Instantiates a new Tour.
     */
    public Tour()
    {
        this.clients = new ArrayList<>();
    }

    /**
     * Instantiates a new Tour.
     *
     * @param clients the clients
     */
    public Tour(ArrayList<Client> clients)
    {
        this.clients = clients;
    }

    //Getters n setters

    /**
     * Gets clients.
     *
     * @return the clients
     */
    public ArrayList<Client> getClients() {
        return clients;
    }

    /**
     * Sets clients.
     *
     * @param clients the clients
     */
    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    /**
     * Add client boolean.
     *
     * @param client the client
     * @return the boolean
     */
    public boolean addClient(Client client)
    {
        //Cautam clientul in lista de clienti
        //Daca il gasim atunci nu il mai adaugam
        //Daca NU il gasim il adaugam
        for(Client c: clients )
        {
            if(c.equals(client))
            {
                return false;
            }
        }
        clients.add(client);
        return true;
    }


    /**
     * Gets last client.
     *
     * @return the last client
     */
    public Client getLastClient()
    {
        if(clients.isEmpty())
        {
            return null;
        }
        else
        {
            return clients.get(clients.size()-1);
        }
    }
}


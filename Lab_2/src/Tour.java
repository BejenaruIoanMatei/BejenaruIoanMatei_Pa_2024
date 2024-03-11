import java.util.ArrayList;
import java.util.Random;

public class Tour {
    private ArrayList<Client> clients;
    //private Vehicle vehicle;
    //Constructor

    public Tour()
    {
        this.clients = new ArrayList<>();
    }
    public Tour(ArrayList<Client> clients)
    {
        this.clients = clients;
    }

    //Getters n setters

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

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


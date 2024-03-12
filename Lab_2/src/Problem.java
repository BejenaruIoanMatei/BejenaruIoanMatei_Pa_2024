
//Clasa care descrie problema cerintei
//Alocam clientilor vehicule astfel incat toti clientii sa fie vizitati
//vehicul --> 1 depozit si depozit --> 1.. vehicule

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * The type Problem.
 */
public class Problem {
    private ArrayList<Depot> depots;
    private ArrayList<Client> clients;
    private ArrayList<Vehicle> vehicles;
    /**
     * The Travel times.
     */
    int[][] travelTimes;

    /**
     * Instantiates a new Problem.
     *
     * @param vehicles the vehicles
     */
    public Problem(ArrayList<Vehicle> vehicles) {
        this.depots = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.vehicles = vehicles;
    }

    /**
     * Instantiates a new Problem.
     *
     * @param depots  the depots
     * @param clients the clients
     */
    public Problem(ArrayList<Depot> depots, ArrayList<Client> clients) {
        this.depots = depots;
        this.clients = clients;
    }

    //Setters n getters


    /**
     * Gets depots.
     *
     * @return the depots
     */
    public ArrayList<Depot> getDepots() {
        return depots;
    }

    /**
     * Sets depots.
     *
     * @param depots the depots
     */
    public void setDepots(ArrayList<Depot> depots) {
        this.depots = depots;
    }

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
     * Add depot boolean.
     *
     * @param depot the depot
     * @return the boolean
     */
    public boolean addDepot(Depot depot) {
        for (Depot d : depots) {
            if (d.equals(depot)) {
                return false;
            }
        }
        depots.add(depot);
        return true;
    }

    /**
     * Add client boolean.
     *
     * @param client the client
     * @return the boolean
     */
    public boolean addClient(Client client) {
        for (Client c : clients) {
            if (c.equals(client)) {
                return false;
            }
        }
        clients.add(client);
        return true;
    }

    /**
     * Add vehicles boolean.
     *
     * @param vehicle the vehicle
     * @return the boolean
     */
    public boolean addVehicles(Vehicle vehicle) {
        if (vehicle == null)
        {
            return false;
        }
        for (Vehicle v : vehicles) {
            if (v.equals(vehicle)) {
                return false;
            }
        }
        vehicles.add(vehicle);
        return true;
    }


    /**
     * Get vehicles vehicle [ ].
     *
     * @return the vehicle [ ]
     */
    public Vehicle[] getVehicles() {
        ArrayList<Vehicle> allVehicles = new ArrayList<>();
        for (Depot d : depots) {
            for (Vehicle v : d.getVehicles()) {
                allVehicles.add(v);
            }
        }
        return allVehicles.toArray(new Vehicle[0]);
    }

    /**
     * Solve problem.
     *
     * @param problem the problem
     */
    public void solveProblem(Problem problem)
    {
        generateTravelTimesRandomly();

        ArrayList<Client> unvisitedClients = new ArrayList<>(clients);
        ArrayList<Tour> tours = new ArrayList<>();

        for(Vehicle vehicle : vehicles)
        {
            Tour tour = new Tour();
            for(Client client : unvisitedClients)
            {
                tour.addClient(client);
                Client closestClient = getClosestUnvisitedClient(client);
                if(closestClient != null)
                {
                    tour.addClient(closestClient);
                    unvisitedClients.remove(closestClient);
                }
            }
            tours.add(tour);
        }
    }

    /**
     * Gets closest unvisited client.
     *
     * @param client the client
     * @return the closest unvisited client
     */
    public Client getClosestUnvisitedClient(Client client)
    {
        int indexClient = clients.indexOf(client);
        int minDistance = Integer.MAX_VALUE;
        int closestClientIndex = -1;

        for (int j = 0; j < travelTimes.length; j++)
        {
            if (travelTimes[indexClient][j] < minDistance && travelTimes[indexClient][j] > 0)
            {
                minDistance = travelTimes[indexClient][j];
                closestClientIndex = j;
            }
        }
        return clients.get(closestClientIndex);
    }

    private void generateTravelTimesRandomly()
    {
        int howManyLocations = clients.size() + 1;
        travelTimes = new int[howManyLocations][howManyLocations];
        Random randomValue = new Random();
        for (int i = 0; i < howManyLocations - 1; i++) {
            for (int j = i + 1; j < howManyLocations; j++) {
                travelTimes[i][j] = randomValue.nextInt(10) + 1;
                travelTimes[j][i] = travelTimes[i][j];
            }
        }
        for (int i = 0; i < howManyLocations; i++) {
            travelTimes[i][i] = 0;
        }

    }
}


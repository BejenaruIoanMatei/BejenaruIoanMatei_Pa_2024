import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {

        ArrayList<Vehicle> cars = new ArrayList<>();

        Tour tour1 = new Tour();

        Vehicle vehicle1 = new Trucks("truck1", tour1);
        Vehicle vehicle2 = new Trucks("truck2",tour1);
        Vehicle vehicle3 = new Trucks("truck3",tour1);

        Client client1 = new Client("client1", "10-12", Client.tipClient.regular,false);
        Client client2 = new Client("client2", "2-3", Client.tipClient.regular,false);
        Client client3 = new Client("client3", "3-5", Client.tipClient.premium,false);

        cars.add(vehicle1);
        cars.add(vehicle2);
        cars.add(vehicle3);

        Depot depot1 = new Depot("depot1", cars);

        System.out.println(depot1.getVehicles());

        Problem pb = new Problem(cars);

        pb.addDepot(depot1);
        pb.addClient(client1);
        pb.addClient(client2);
        pb.addClient(client3);

        pb.addVehicles(vehicle1);
        pb.addVehicles(vehicle2);
        pb.addVehicles(vehicle3);

        pb.solveProblem(pb);
    }
}

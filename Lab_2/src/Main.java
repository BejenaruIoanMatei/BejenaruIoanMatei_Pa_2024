//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        Depot depozit = new Depot("Iasi");
        Vehicle vehicul = new Vehicle("Dacia",depozit);
        Client client1 = new Client("Marian","9:30-11", Client.tipClient.premium);
        Client client2 = new Client("Ion", "7:25-9:40", Client.tipClient.regular);
        System.out.println(depozit);
        System.out.println(vehicul);
        System.out.println(client1);
        System.out.println(client2);
    }
}
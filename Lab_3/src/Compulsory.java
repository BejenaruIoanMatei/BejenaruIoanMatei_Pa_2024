import java.util.*;

public class Compulsory
{
    public static void main(String[] args)
    {
        List<String> ore1 = new ArrayList<>();
        List<String> ore2 = new ArrayList<>();
        ore1.add("10:00 - 17:00");
        ore2.add("11:00 - 16:00");

        Map<String, List<String>> churchOpeningHours = new HashMap<>();
        churchOpeningHours.put("Monday", ore1);
        churchOpeningHours.put("Tuesday", ore2);

        System.out.println("Hours on Monday "+churchOpeningHours.get("Monday"));
        System.out.println("Hours on Tuesday "+churchOpeningHours.get("Tuesday"));

        Trip trip = new Trip("CityA", "March 12-18", new ArrayList<>());
        trip.addAttraction(new Statue("Statue of liberty"));
        trip.addAttraction(new Church("Biserica Iasi", churchOpeningHours));
        trip.addAttraction(new Concert("Concert Rock", churchOpeningHours, 25));

        for (Attraction attraction: trip.getAttractions()) {
            System.out.println("Attraction " + attraction.getName());
        }
    }

}
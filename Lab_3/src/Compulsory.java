import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Compulsory
{
    public static void main(String[] args)
    {
        List<Attraction> attractions = new ArrayList<>();

        //O biserica
        Map<LocalDate, TimeInterval> churchHours = new HashMap<>();
        attractions.add(new Church("Biserica Mare", churchHours));
        churchHours.put(LocalDate.of(2024, 5, 12), new TimeInterval(LocalTime.of(8, 0), LocalTime.of(18, 0)));
        churchHours.put(LocalDate.of(2024, 5, 13), new TimeInterval(LocalTime.of(8, 0), LocalTime.of(18, 0)));

        //Un concert
        Map<LocalDate, TimeInterval> concertHours = new HashMap<>();
        attractions.add(new Concert("Concert Rock", concertHours, 25.0f));
        concertHours.put(LocalDate.of(2024, 5, 14), new TimeInterval(LocalTime.of(20, 30), LocalTime.of(22, 30)));

        //O statuie
        attractions.add(new Statue("Statuie Cool"));

        //New trip cu interval 10-15 mai
        Trip myTrip = new Trip("Bulgari", "May 10th - 15th, 2024", attractions);

        //Constructie --> Imi fac un travel plan
        //Prima zi la biserica, a doua la concert rock si in a treia ma uit la o statuie :))
        TravelPlan travelPlan = new TravelPlan("Ce sa vizitez zilnic");
        travelPlan.addVisit(attractions.get(0), LocalDate.of(2024, 5, 14));
        travelPlan.addVisit(attractions.get(1), LocalDate.of(2024, 5, 13));
        travelPlan.addVisit(attractions.get(2), LocalDate.of(2024, 5, 12));

        //Afisare --> travel plan
        System.out.println("\nConcediul meu --> " + travelPlan.getTripName() + " ?");
        for (Attraction attraction : travelPlan.visitSchedule.keySet())
        {
            LocalDate visitDate = travelPlan.getVisitDate(attraction);
            if(attraction instanceof Concert)
            {
                System.out.println("Pe data de " + visitDate + " imi iau bilet la " + attraction.getName());
            }
            else if (attraction instanceof Church){
                System.out.println("Pe data de " + visitDate + " o sa vizitez " + attraction.getName());
            }
            else {
                System.out.println("Pe data de " + visitDate + " ma uit la " + attraction.getName());
            }
        }
        //Ce pot vizita pe gratis
        System.out.println("\nCe poti visita pe gratis:");
        List<Attraction> freeAttractions = myTrip.getVisitableFreeAttractions();
        for (Attraction attraction : freeAttractions)
        {
            //atractiile gratis
            System.out.println(attraction.getName());
        }
    }
}
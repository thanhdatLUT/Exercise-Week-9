package main;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
/**
 * Utility class providing static statistical methods for the championship.
 *
 * <p>All methods are {@code static} — this class is never instantiated.
 * It acts as a pure calculation helper, keeping statistical logic
 * separate from management logic.</p>
 *
 * <p><b>Static Members:</b> Every method is static because statistics
 * are stateless computations over data passed in as arguments.</p>
 *
 * <p><b>SOLID Principles:</b></p>
 * <ul>
 *   <li><b>Single Responsibility:</b> Handles only statistical
 *       calculations — registration and race management belong to
 *       {@link ChampionshipManager}.</li>
 *   <li><b>Open/Closed:</b> New statistics can be added as new static
 *       methods without changing existing ones.</li>
 *   <li><b>Dependency Inversion:</b> Receives a {@link List} of
 *       {@link Driver} objects — it does not depend on
 *       {@link ChampionshipManager} directly.</li>
 * </ul>
 *
 * @author  Doan Vu Thanh Dat
 * @version 1.0
 */
public class ChampionshipStatistics {
 
    /**
     * Private constructor — prevents instantiation of this utility class.
     */
    private ChampionshipStatistics() {}
 
    /**
     * Calculates the average championship points per driver.
     *
     * @param drivers the list of {@link Driver} objects to analyse
     * @return average points as a {@code double}, or {@code 0.0} if
     *         the list is empty
     */
    public static double averagePointsPerDriver(List<Driver> drivers) {
        if (drivers.isEmpty()) return 0.0;
 
        int total = 0;
        for (Driver d : drivers) {
            total += d.getTotalPoints();
        }
        return (double) total / drivers.size();
    }
 
    /**
     * Determines the most successful country by total points.
     *
     * <p>In the event of a tie in total points, the country whose
     * driver appears highest in the registered list wins (i.e. the
     * first driver who pushed that country to the shared maximum).</p>
     *
     * @param drivers the list of {@link Driver} objects to analyse
     * @return the name of the most successful country, or an empty
     *         string if the list is empty
     */
    public static String mostSuccessfulCountry(List<Driver> drivers) {
        Map<String, Integer> countryPoints = new HashMap<>();
 
        for (Driver d : drivers) {
            String country = d.getCountry();
            int newTotal = countryPoints.getOrDefault(country, 0) + d.getTotalPoints();
            countryPoints.put(country, newTotal);
        }
 
        String bestCountry = "";
        int maxPoints = -1;
 
        // Iterate in driver registration order so the first country
        // to reach the shared maximum is chosen — consistent tiebreaker.
        for (Driver d : drivers) {
            String country = d.getCountry();
            int pts = countryPoints.get(country);
            if (pts > maxPoints) {
                maxPoints = pts;
                bestCountry = country;
            }
        }
 
        return bestCountry;
    }
 
    /**
     * Calculates the sum of all championship points awarded so far.
     *
     * @param drivers the list of {@link Driver} objects to sum
     * @return total points across all drivers
     */
    public static int totalChampionshipPoints(List<Driver> drivers) {
        int total = 0;
        for (Driver d : drivers) {
            total += d.getTotalPoints();
        }
        return total;
    }
}
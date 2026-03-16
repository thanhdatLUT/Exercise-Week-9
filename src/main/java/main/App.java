package main;
 
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
 
/**
 * Entry point for the WRC Championship Management System.
 *
 * <p>Demonstrates the full system by:</p>
 * <ol>
 *   <li>Creating cars and drivers.</li>
 *   <li>Recording results for two rally events.</li>
 *   <li>Printing standings, statistics, race results, and car ratings.</li>
 * </ol>
 *
 * @author  Doan Vu Thanh Dat
 * @version 1.0
 */
public class App {
 
    /**
     * Application entry point.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
 
        // ── Singleton: one championship instance ──────────────────────────
        ChampionshipManager manager = ChampionshipManager.getInstance();
 
        // ── Cars (Dependency Inversion: typed as abstract RallyCar) ───────
        RallyCar gravelCar  = new GravelCar("Toyota",  "GR Yaris", 380);
        RallyCar asphaltCar = new AsphaltCar("Hyundai", "i20 N",   360);
 
        // ── Drivers ────────────────────────────────────────────────────────
        Driver ogier    = new Driver("Sébastien Ogier",   "France",  gravelCar);
        Driver rovanpera = new Driver("Kalle Rovanperä",  "Finland", gravelCar);
        Driver tanak    = new Driver("Ott Tänak",         "Estonia", asphaltCar);
        Driver neuville = new Driver("Thierry Neuville",  "Belgium", asphaltCar);
 
        manager.registerDriver(ogier);
        manager.registerDriver(rovanpera);
        manager.registerDriver(tanak);
        manager.registerDriver(neuville);
 
        // ── Rally Finland ──────────────────────────────────────────────────
        RallyRaceResult rallyFinland = new RallyRaceResult("Rally Finland (Jyväskylä)");
        rallyFinland.recordResult(ogier,     1);
        rallyFinland.recordResult(tanak,     2);
        rallyFinland.recordResult(rovanpera, 3);
        rallyFinland.recordResult(neuville,  4);
        manager.addRace(rallyFinland);
 
        // ── Monte Carlo Rally ──────────────────────────────────────────────
        RallyRaceResult monteCarlo = new RallyRaceResult("Monte Carlo Rally (Monaco)");
        monteCarlo.recordResult(rovanpera, 1);
        monteCarlo.recordResult(neuville,  2);
        monteCarlo.recordResult(ogier,     3);
        monteCarlo.recordResult(tanak,     4);
        manager.addRace(monteCarlo);
 
        // ── Championship Standings ─────────────────────────────────────────
        System.out.println("===== CHAMPIONSHIP STANDINGS =====");
        int pos = 1;
        for (Driver d : manager.getStandings()) {
            System.out.println(pos++ + ". " + d.getName()
                    + " (" + d.getCountry() + "): "
                    + d.getTotalPoints() + " points");
        }
 
        // ── Championship Leader ────────────────────────────────────────────
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        Driver leader = manager.getLeader();
        System.out.println(leader.getName() + " with " + leader.getTotalPoints() + " points");
 
        // ── Championship Statistics ────────────────────────────────────────
        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: "   + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: "     + ChampionshipManager.getTotalRaces());
 
        double avg = ChampionshipStatistics.averagePointsPerDriver(manager.getDrivers());
        System.out.printf("Average Points Per Driver: %.2f%n", avg);
 
        String bestCountry = ChampionshipStatistics.mostSuccessfulCountry(manager.getDrivers());
        System.out.println("Most Successful Country: " + bestCountry);
 
        int totalPoints = ChampionshipStatistics.totalChampionshipPoints(manager.getDrivers());
        System.out.println("Total Championship Points: " + totalPoints);
 
        // ── Race Results ───────────────────────────────────────────────────
        System.out.println("\n===== RACE RESULTS =====");
        for (RaceResult race : manager.getRaces()) {
 
            System.out.println("Race: " + race.getRaceName());
 
            HashMap<Driver, Integer> results = race.getResults();
            int position = 1;
 
            for (Map.Entry<Driver, Integer> entry : results.entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue() - a.getValue()) // highest points first
                    .collect(Collectors.toList())) {
 
                System.out.println("Position " + position++ + ": "
                        + entry.getKey().getName()
                        + " - " + entry.getValue() + " points");
            }
            System.out.println();
        }
 
        // ── Car Performance Ratings ────────────────────────────────────────
        System.out.println("===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance:  " + gravelCar.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltCar.calculatePerformance());
    }
}
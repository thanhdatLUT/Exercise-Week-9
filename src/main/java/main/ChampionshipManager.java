package main;
 
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
 
/**
 * Manages the WRC championship — drivers, races, and standings.
 *
 * <p><b>Design Pattern — Singleton:</b> Only one championship can exist
 * at a time. The constructor is private and the sole instance is
 * accessed via {@link #getInstance()}.</p>
 *
 * <p><b>Static Members:</b></p>
 * <ul>
 *   <li>{@code instance}     — the single shared instance.</li>
 *   <li>{@code totalDrivers} — class-level counter of registered drivers.</li>
 *   <li>{@code totalRaces}   — class-level counter of added races.</li>
 * </ul>
 *
 * <p><b>SOLID Principles:</b></p>
 * <ul>
 *   <li><b>Single Responsibility:</b> Manages registration and retrieval
 *       of drivers and races — statistics are delegated to
 *       {@link ChampionshipStatistics}.</li>
 *   <li><b>Dependency Inversion:</b> Stores races as the {@link RaceResult}
 *       interface, not the concrete {@link RallyRaceResult}.</li>
 *   <li><b>Open/Closed:</b> New race types can be added via the
 *       {@link RaceResult} interface without modifying this class.</li>
 * </ul>
 *
 * @author  Doan Vu Thanh Dat
 * @version 1.0
 */
public class ChampionshipManager {
 
    /** The single instance of this class (Singleton pattern). */
    private static ChampionshipManager instance;
 
    /** All drivers registered in the championship. */
    private List<Driver> drivers;
 
    /** All races added to the championship. */
    private List<RaceResult> races;
 
    /**
     * Running count of all registered drivers across the program lifetime.
     * Static so it belongs to the class, not to any instance.
     */
    private static int totalDrivers = 0;
 
    /**
     * Running count of all races added across the program lifetime.
     * Static so it belongs to the class, not to any instance.
     */
    private static int totalRaces = 0;
 
    /**
     * Private constructor — prevents external instantiation.
     * Part of the Singleton pattern.
     */
    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races   = new ArrayList<>();
    }
 
    /**
     * Returns the single shared instance of {@code ChampionshipManager},
     * creating it on first call (lazy initialisation).
     *
     * @return the singleton {@code ChampionshipManager} instance
     */
    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }
 
    /**
     * Registers a driver in the championship and increments the
     * static driver counter.
     *
     * @param driver the {@link Driver} to register
     */
    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }
 
    /**
     * Adds a completed race to the championship and increments the
     * static race counter.
     *
     * @param race the {@link RaceResult} to add
     */
    public void addRace(RaceResult race) {
        races.add(race);
        totalRaces++;
    }
 
    /**
     * Returns the list of drivers sorted by total points, highest first.
     *
     * @return sorted {@link List} of {@link Driver} objects
     */
    public List<Driver> getStandings() {
        List<Driver> sorted = new ArrayList<>(drivers);
        sorted.sort(Comparator.comparingInt(Driver::getTotalPoints).reversed());
        return sorted;
    }
 
    /**
     * Returns the current championship leader (driver with most points).
     * If multiple drivers share the lead, returns the first found.
     *
     * @return the leading {@link Driver}, or {@code null} if no drivers
     *         are registered
     */
    public Driver getLeader() {
        if (drivers.isEmpty()) return null;
 
        Driver leader = drivers.get(0);
        for (Driver d : drivers) {
            if (d.getTotalPoints() > leader.getTotalPoints()) {
                leader = d;
            }
        }
        return leader;
    }
 
    /**
     * Returns the full list of registered drivers (unordered).
     *
     * @return list of all {@link Driver} objects
     */
    public List<Driver> getDrivers() {
        return drivers;
    }
 
    /**
     * Returns the full list of races added to the championship.
     *
     * @return list of all {@link RaceResult} objects
     */
    public List<RaceResult> getRaces() {
        return races;
    }
 
    /**
     * Returns the total number of drivers registered since the program
     * started. Static method — no instance required.
     *
     * @return total driver count
     */
    public static int getTotalDrivers() {
        return totalDrivers;
    }
 
    /**
     * Returns the total number of races added since the program started.
     * Static method — no instance required.
     *
     * @return total race count
     */
    public static int getTotalRaces() {
        return totalRaces;
    }
}
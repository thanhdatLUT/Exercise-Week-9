package main;
 
import java.util.HashMap;
 
/**
 * Contract for any race result implementation in the championship.
 *
 * <p>Defines the three operations every race result must support:
 * recording a driver's finishing position, retrieving the full
 * results map, and returning the race name.</p>
 *
 * <p><b>SOLID Principles:</b></p>
 * <ul>
 *   <li><b>Interface Segregation:</b> Exposes only the minimal set of
 *       methods consumers need — no bloated base class.</li>
 *   <li><b>Dependency Inversion:</b> High-level modules such as
 *       {@link ChampionshipManager} depend on this abstraction, not
 *       on {@link RallyRaceResult} directly.</li>
 *   <li><b>Open/Closed:</b> New race formats (e.g. sprint stages) can
 *       be added by implementing this interface without touching
 *       existing code.</li>
 * </ul>
 *
 * @author  Doan Vu Thanh Dat
 * @version 1.0
 */
public interface RaceResult {
 
    /**
     * Records a driver's finishing position and converts it to
     * championship points.
     *
     * @param driver   the driver who finished in this position
     * @param position the finishing position (1 = first place)
     */
    void recordResult(Driver driver, int position);
 
    /**
     * Returns the full results map for this race.
     *
     * @return a {@link HashMap} mapping each {@link Driver} to their
     *         earned points in this race
     */
    HashMap<Driver, Integer> getResults();
 
    /**
     * Returns the human-readable name of this race.
     *
     * @return race name string
     */
    String getRaceName();
}
 